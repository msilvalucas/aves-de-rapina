import React from "react";
import { Button } from "react-bootstrap";
import "./styles.css";

import Header from "../../Components/Header/Header";
import imgBlueBird from "../../assets/bluebird.jpg";
import { Link } from "react-router-dom";

const Home = () => {
  return (
    <>
      <Header />
      <div className="home-container">
        <img src={imgBlueBird} className="passaro" />
        <div className="info">
          <h1 className="display-3">Seja bem vindo!</h1>
          <hr />
          <p className="lead">Esse é seu sistema de Aves.</p>

          <p>
            E essa é sua área administrativa, utilize um dos menus ou botões
            abaixo para navegar pelo sistema.
          </p>
          <p className="lead ">
            <Link to="/cadastro">
              <Button variant="outline-success">
                <i className="fa fa-users"></i>
                Cadastrar Aves
              </Button>
            </Link>
            <Link to="/avistamento">
              <Button variant="outline-success">
                <i className="fa fa-users"></i>
                Cadastrar Avistamentos
              </Button>
            </Link>
          </p>
        </div>
      </div>
    </>
  );
};

export default Home;
