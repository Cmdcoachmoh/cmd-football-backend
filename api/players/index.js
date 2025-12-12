import { requireAuth } from "../_lib/auth";
import { connectDB } from "../_lib/db";

async function handler(req, res) {
  const { db } = await connectDB();

  const players = await db.collection("players").find().toArray();

  res.status(200).json({ players });
}

export default requireAuth(handler);
