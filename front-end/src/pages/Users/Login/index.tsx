import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import api from "../../../services/api";
import qs from "qs";

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

    if (username === "" || password === "") {
      alert("Preencha todos os campos!");
    } else {
      const data = qs.stringify(
        {
          username,
          password,
        },
        { encode: false }
      );

      try {
        const response = await api.post(
          "oauth/token?grant_type=password&" + data
        );
        localStorage.setItem("userName", username);
        localStorage.setItem("access_token", response.data.access_token);
        history("/home");
      } catch (error) {
        alert("Desculpe, falha no login.");
      }
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
                        required
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
                        required
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
