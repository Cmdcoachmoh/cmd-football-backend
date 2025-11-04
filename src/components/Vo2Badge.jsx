export default function Vo2Badge({ vo2 }) {
  const isElite = vo2 >= 160;
  return (
    <span style={{
      backgroundColor: isElite ? "#28a745" : "#6c757d",
      color: "#fff",
      padding: "6px 12px",
      borderRadius: "12px",
      fontWeight: "bold",
      marginLeft: "10px"
    }}>
      {isElite ? "🏅 Elite" : "Training"}
    </span>
  );
}
