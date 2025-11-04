import React from 'react';
import { Line } from 'react-chartjs-2';
import {
  Chart as ChartJS,
  LineElement,
  PointElement,
  CategoryScale,
  LinearScale,
  Title,
  Tooltip,
  Legend
} from 'chart.js';

ChartJS.register(LineElement, PointElement, CategoryScale, LinearScale, Title, Tooltip, Legend);

const ProgressChart = ({ playerName, weeks, vo2Data }) => {
  const data = {
    labels: weeks,
    datasets: [
      {
        label: `${playerName} VO₂ Progression`,
        data: vo2Data,
        fill: false,
        borderColor: '#0077cc',
        backgroundColor: '#0077cc',
        tension: 0.3,
        pointRadius: 5,
        pointHoverRadius: 7
      }
    ]
  };

  const options = {
    responsive: true,
    plugins: {
      title: {
        display: true,
        text: 'VO₂ Max Progression Over Time'
      },
      legend: {
        display: true,
        position: 'bottom'
      }
    },
    scales: {
      y: {
        beginAtZero: true,
        title: {
          display: true,
          text: 'VO₂ Max (ml/kg/min)'
        }
      },
      x: {
        title: {
          display: true,
          text: 'Training Weeks'
        }
      }
    }
  };

  return <Line data={data} options={options} />;
};

export default ProgressChart;
