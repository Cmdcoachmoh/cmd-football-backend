import express from "express";
import cors from "cors";
import healthRoute from "./routes/health";
import statusRoute from "./routes/status";
import dotenv from 'dotenv';
dotenv.config();




const app = express();
const PORT = process.env.PORT || 3000;

app.use(cors());
app.use(express.json());
app.use("/api", statusRoute);

// ✅ Health check route
app.use("/api", healthRoute);

// ✅ Optional root route
app.get("/", (_req, res) => {
  res.send("CMD Football backend is running.");
});

app.listen(PORT, () => {
  console.log(`🚀 Server running on port ${PORT}`);
});


