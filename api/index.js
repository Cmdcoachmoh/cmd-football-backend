const express = require("express");
const cors = require("cors");
const { createClient } = require("@supabase/supabase-js");
require("dotenv").config();

const app = express();

// Initialize Supabase
const supabase = createClient(
  process.env.SUPABASE_URL,
  process.env.SUPABASE_KEY
);

app.use(cors());
app.use(express.json());

// ✅ Health check
app.get("/api/health", (req, res) => {
  res.status(200).json({ status: "CMD Football Backend is healthy ✅" });
});

// ✅ Get all players
app.get("/api/players", async (req, res) => {
  const { data, error } = await supabase.from("players").select("*");
  if (error) return res.status(500).json({ error: error.message });
  res.status(200).json(data);
});

// ✅ Get single player by ID
app.get("/api/player", async (req, res) => {
  const { id } = req.query;
  const { data, error } = await supabase.from("players").select("*").eq("id", id).single();
  if (error) return res.status(404).json({ error: "Player not found" });
  res.status(200).json(data);
});

// ✅ Create new player
app.post("/api/players", async (req, res) => {
  const { name, age, position, team } = req.body;
  if (!name || !age || !position || !team) {
    return res.status(400).json({ error: "Missing required fields" });
  }

  const { data, error } = await supabase.from("players").insert([{ name, age, position, team }]);
  if (error) return res.status(500).json({ error: error.message });
  res.status(201).json(data);
});

// Export for Vercel
module.exports = app;