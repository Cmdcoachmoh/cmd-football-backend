import { supabase } from "../lib/supabase.js";


const supabase = createClient(
  process.env.SUPABASE_URL,
  process.env.SUPABASE_SERVICE_ROLE_KEY
);

export default async function handler(req, res) {
  const { method } = req;

  if (method === "GET") {
    try {
      const { data, error } = await supabase.from("players").select("*");

      if (error) {
        console.error("Supabase error:", error.message);
        return res.status(500).json({ error: error.message });
      }

      return res.status(200).json(data);
    } catch (err) {
      console.error("Unexpected error:", err.message);
      return res.status(500).json({ error: "Unexpected server error" });
    }
  }

  res.setHeader("Allow", ["GET"]);
  return res.status(405).json({ error: `Method ${method} Not Allowed` });
}
