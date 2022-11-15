import React, { useState } from "react";

import { Link, useNavigate } from "react-router-dom";
import api from "../../../services/api";

const styles: { [key: string]: React.CSSProperties } = {
  container: {
    margin: "25vh auto",
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
  },
};

const Login = () => {
  const [username, setUsername] = useState<string>("");
  const [password, setPassword] = useState<string>("");

  const history = useNavigate();

  async function login(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();

    const data = {
      username,
      password,
    };

    try {
      const response = await api.post("auth/login", data);
      localStorage.setItem("username", username);
      localStorage.setItem("token", response.data.token);
      console.log(username, password, response.data.token);
      alert("ENtrou");

      history("/home");
    } catch (error) {
      console.log(error);
      alert("Desculpa, falha no login!!!");
    }
  }

  return (
    <div style={styles.container}>
      <div className="col-4">
        <div className="card mb-3">
          <h3 className="card-header">Login</h3>
          <div className="card-body">
            <div className="row">
              <div className="col-lg-12">
                <form onSubmit={login}>
                  <fieldset>
                    <div className="form-group">
                      <label htmlFor="exampleInputEmail1">Username: *</label>
                      <input
                        type="text"
                        className="form-control"
                        onChange={(e) => setUsername(e.target.value)}
                        id="exampleInputEmail1"
                        aria-describedby="emailHelp"
                        placeholder="Digite o Email"
                      />
                    </div>
                    <div className="form-group">
                      <label htmlFor="exampleInputPassword1">Senha: *</label>
                      <input
                        type="password"
                        className="form-control"
                        id="exampleInputPassword1"
                        onChange={(e) => setPassword(e.target.value)}
                        placeholder="Password"
                      />
                    </div>

                    <button type="submit" className="btn ml-1 btn-success">
                      Entrar
                    </button>

                    <Link to="/register">
                      <button type="button" className="btn ml-1 btn-danger">
                        Criar Conta
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

export default Login;
