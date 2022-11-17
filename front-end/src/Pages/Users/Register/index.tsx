import React, { useState } from "react";

import qs from "qs";
import axios from "axios";

import { Link, useNavigate } from "react-router-dom";
import api from "../../../services/api";

const styles: { [key: string]: React.CSSProperties } = {
  container: {
    margin: "10vh auto",
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
  },
};

const Register = () => {
  const history = useNavigate();

  const [id, setId] = useState(null);
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    // Preventing the page from reloading
    e.preventDefault();

    const data = {
      name,
      email,
      password,
    };

    axios
      .post("http://localhost:8080/users", {
        data,
      })
      .then(function (response) {
        history("/");
      })
      .catch(function (error) {
        alert("Desculpe, erro ao cadastrar usuário");
      });
  }

  return (
    <div style={styles.container}>
      <div className="col-6">
        <div className="card  mb-3">
          <h3 className="card-header">Cadastro de Usuário</h3>
          <div className="card-body">
            <div className="row">
              <div className="col-lg-12">
                <form method="post" onSubmit={handleSubmit}>
                  <fieldset>
                    <div className="form-group">
                      <label htmlFor="exampleInputEmail1">Nome: *</label>
                      <input
                        onChange={(e) => setName(e.target.value)}
                        value={name}
                        type="text"
                        className="form-control"
                        id="exampleInputEmail1"
                        aria-describedby="emailHelp"
                        placeholder="Digite o Nome"
                      />
                    </div>
                    <div className="form-group">
                      <label htmlFor="exampleInputEmail1">Email: *</label>
                      <input
                        type="email"
                        onChange={(e) => setEmail(e.target.value)}
                        value={email}
                        className="form-control"
                        id="exampleInputEmail1"
                        aria-describedby="emailHelp"
                        placeholder="Digite o Email"
                      />
                      <small id="emailHelp" className="form-text text-muted">
                        Não divulgamos o seu email.
                      </small>
                    </div>
                    <div className="form-group">
                      <label htmlFor="exampleInputPassword1">Senha: *</label>
                      <input
                        type="password"
                        onChange={(e) => setPassword(e.target.value)}
                        value={password}
                        className="form-control"
                        id="exampleInputPassword1"
                        placeholder="Password"
                      />
                    </div>

                    {/* <div className="form-group">
                      <label htmlFor="exampleInputPassword1">
                        Repita a Senha: *
                      </label>
                      <input
                        type="password"
                        className="form-control"
                        id="exampleInputPassword1"
                        placeholder="Password"
                      /> 
                    </div>*/}

                    <button type="submit" className="btn ml-1 btn-success">
                      Salvar
                    </button>

                    <Link to="/">
                      <button type="button" className="btn ml-1 btn-danger">
                        Voltar
                      </button>
                    </Link>
                  </fieldset>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Register;
