import React from "react";

import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import { Link } from "react-router-dom";

import "./index.css";

const logo = require("./../../assets/logo.png");

const Menu = () => {
  return (
    <>
      <Navbar className="menu navbar navbar-expand-lg">
        <Container>
          <Navbar.Brand href="#home">
            <img src={logo} width={75} alt="Logo" />
          </Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link className="text-warning" href="#home">
              <Link to="/">Home</Link>
            </Nav.Link>
            <Nav.Link href="#users">
              <Link to="usuarios">Usuários</Link>
            </Nav.Link>
            <Nav.Link href="#login">
              <Link to="login">Login</Link>
            </Nav.Link>
            <Nav.Link href="#cadastro">
              <Link to="cadastro">Cadastre-se</Link>
            </Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </>
  );
};

export default Menu;
