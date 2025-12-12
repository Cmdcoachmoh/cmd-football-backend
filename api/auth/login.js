import bcrypt from "bcryptjs";
import jwt from "jsonwebtoken";
import { connectDB } from "../_lib/db";

export default async function handler(req, res) {
  if (req.method !== "POST") {
    return res.status(405).json({ error: "Method not allowed" });
  }

  const { email, password } = req.body;

  try {
    const { db } = await connectDB();

    const user = await db.collection("users").findOne({ email });
    if (!user) {
      return res.status(401).json({ error: "Invalid credentials" });
    }

    const valid = await bcrypt.compare(password, user.password);
    if (!valid) {
      return res.status(401).json({ error: "Invalid credentials" });
    }

    const token = jwt.sign(
      { id: user._id, email: user.email },
      process.env.JWT_SECRET,
      { expiresIn: "7d" }
    );

    res.status(200).json({ token, user: { name: user.name, email: user.email } });
  } catch (err) {
    res.status(500).json({ error: "Server error", details: err.message });
  }
}
