export default function handler(req, res) {
  // Example: return mock stats
  const stats = [
    { playerId: "p001", goals: 12, assists: 5 },
    { playerId: "p002", goals: 8, assists: 7 }
  ];
  res.status(200).json({ stats });
}
