import { supabase } from "../lib/supabase.js";

export default async function handler(req, res) {
  try {
    console.log("Testing Supabase connection...");

    const { data, error } = await supabase
      .from("players") // Make sure this matches your Supabase table name exactly
      .select("id")    // Narrow query to avoid large payloads
      .limit(1);

    if (error) {
      console.error("Supabase error:", error.message);
      return res.status(500).json({ error: error.message });
    }

    return res.status(200).json({ ok: true, data });
  } catch (err) {
    console.error("Unexpected error:", err.message);
    return res.status(500).json({ error: "Unexpected server error" });
  }
}
