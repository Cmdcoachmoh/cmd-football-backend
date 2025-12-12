export default function handler(req, res) {
  const { id } = req.query;

  // Example: return mock player data
  const player = { id, name: "Ali", position: "Midfielder", age: 16 };

  res.status(200).json({ player });
}
