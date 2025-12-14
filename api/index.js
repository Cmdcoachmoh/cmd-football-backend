// index.js
// CMD Football Backend – Root Entry Point

import express from "express";
import cors from "cors";
import dotenv from "dotenv";

dotenv.config();

const app = express();
app.use(cors());
app.use(express.json());

// ✅ Root route (optional)
app.get("/", (req, res) => {
  res.json({
    message: "CMD Football Backend is running",
    version: "1.0.0",
    status: "ok",
  });
});

// ✅ Health check
app.get("/api/health", (req, res) => {
  res.json({ status: "ok", timestamp: Date.now() });
});

// ✅ Example Supabase connection (optional)
import { createClient } from "@supabase/supabase-js";

const supabase = createClient(
  process.env.SUPABASE_URL,
  process.env.SUPABASE_SERVICE_ROLE_KEY
);

// ✅ Example route using Supabase
app.get("/api/players", async (req, res) => {
  const { data, error } = await supabase.from("players").select("*");

  if (error) {
    return res.status(500).json({ error: error.message });
  }

  res.json(data);
});

// ✅ Local development server
// (Vercel ignores this — only used when running `npm start`)
const PORT = process.env.PORT || 3000;
if (process.env.NODE_ENV !== "production") {
  app.listen(PORT, () => {
    console.log(`Backend running locally on port ${PORT}`);
  });
}

export default app;
