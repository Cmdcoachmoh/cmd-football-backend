// /api/auth.js
import { supabase } from "../lib/supabase.js";


const supabase = createClient(
  process.env.SUPABASE_URL,
  process.env.SUPABASE_ANON_KEY
);

export default async function handler(req, res) {
  const { method, url, body } = req;

  // ✅ REGISTER: POST /api/auth?register
  if (method === "POST" && url.includes("register")) {
    const { email, password, ...profile } = body;

    const { data, error } = await supabase.auth.signUp({
      email,
      password,
      options: { data: profile }
    });

    if (error) return res.status(400).json({ error: error.message });
    return res.status(201).json({ user: data.user });
  }

  // ✅ LOGIN: POST /api/auth?login
  if (method === "POST" && url.includes("login")) {
    const { email, password } = body;

    const { data, error } = await supabase.auth.signInWithPassword({
      email,
      password
    });

    if (error) return res.status(400).json({ error: error.message });
    return res.status(200).json({ user: data.user, session: data.session });
  }

  // ✅ Unsupported method
  res.setHeader("Allow", ["POST"]);
  return res.status(405).json({ error: `Method ${method} Not Allowed` });
}
