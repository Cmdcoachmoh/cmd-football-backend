module.exports = async (req, res) => {
  const dbStatus = "connected"; // Replace with actual DB check if needed
  const timestamp = new Date().toISOString();

  res.status(200).json({
    status: "ok",
    service: "CMD Football Backend",
    database: dbStatus,
    timestamp
  });
};
