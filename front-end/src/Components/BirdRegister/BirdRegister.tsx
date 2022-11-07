import React, { useState } from "react";
import { Container } from "react-bootstrap";
import Button from "react-bootstrap/Button";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import Row from "react-bootstrap/Row";
import Axios from "axios";

interface IBirdFormState {
  namePT: string;
  nameEN: string;
  nameLAT: string;
  size: string;
  gender: string;
  color: string;
  family: string;
  habitat: string;
}

const BirdRegister = () => {
  const [formState, setFormState] = useState<IBirdFormState>({
    namePT: "",
    nameEN: "",
    nameLAT: "",
    size: "",
    gender: "",
    color: "",
    family: "",
    habitat: "",
  });

  // console.log(formState)

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    // Preventing the page from reloading
    event.preventDefault();
    console.log(formState, "teste");
    // post
    Axios.post("http://localhost:8080/birds", formState)
      .then((res) => console.log(res))
      .catch((err) => console.log(err));

    // get
    Axios.get("http://localhost:8080/birds/search/", {
      params: { param: formState.nameEN },
    })
      .then((res) => console.log(res, "teste"))
      .catch((err) => console.log(err, "teste"));
  };

  return (
    <>
      <Container>
        <Form onSubmit={handleSubmit}>
          <h1>Cadastro de Aves</h1>
          <h2 className="subtitulo">Nomes</h2>
          <Row className="mb-3">
            <Form.Group as={Col}>
              <Form.Control
                placeholder="Nome em Português"
                type="text"
                onChange={(event) =>
                  setFormState({
                    ...formState,
                    namePT: event.currentTarget?.value || "",
                  })
                }
                id="namePT"
              />
            </Form.Group>

            <Form.Group as={Col}>
              <Form.Control
                placeholder="Nome em Inglês"
                type="text"
                onChange={(event) =>
                  setFormState({
                    ...formState,
                    nameEN: event.currentTarget?.value || "",
                  })
                }
                id="nameEN"
              />
            </Form.Group>

            <Form.Group as={Col}>
              <Form.Control
                placeholder="Nome em Latim"
                type="text"
                onChange={(event) =>
                  setFormState({
                    ...formState,
                    nameLAT: event.currentTarget?.value || "",
                  })
                }
                id="nameLAT"
              />
            </Form.Group>
          </Row>
          <h2 className="subtitulo">Outras características</h2>

          <Row className="mb-3">
            <Form.Group as={Col}>
              <Form.Label>Tamanho</Form.Label>
              <Form.Control
                placeholder="Tamanho em CM"
                type="number"
                onChange={(event) =>
                  setFormState({
                    ...formState,
                    size: event.currentTarget?.value || "",
                  })
                }
                id="size"
              />
            </Form.Group>

            <Form.Group as={Col}>
              <Form.Label>Cor</Form.Label>
              <Form.Control
                placeholder="Cor"
                type="text"
                onChange={(event) =>
                  setFormState({
                    ...formState,
                    color: event.currentTarget?.value || "",
                  })
                }
              />
            </Form.Group>

            <Form.Group as={Col} type="select">
              <Form.Label>Gênero</Form.Label>
              <Form.Control
                as="select"
                onChange={(event) =>
                  setFormState({
                    ...formState,
                    gender: event.target?.value || "",
                  })
                }
              >
                <option>Selecione</option>
                <option>Fêmea</option>
                <option>Macho</option>
              </Form.Control>
            </Form.Group>
          </Row>

          <Row className="mb-3">
            <Form.Group as={Col}>
              <Form.Label>Família</Form.Label>
              <Form.Control
                onChange={(event) =>
                  setFormState({
                    ...formState,
                    family: event.currentTarget?.value || "",
                  })
                }
              />
            </Form.Group>

            <Form.Group as={Col}>
              <Form.Label>Habitat</Form.Label>
              <Form.Control
                onChange={(event) =>
                  setFormState({
                    ...formState,
                    habitat: event.currentTarget?.value || "",
                  })
                }
              />
            </Form.Group>
          </Row>

          <Button variant="primary" type="submit">
            Cadastrar
          </Button>
        </Form>
      </Container>
    </>
  );
};

export default BirdRegister;
