// api/index.js
module.exports = (req, res) => {
  res.json({
    status: "ok",
    message: "CMD Football Backend is running 🚀",
    timestamp: new Date().toISOString()
  });
};
