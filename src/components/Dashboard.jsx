import React, { useState, useEffect } from "react";
import { Line } from "react-chartjs-2";
import "chart.js/auto";
import Vo2Badge from "./Vo2Badge";

export default function Dashboard() {
  const [effortScore, setEffortScore] = useState(null);
  const [chartData, setChartData] = useState({ labels: [], datasets: [] });
  const [loading, setLoading] = useState(true);
  const [downloading, setDownloading] = useState(false);

  const handleDownload = (type) => {
    const endpoint = type === "pdf" ? "/api/export/pdf" : "/api/export/csv";
    setDownloading(true);

    fetch(`https://cmd-football-backend-production.up.railway.app${endpoint}`, {
      method: "GET",
      headers: {
        Authorization: "Basic " + btoa("admin:adminpass")
      }
    })
      .then((res) => {
        if (!res.ok) throw new Error("Download failed");
        return res.blob();
      })
      .then((blob) => {
        const url = window.URL.createObjectURL(blob);
        const a = document.createElement("a");
        a.href = url;
        a.download = `CMD_Football_Report_${new Date().toISOString().slice(0, 10)}.${type}`;
        a.click();
      })
      .catch((err) => alert("Download failed: " + err.message))
      .finally(() => setDownloading(false));
  };

  useEffect(() => {
    fetch("https://cmd-football-backend-production.up.railway.app/api/dashboard/metrics", {
      headers: {
        Authorization: "Basic " + btoa("admin:adminpass")
      }
    })
      .then(res => res.json())
      .then(data => {
        setEffortScore(data.effortScore);

        const labels = Array.isArray(data.growth) ? data.growth.map(p => p.name) : [];
        const scores = Array.isArray(data.growth) ? data.growth.map(p => p.score) : [];

        setChartData({
          labels,
          datasets: [
            {
              label: "Player Growth",
              data: scores,
              fill: false,
              borderColor: "#28a745",
              tension: 0.3
            }
          ]
        });

        setLoading(false);
      })
      .catch(err => {
        console.error("Failed to fetch metrics:", err);
        setLoading(false);
      });
  }, []);

  const chartOptions = {
    responsive: true,
    plugins: {
      legend: { display: true },
      tooltip: { enabled: true }
    },
    scales: {
      y: {
        beginAtZero: true,
        title: { display: true, text: "Growth Score" }
      },
      x: {
        title: { display: true, text: "Player" }
      }
    }
  };

  return (
    <div style={{ textAlign: "center", padding: "40px", fontFamily: "Arial" }}>
      <h1>CMD Football Dashboard</h1>
      <p>Welcome, Coach Mohamad 👟</p>

      {effortScore !== null && (
        <div style={{ marginBottom: "20px" }}>
          <span
            style={{
              backgroundColor: "#ffc107",
              padding: "10px 20px",
              borderRadius: "20px",
              fontWeight: "bold",
              fontSize: "18px"
            }}
          >
            Effort Score: {effortScore}%
          </span>
        </div>
      )}

      <div style={{ marginBottom: "20px" }}>
        <button
          onClick={() => handleDownload("pdf")}
          disabled={downloading}
          style={{
            padding: "12px 24px",
            marginRight: "10px",
            backgroundColor: "#007bff",
            color: "#fff",
            border: "none",
            borderRadius: "6px",
            cursor: "pointer",
            opacity: downloading ? 0.6 : 1
          }}
        >
          📄 Download PDF
        </button>

        <button
          onClick={() => handleDownload("csv")}
          disabled={downloading}
          style={{
            padding: "12px 24px",
            backgroundColor: "#17a2b8",
            color: "#fff",
            border: "none",
            borderRadius: "6px",
            cursor: "pointer",
            opacity: downloading ? 0.6 : 1
          }}
        >
          📊 Download CSV
        </button>
      </div>

      {loading ? (
        <p>Loading metrics...</p>
      ) : chartData.labels.length > 0 ? (
        <div style={{ width: "80%", margin: "0 auto" }} aria-label="Player Growth Chart" role="img">
          <Line data={chartData} options={chartOptions} />
          <div style={{ marginTop: "20px" }}>
            {chartData.labels.map((name, index) => (
              <div key={name} style={{ marginBottom: "10px" }}>
                {name}
                <Vo2Badge vo2={chartData.datasets[0].data[index]} eliteThreshold={85} />
              </div>
            ))}
          </div>
        </div>
      ) : (
        <p>No data available</p>
      )}
    </div>
  );
}
