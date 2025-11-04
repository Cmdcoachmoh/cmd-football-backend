import React, { useState } from "react";
import "./DrillBuilder.css";

export default function DrillBuilder() {
  const [drills, setDrills] = useState([]);
  const [newDrill, setNewDrill] = useState("");

  const addDrill = () => {
    if (newDrill.trim()) {
      setDrills([...drills, { name: newDrill, completed: false }]);
      setNewDrill("");
    }
  };

  const toggleDrill = (index) => {
    const updated = [...drills];
    updated[index].completed = !updated[index].completed;
    setDrills(updated);
  };

  return (
    <div className="drill-builder">
      <h2>🛠️ Drill Builder</h2>
      <input
        type="text"
        placeholder="Enter drill name"
        value={newDrill}
        onChange={(e) => setNewDrill(e.target.value)}
      />
      <button onClick={addDrill}>Add Drill</button>

      <ul>
        {drills.map((drill, index) => (
          <li
            key={index}
            className={drill.completed ? "completed" : ""}
            onClick={() => toggleDrill(index)}
          >
            {drill.name}
          </li>
        ))}
      </ul>
    </div>
  );
}
