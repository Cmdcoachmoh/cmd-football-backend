// /api/health.js
export default function handler(req, res) {
  if (req.method === "GET") {
    return res.status(200).json({
      status: "ok",
      service: "CMD Football Backend",
      timestamp: Date.now()
    });
  }

  res.setHeader("Allow", ["GET"]);
  return res.status(405).json({ error: `Method ${req.method} Not Allowed` });
}

