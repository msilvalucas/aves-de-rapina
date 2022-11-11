import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

import Cadastro from "./Pages/Aves";
import Catalogo from "./Pages/Catalogo";
import Home from "./Pages/Home";
import Login from "./Pages/Users/Login";
import NaoEncontrado from "./Pages/NaoEncontrado";
import Register from "./Pages/Users/Register";

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/cadastro" element={<Cadastro />} />
        <Route path="/register" element={<Register />} />
        <Route path="login" element={<Login />} />
        <Route path="*" element={<NaoEncontrado />} />
        <Route path="/catalogo" element={<Catalogo />} />
      </Routes>
    </Router>
  );
};

export default App;
