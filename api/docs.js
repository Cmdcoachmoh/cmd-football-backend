// /api/docs.js

export default function handler(req, res) {
  return res.status(200).json({
    name: "CMD Football Backend API",
    status: "running",
    version: "1.0.0",
    description: "Official API documentation for CMD Football backend services.",
    endpoints: {
      health: {
        method: "GET",
        path: "/api/health",
        description: "Check backend uptime and status."
      },
      auth: {
        methods: ["POST"],
        paths: {
          login: "/api/auth?login",
          register: "/api/auth?register"
        },
        description: "User authentication and registration."
      },
      players: {
        method: "GET",
        path: "/api/players",
        description: "List all players."
      },
      player: {
        methods: ["GET", "POST", "PUT", "DELETE"],
        path: "/api/player?id={id}",
        description: "CRUD operations for a single player."
      },
      growth: {
        methods: ["GET", "POST", "PUT", "DELETE"],
        path: "/api/growth",
        description: "Track and manage player growth metrics."
      }
    },
    timestamp: Date.now()
  });
}
