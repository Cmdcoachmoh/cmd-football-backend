import React, { useState } from "react";
import { Routes, Route } from "react-router-dom";
import Landing from "./components/Landing";
import Dashboard from "./components/Dashboard";
import DrillBuilder from "./components/DrillBuilder";
import TeamReport from "./components/TeamReport";
import ExamEntry from "./components/ExamEntry";
import PrivateRoute from "./components/PrivateRoute";
import Dashboard from "./components/Dashboard";


function App() {
  const [loggedIn, setLoggedIn] = useState(true); // You can wire this to login flow later

  return (
    <Routes>
      <Route path="/" element={<Landing />} />
      <Route
        path="/dashboard"
        element={
          <PrivateRoute loggedIn={loggedIn}>
            <Dashboard />
          </PrivateRoute>
        }
      />
      <Route
        path="/drill-builder"
        element={
          <PrivateRoute loggedIn={loggedIn}>
            <DrillBuilder />
          </PrivateRoute>
        }
      />
      <Route
        path="/team-report"
        element={
          <PrivateRoute loggedIn={loggedIn}>
            <TeamReport />
          </PrivateRoute>
        }
      />
      <Route
        path="/exam-entry"
        element={
          <PrivateRoute loggedIn={loggedIn}>
            <ExamEntry />
          </PrivateRoute>
        }
      />
    </Routes>
  );
  
}

export default App;
