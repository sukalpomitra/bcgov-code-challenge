import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import { toastConfig } from "react-simple-toasts";
import "react-simple-toasts/dist/theme/success.css";
import "react-simple-toasts/dist/theme/info.css";
import "react-simple-toasts/dist/theme/failure.css";
import "react-simple-toasts/dist/theme/warning.css";
import "react-simple-toasts/dist/theme/dark.css"; // import the desired theme

import "./App.css";

import Layout from "components/Layout";

import VolunteerFormPage from "pages/volunteer/forms";
import GeneralView from "pages/general";
import AdminView from "pages/admin";

function App() {
  // specify the theme in toastConfig
  toastConfig({
    theme: "dark",
  });

  return (
    <Router>
      <Layout>
        <Routes>
          <Route path="/" element={<GeneralView />} />
          <Route path="/govemployee" element={<GeneralView />} />
          <Route path="/govemployee/volunteer" element={<VolunteerFormPage />} />
          <Route path="/govemployee/admin" element={<AdminView />} />
        </Routes>
      </Layout>
    </Router>
  );
}

export default App;
