import React from "react";
import { Container } from "react-bootstrap";

const styles: { [key: string]: React.CSSProperties } = {
  container: {
    margin: "25vh auto",
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
  },
};

const Login = () => {
  return (
    <div style={styles.container}>
      <div className="col-4">
        <div className="card mb-3">
          <h3 className="card-header">Login</h3>
          <div className="card-body">
            <div className="row">
              <div className="col-lg-12">
                <form>
                  <fieldset>
                    <div className="form-group">
                      <label htmlFor="exampleInputEmail1">Email: *</label>
                      <input
                        type="email"
                        className="form-control"
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
                        placeholder="Password"
                      />
                    </div>

                    <button type="button" className="btn btn-success mr-1">
                      Entrar
                    </button>
                    <button type="button" className="btn btn-danger ">
                      Link
                    </button>
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
