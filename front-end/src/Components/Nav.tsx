import React from "react";

import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";

const Nav = () => {
  return (
    <>
      <Navbar bg="danger">
        <Container>
          <Navbar.Brand href="#home">
            <img
              alt=""
              src="/logo.svg"
              width="30"
              height="30"
              className="d-inline-block align-center"
            />{" "}
          </Navbar.Brand>
        </Container>
      </Navbar>
    </>
  );
};

export default Nav;
