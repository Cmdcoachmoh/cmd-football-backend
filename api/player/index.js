export default function handler(req, res) {
  if (req.method === "GET") {
    // Example: return mock player list
    const players = [
    { id: "p001", name: "Adam Traoré", age: 12, jugllinglevel: "Basic Level", position: "Midfielder", team: "U12 Elite" },
    { id: "p002", name: "Yacouba Ouédraogo",age: 14, jugllinglevel: "Sequence 2", position: "Forward", team: "U14 Elite" },
    { id: "p003", name: "Mohamed Diabaté", age: 15, jugllinglevel: "Exterior Interior", position: "Defender", team: "U15 Elite" }
    ];
    res.status(200).json({ players });
  } else {
    res.status(405).json({ error: "Method not allowed" });
  }
}
