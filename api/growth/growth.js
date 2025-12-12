// api/player.js
const express = require("express");
const { createServer } = require("@vercel/node");

const app = express();

app.get("/api/player/:id/growth", (req, res) => {
  const { id } = req.params;
  const score = 85; // Replace with real logic
  res.json({ name: `Player ${id}`, score });
});

module.exports = createServer(app);
