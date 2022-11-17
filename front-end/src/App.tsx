import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import Cadastro from "./Pages/Aves";
import Catalogo from "./Pages/Catalogo";
import Home from "./Pages/Home";
import Login from "./Pages/Users/Login";
import NaoEncontrado from "./Pages/NaoEncontrado";
import Register from "./Pages/Users/Register";
import CadastroAvistamento from "./Pages/Annotation/Register";
import Anotacoes from "./Pages/Annotation/Annotations";

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/home" element={<Home />} />
        <Route path="/cadastro" element={<Cadastro />} />
        <Route path="/register" element={<Register />} />
        <Route path="/" element={<Login />} />
        <Route path="*" element={<NaoEncontrado />} />
        <Route path="/catalogo" element={<Catalogo />} />
        <Route path="/avistamento" element={<CadastroAvistamento />} />
        <Route path="/anotacoes" element={<Anotacoes />} />
      </Routes>
    </Router>
  );
};

export default App;
