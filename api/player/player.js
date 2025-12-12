module.exports = async (req, res) => {
  const { id } = req.query;

  // Mock DB for now
  const players = [
    { id: "1", name: "Adam Traoré", age: 12, jugllinglevel: "Basic Level", position: "Defender", team: "U12 Elite" },
    { id: "2", name: "Yacouba Ouédraogo",age: 14, jugllinglevel: "Sequence 2", position: "Defender", team: "U14 Elite" },
    { id: "3", name: "Mohamed Diabaté", age: 15, jugllinglevel: "Exterior Interior", position: "Defender", team: "U15 Elite" }
  ];

  const player = players.find((p) => p.id === id);

  if (!player) {
    return res.status(404).json({ error: "Player not found" });
  }

  res.status(200).json(player);
};
