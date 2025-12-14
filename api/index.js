// /api/index.js

export default function handler(req, res) {
  return res.status(200).json({
    message: "CMD Football Backend API",
    status: "running",
    version: "1.0.0",
    endpoints: {
      health: "/api/health",
      auth: "/api/auth?login | /api/auth?register",
      players: "/api/players",
      player: "/api/player?id={id}",
      growth: "/api/growth"
    },
    timestamp: Date.now()
  });
}
