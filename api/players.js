module.exports = async (req, res) => {
  if (req.method === "POST") {
    const { name, age, position, team } = req.body;

    if (!name || !age || !position || !team) {
      return res.status(400).json({ error: "Missing required fields" });
    }

    const newPlayer = {
      id: Date.now().toString(),
      name,
      age,
      position,
      team
    };

    // In real DB: insert newPlayer
    return res.status(201).json(newPlayer);
  }

  // GET: return all players
  const players = [
    { id: "1", name: "Adam Traoré", age: 12, jugllinglevel: "Basic Level", position: "Midfielder", team: "U12 Elite" },
    { id: "2", name: "Yacouba Ouédraogo",age: 14, jugllinglevel: "Sequence 2", position: "Forward", team: "U14 Elite" },
    { id: "3", name: "Mohamed Diabaté", age: 15, jugllinglevel: "Exterior Interior", position: "Defender", team: "U15 Elite" }
  ];

  res.status(200).json(players);
};


