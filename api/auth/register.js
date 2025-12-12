import bcrypt from "bcryptjs";
import { connectDB } from "../_lib/db";

export default async function handler(req, res) {
  if (req.method !== "POST") {
    return res.status(405).json({ error: "Method not allowed" });
  }

  const { name, email, password } = req.body;

  try {
    const { db } = await connectDB();

    const existing = await db.collection("users").findOne({ email });
    if (existing) {
      return res.status(400).json({ error: "Email already registered" });
    }

    const hashed = await bcrypt.hash(password, 10);

    const user = {
      name,
      email,
      password: hashed,
      createdAt: new Date()
    };

    await db.collection("users").insertOne(user);

    res.status(201).json({ message: "User registered", user: { name, email } });
  } catch (err) {
    res.status(500).json({ error: "Server error", details: err.message });
  }
}

