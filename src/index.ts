import express from "express";
import cors from "cors";
import dotenv from "dotenv";
import supabase from "lib/supabase";
import sendEmail from "emails/sendEmail";
import playerRoutes from "routes/players";
import progressRoutes from "routes/progress";




dotenv.config();

const app = express();
const PORT = process.env.PORT || 3000;

app.use(cors());
app.use(express.json());
app.use("/api", playerRoutes);
app.use("/api", progressRoutes);


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

// ✅ Send templated email
app.post("/api/send-email", async (req, res) => {
  try {
    await sendEmail(req.body);
    res.status(200).json({ message: "Email sent successfully ✅" });
  } catch (err) {
    res.status(500).json({ error: "Email failed to send" });
  }
});

app.listen(PORT, () => {
  console.log(`CMD Football Backend is running locally 🚀 on port ${PORT}`);
});
