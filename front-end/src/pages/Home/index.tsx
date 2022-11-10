import React from "react";

import Header from "../../Components/Header/Header";

const Home = () => {
  return (
    <>
      <Header />
      <div className="container">
        <div className="jumbotron">
          <h1 className="display-3">Bem vindo: Lucas!!!</h1>
          <p className="lead">Esse é seu sistema de Aves.</p>
          <p className="lead">
            Total de Aves cadastradas: 80 | Total de Avistamentos cadastrados:
            123
          </p>
          <hr />
          <p>
            E essa é sua área administrativa, utilize um dos menus ou botões
            abaixo para navegar pelo sistema.
          </p>
          <p className="lead ">
            <a
              className="btn mr-1 btn-primary btn-lg"
              href="https://bootswatch.com/flatly/#"
              role="button"
            >
              <i className="fa fa-users"></i> Cadastrar Aves
            </a>
            <a
              className="btn ml-1 btn-danger btn-lg"
              href="https://bootswatch.com/flatly/#"
              role="button"
            >
              <i className="fa fa-users"></i> Cadastrar Avistamentos
            </a>
          </p>
        </div>
      </div>
    </>
  );
};

export default Home;
