export default function handler(req, res) {
  // Example: return mock growth data
  const growthData = [
    { playerId: "p001", height: 180, weight: 75, age: 16 },
    { playerId: "p002", height: 172, weight: 68, age: 15 }
  ];
  res.status(200).json({ growth: growthData });
}
