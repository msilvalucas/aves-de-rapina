import React, { ReactNode, useState } from "react";

import qs from "qs";
import axios from "axios";

import { Link, useNavigate } from "react-router-dom";
import api from "../../../services/api";
import { ErrorMessage } from "formik";

const styles: { [key: string]: React.CSSProperties } = {
  container: {
    margin: "10vh auto",
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
  },
};

interface ErrorMessageProps {
  comp: JSX.Element;
}

const Register = (): JSX.Element => {
  const history = useNavigate();

  const [id, setId] = useState(null);
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const [submitted, setSubmitted] = useState(false);
  const [error, setError] = useState(false);

  const handleName = (e: React.ChangeEvent<HTMLInputElement>) => {
    setName(e.target.value);
    setSubmitted(false);
  };

  const handleEmail = (e: React.ChangeEvent<HTMLInputElement>) => {
    setEmail(e.target.value);
    setSubmitted(false);
  };

  const handlePassword = (e: React.ChangeEvent<HTMLInputElement>) => {
    setPassword(e.target.value);
    setSubmitted(false);
  };

  async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();

    if (name === "" || email === "" || password === "") {
      setError(true);
      alert("Preencha todos os campos!");
    } else {
      axios
        .post("http://localhost:8080/users", {
          name: name,
          email: email,
          password: password,
        })
        .then(function (response) {
          history("/");
        })
        .catch(function (err) {
          console.log(err);
          alert("Desculpe, erro ao cadastrar usuário");
        });
      setSubmitted(true);
      setError(false);
      alert("Usuário Cadastrado");
    }
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
                        required
                        onChange={handleName}
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
                        required
                        onChange={handleEmail}
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
                        required
                        type="password"
                        onChange={handlePassword}
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
