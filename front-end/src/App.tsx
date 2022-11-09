import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

import Cadastro from "./pages/Aves";
import Catalogo from "./pages/Catalogo";
import Home from "./pages/Home";
import Login from "./pages/Login";
import NaoEncontrado from "./pages/NaoEncontrado";

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="cadastro" element={<Cadastro />} />
        <Route path="login" element={<Login />} />
        <Route path="*" element={<NaoEncontrado />} />
        <Route path="catalogo" element={<Catalogo />} />
      </Routes>
    </Router>
  );
};

export default App;
