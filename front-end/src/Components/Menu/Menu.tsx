import React from "react";
import { DropdownButton, Dropdown, NavDropdown } from "react-bootstrap";

import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import { Link } from "react-router-dom";

import "./index.css";

const logotipo = require("../../assets/logotipo.png");

const Menu = () => {
  return (
    <>
      <Navbar className="menu navbar navbar-expand-lg">
        <Container>
          <Navbar.Brand href="/home" className="logo">
            <img src={logotipo} className="logo-passarinho" />
          </Navbar.Brand>

          <Nav className="me-auto">
            <Nav.Link href="/home">
              <Link to="/home">Home</Link>
            </Nav.Link>
            <NavDropdown
              title="Aves"
              id="basic-nav-dropdown"
              menuVariant="dark"
            >
              <NavDropdown.Item href="/cadastro" className="dropdown-item">
                Cadastrar Ave
              </NavDropdown.Item>
              <NavDropdown.Item href="/catalogo"> Catálogo </NavDropdown.Item>
            </NavDropdown>
            <Nav.Link>
              <Link to="/avistamento">Avistamentos</Link>
            </Nav.Link>
            <Nav.Link className="last">
              <Link to="/">Sair</Link>
            </Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </>
  );
};

export default Menu;
