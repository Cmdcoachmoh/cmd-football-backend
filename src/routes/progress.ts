import express from "express";
import supabase from "lib/supabase";
import sendEmail from "emails/sendEmail";

const router = express.Router();

// ✅ Update a player's juggling level
router.patch("/progress", async (req, res) => {
  const { id, level } = req.query;

  if (!id || !level) {
    return res.status(400).json({ error: "Missing player ID or level" });
  }

  const newLevel = parseInt(level as string);
  if (isNaN(newLevel)) {
    return res.status(400).json({ error: "Level must be a number" });
  }

  // ✅ Update in Supabase
  const { data, error } = await supabase
    .from("players")
    .update({ juggling_level: newLevel })
    .eq("id", id)
    .select();

  if (error) return res.status(500).json({ error: error.message });
  if (!data || data.length === 0) {
    return res.status(404).json({ error: "Player not found" });
  }

  const player = data[0];

  // ✅ Send milestone email
  await sendEmail({
    to: "coach@cmd-football.ca",
    subject: "Player Progress Update",
    template: "milestone",
    data: {
      playerName: player.name,
      milestone: `Juggling level ${newLevel}`,
      logoUrl: "https://cmd-football.ca/assets/logo.png",
      language: "en"
    }
  });

  return res.status(200).json({
    message: "Progress updated successfully",
    player
  });
});

export default router;

