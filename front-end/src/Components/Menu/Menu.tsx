import React from "react";
import { DropdownButton, Dropdown, NavDropdown } from "react-bootstrap";

import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import { Link } from "react-router-dom";

import "./index.css";

const logo = require("./../../assets/logo.png");
import logotipo from "../../assets/logotipo.png"

const Menu = () => {
  return (
    <>
      <Navbar className="menu navbar navbar-expand-lg">
        <Container>
          <Navbar.Brand href="/" className="logo">
          <img src={logotipo} className= "logo-passarinho"/>
          </Navbar.Brand>

          <Nav className="me-auto">
            <Nav.Link className="text-warning" href="/">
              <Link to="/">Home</Link>
            </Nav.Link>
            <NavDropdown title="Aves" id="basic-nav-dropdown" menuVariant= "dark">
              <NavDropdown.Item href="/cadastro" className="dropdown-item">Cadastrar Ave </NavDropdown.Item>
              <NavDropdown.Item href="/catalogo"> Catálogo </NavDropdown.Item>
            </NavDropdown>
            <Nav.Link href="/login">
              <Link to="login">Avistamentos</Link>
            </Nav.Link>
            <Nav.Link className="last">
              <Link to="/login">Sair</Link>
            </Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </>
  );
};

export default Menu;
