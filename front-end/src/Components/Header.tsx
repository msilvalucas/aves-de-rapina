import React from "react";

import nav from "react-bootstrap/Nav";

const logo = require("./../assets/logo.png");

const Header = () => {
  return (
    <header className="container">
      <div className="row align-items-center border">
        <div className="col-4 border justify-content-start">
          <img src={logo} width={120} alt="" />
        </div>
        <nav className="col-8 justify-content-around border">
          <ul className="border">
            <li className="border">
              <a href="#">Home</a>
            </li>
            <li>
              <a href="#">Home</a>
            </li>
            <li>
              <a href="#">Home</a>
            </li>
            <li>
              <a href="#">Home</a>
            </li>
          </ul>
        </nav>
      </div>
    </header>
  );
};

export default Header;
