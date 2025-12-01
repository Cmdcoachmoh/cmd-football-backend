import express from "express";

const router = express.Router();

router.get("/health", (_req, res) => {
  res.status(200).json({
    status: "ok",
    timestamp: new Date().toISOString(),
    service: "cmd-football-backend"
  });
});

export default router;




