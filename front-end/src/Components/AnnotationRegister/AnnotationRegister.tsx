import React, { useState, useEffect } from "react";
import { Container } from "react-bootstrap";
import Button from "react-bootstrap/Button";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import Row from "react-bootstrap/Row";
import axios from "axios";
import "../BirdRegister/BirdRegister.css";

interface IBirdFormState {
  id: number;
  namePT: string;
  nameEN: string;
  nameLAT: string;
}

interface IAnnotationFormState {
  date: Date;
  place: string;
  idBird: number;
  text: string;
  //idUser: number;
}

const AnnotationRegister = () => {
  const [birds, setBirds] = useState<IBirdFormState[]>([]);
  const [formState, setFormState] = useState<IAnnotationFormState>({
    date: new Date(),
    place: "",
    text: "",
    idBird: 0,
    //idUser: 0,
  });

  useEffect(() => {
    getBirds();
  }, []);

  const getBirds = () => {
    axios
      .get("http://localhost:8080/birds/")
      .then((res) => setBirds(res.data))
      .catch((err) => console.log(err, "teste"));
  };

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    console.log(formState, "teste");
    // axios.post("http://localhost:8080/annotations", formState)
    //   .then((res) => console.log(res))
    //   .catch((err) => console.log(err));
  };

  return (
    <>
      <Container className="form-container">
        <Form onSubmit={handleSubmit}>
          <h1>Cadastro de Avistamento</h1>
          <Row className="mb-3">
            <Form.Group as={Col}>
              <Form.Label className="form-label">Data</Form.Label>
              <Form.Control
                type="datetime-local"
                onChange={(event) =>
                  setFormState({
                    ...formState,
                    date: new Date(event.target.value) || new Date(),
                  })
                }
                id="date"
              />
            </Form.Group>

            <Form.Group as={Col}>
              <Form.Label className="form-label">Local</Form.Label>
              <Form.Control
                type="text"
                placeholder="Local do avistamento"
                onChange={(event) =>
                  setFormState({
                    ...formState,
                    place: event.target.value || "",
                  })
                }
                id="place"
              />
            </Form.Group>
          </Row>

          <Row className="mb-3">
            <Form.Group as={Col} type="select">
              <Form.Label>Ave</Form.Label>
              <Form.Control
                as="select"
                onChange={(event) =>
                  setFormState({
                    ...formState,
                    idBird: parseInt(event.target.value) || 0,
                  })
                }
              >
                <option>Selecione</option>
                {birds.map((bird) => (
                  <option>
                    {bird.id}: {bird.namePT} | {bird.nameEN} | {bird.nameLAT}
                  </option>
                ))}
              </Form.Control>
            </Form.Group>
            <Form.Group as={Col}>
              <Form.Label className="form-label">Anotação</Form.Label>
              <Form.Control
                type="text"
                placeholder="Outras informações"
                onChange={(event) =>
                  setFormState({
                    ...formState,
                    text: event.target.value || "",
                  })
                }
                id="text"
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

export default AnnotationRegister;