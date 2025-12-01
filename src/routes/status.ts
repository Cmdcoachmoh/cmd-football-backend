import express from "express";
import { readFileSync } from "fs";
import { join } from "path";

const router = express.Router();

const startTime = Date.now();

router.get("/status", (_req, res) => {
  const uptime = process.uptime();
  const version = JSON.parse(
    readFileSync(join(process.cwd(), "package.json"), "utf-8")
  ).version;

  res.status(200).json({
    status: "ok",
    version,
    uptime: `${Math.floor(uptime)}s`,
    timestamp: new Date().toISOString()
  });
});

export default router;
