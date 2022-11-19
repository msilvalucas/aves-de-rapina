import React, { useState } from "react";

import { NavDropdown } from "react-bootstrap";

import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import { Link } from "react-router-dom";

import "./index.css";
const logotipo = require("../../assets/logotipo.png");

const Menu = () => {
  const [isLoggedin, setIsLoggedin] = useState<boolean>(false);

  const logout = () => {
    localStorage.removeItem("userName");
    localStorage.removeItem("access_token");
    setIsLoggedin(false);
  };
  return (
    <>
      <Navbar className="menu navbar navbar-expand-lg">
        <Container>
          <Navbar.Brand className="logo">
            <Link to="/home">
              <img src={logotipo} className="logo-passarinho" />
            </Link>
          </Navbar.Brand>

          <Nav className="me-auto">
            <Nav.Link className="last">
              <Link to="/home">Home</Link>
            </Nav.Link>
            <NavDropdown
              title="Aves"
              id="basic-nav-dropdown"
              menuVariant="dark"
            >
              <NavDropdown.Item className="dropdown-item">
                <Link to="/cadastro">Cadastrar Ave</Link>
              </NavDropdown.Item>
              <NavDropdown.Item>
                <Link to="/catalogo">Catálogo</Link>
              </NavDropdown.Item>
            </NavDropdown>
            <NavDropdown
              title="Avistamentos"
              id="basic-nav-dropdown"
              menuVariant="dark"
            >
              <NavDropdown.Item className="dropdown-item">
                <Link to="/avistamento">Cadastrar Avistamentos</Link>
              </NavDropdown.Item>
              <NavDropdown.Item>
                <Link to="/anotacoes">Avistamentos</Link>
              </NavDropdown.Item>
            </NavDropdown>
            <Nav.Link className="last">
              <Link onClick={logout} to="/">
                Sair
              </Link>
            </Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </>
  );
};

export default Menu;
