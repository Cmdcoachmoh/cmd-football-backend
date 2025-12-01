// api/player.js
const express = require("express");
const { createServer } = require("@vercel/node");

const app = express();

app.get("/api/player/:id/growth", (req, res) => {
  res.json({ name: "Player " + req.params.id, score: 85 });
});

module.exports = createServer(app);
