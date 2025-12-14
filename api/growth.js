// /api/growth.js
import { createClient } from "@supabase/supabase-js";

const supabase = createClient(
  process.env.SUPABASE_URL,
  process.env.SUPABASE_SERVICE_ROLE_KEY
);

export default async function handler(req, res) {
  const { method, query, body } = req;

  // ✅ GET /api/growth → list all growth records
  if (method === "GET") {
    const { data, error } = await supabase.from("growth").select("*");

    if (error) return res.status(500).json({ error: error.message });
    return res.status(200).json(data);
  }

  // ✅ POST /api/growth → create a new growth record
  if (method === "POST") {
    const { data, error } = await supabase.from("growth").insert([body]);

    if (error) return res.status(500).json({ error: error.message });
    return res.status(201).json(data);
  }

  // ✅ PUT /api/growth?id=123 → update a growth record
  if (method === "PUT") {
    const { data, error } = await supabase
      .from("growth")
      .update(body)
      .eq("id", query.id);

    if (error) return res.status(500).json({ error: error.message });
    return res.status(200).json(data);
  }

  // ✅ DELETE /api/growth?id=123 → delete a growth record
  if (method === "DELETE") {
    const { error } = await supabase.from("growth").delete().eq("id", query.id);

    if (error) return res.status(500).json({ error: error.message });
    return res.status(204).end();
  }

  res.setHeader("Allow", ["GET", "POST", "PUT", "DELETE"]);
  return res.status(405).json({ error: `Method ${method} Not Allowed` });
}
