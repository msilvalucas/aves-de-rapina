import React from "react";

const Register = () => {
  return (
    <div className="container">
      <div>
        <div className="card mb-3">
          <h3 className="card-header">Cadastro de Usuário</h3>
          <div className="card-body">
            <div className="row">
              <div className="col-lg-12">
                <form>
                  <fieldset>
                    <div className="form-group">
                      <label htmlFor="exampleInputEmail1">Nome: *</label>
                      <input
                        type="email"
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
                        className="form-control"
                        id="exampleInputPassword1"
                        placeholder="Password"
                      />
                    </div>

                    <div className="form-group">
                      <label htmlFor="exampleInputPassword1">
                        Repita a Senha: *
                      </label>
                      <input
                        type="password"
                        className="form-control"
                        id="exampleInputPassword1"
                        placeholder="Password"
                      />
                    </div>

                    <button type="button" className="btn btn-success">
                      Salvar
                    </button>
                    <button type="button" className="btn btn-danger">
                      Voltar
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

export default Register;
