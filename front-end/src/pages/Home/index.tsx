import React from "react";
import { Button } from "react-bootstrap";
import './styles.css'

import Header from "../../Components/Header/Header";

import imgPapagaio from "../../assets/papagaio.png"

const Home = () => {
  return (
    <>
      <Header />
      <div className="container">
        {/* <div className="jumbotron"> */}
          <h1 className="display-3">Bem vindo: Lucas!!!</h1>
          <p className="lead">Esse é seu sistema de Aves.</p>
          <p className="lead">
            Total de Aves cadastradas: 80 | Total de Avistamentos cadastrados:
            123
          </p>
          {/* <hr /> */}
          <p>
            E essa é sua área administrativa, utilize um dos menus ou botões
            abaixo para navegar pelo sistema.
          </p>
          <p className="lead ">
          <Button className="btn" variant="outline-primary"><i className="fa fa-users"></i> Cadastrar Aves</Button>
          <Button variant="outline-primary"><i className="fa fa-users"></i> Cadastrar Avistamentos</Button>
          </p>
          <img src="{imgPapagaio}"/>
        </div>
        
      {/* </div> */}
    </>
  );
};

export default Home;
