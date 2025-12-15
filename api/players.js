import { supabase } from "../lib/supabase.js";

export default async function handler(req, res) {
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
