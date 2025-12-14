// /api/players.js
import { createClient } from "@supabase/supabase-js";

const supabase = createClient(
  process.env.SUPABASE_URL,
  process.env.SUPABASE_SERVICE_ROLE_KEY
);

export default async function handler(req, res) {
  const { method } = req;

  // ✅ GET /api/players → list all players
  if (method === "GET") {
    const { data, error } = await supabase.from("players").select("*");

    if (error) return res.status(500).json({ error: error.message });
    return res.status(200).json(data);
  }

  res.setHeader("Allow", ["GET"]);
  return res.status(405).json({ error: `Method ${method} Not Allowed` });
}



