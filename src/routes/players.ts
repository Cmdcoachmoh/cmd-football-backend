import express from "express";
import supabase from "lib/supabase";

const router = express.Router();

// ✅ Get all players
router.get("/players", async (req, res) => {
  const { data, error } = await supabase.from("players").select("*");
  if (error) return res.status(500).json({ error: error.message });
  res.status(200).json(data);
});

// ✅ Get single player by ID
router.get("/player", async (req, res) => {
  const { id } = req.query;
  if (!id) return res.status(400).json({ error: "Missing player ID" });

  const { data, error } = await supabase.from("players").select("*").eq("id", id).single();
  if (error) return res.status(404).json({ error: "Player not found" });
  res.status(200).json(data);
});

// ✅ Create new player
router.post("/players", async (req, res) => {
  const { name, age, position, team } = req.body;
  if (!name || !age || !position || !team) {
    return res.status(400).json({ error: "Missing required fields" });
  }

  const { data, error } = await supabase.from("players").insert([{ name, age, position, team }]);
  if (error) return res.status(500).json({ error: error.message });
  res.status(201).json(data);
});

export default router;
