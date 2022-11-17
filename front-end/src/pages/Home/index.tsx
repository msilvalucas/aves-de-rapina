import React from "react";
import { Button } from "react-bootstrap";
import "./styles.css";

import Header from "../../Components/Header/Header";

import imgPapagaio from "../../assets/papagaio.png";
import imgBlueBird from "../../assets/bluebird.jpg";

const Home = () => {
  return (
    <>
      <Header />
      <div className="home-container">
        <img src={imgBlueBird} className="papagaio" />
        <div className="info">
          {/* <div className="jumbotron"> */}
          <h1 className="display-3">Seja bem vindo!</h1>
          <hr />
          <p className="lead">Esse é seu sistema de Aves.</p>

          <p>
            E essa é sua área administrativa, utilize um dos menus ou botões
            abaixo para navegar pelo sistema.
          </p>
          <p className="lead ">
            <Button href="/cadastro" className="btn" variant="outline-success">
              <i className="fa fa-users"></i> Cadastrar Aves
            </Button>
            <Button href="/avistamento" variant="outline-success">
              <i className="fa fa-users"></i> Cadastrar Avistamentos
            </Button>
          </p>
        </div>
      </div>

      {/* </div> */}
    </>
  );
};

export default Home;
