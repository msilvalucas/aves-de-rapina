import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

import Cadastro from "./Pages/Cadastro";
import Home from "./Pages/Home";
import Login from "./Pages/Login";
import NaoEncontrado from "./Pages/NaoEncontrado";

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="cadastro" element={<Cadastro />} />
        <Route path="login" element={<Login />} />
        <Route path="*" element={<NaoEncontrado />} />
      </Routes>
    </Router>
  );
};

export default App;
