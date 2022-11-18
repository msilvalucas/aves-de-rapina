import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import Cadastro from "./pages/Aves/index";
import Catalogo from "./pages/Catalogo";
import Home from "./pages/Home";
import Login from "./pages/Users/Login";
import NaoEncontrado from "./pages/NaoEncontrado";
import Register from "./pages/Users/Register";
import CadastroAvistamento from "./pages/Avistamentos/Register";
import Anotacoes from "./pages/Avistamentos/Annotations";

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/cadastro" element={<Cadastro />} />
        <Route path="/register" element={<Register />} />
        <Route path="/home" element={<Home />} />
        <Route path="*" element={<NaoEncontrado />} />
        <Route path="/catalogo" element={<Catalogo />} />
        <Route path="/avistamento" element={<CadastroAvistamento />} />
        <Route path="/anotacoes" element={<Anotacoes />} />
      </Routes>
    </Router>
  );
};

export default App;
