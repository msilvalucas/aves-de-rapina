// import axios from "axios";
// import React, { useEffect, useState } from "react";
// import Exibicao from "../Exibicao/Exibicao";
// import "./Catalogo.css";

// const CatalogoListado = () => {
//   const [param, setParam] = useState("");

//   const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
//     setParam(event.target.value);
//   };

//   useEffect(() => {
//     console.log(param);
//   }, [param]);

//   return (
//     <div className="catalogo-container">
//       <>
//       <h1>{param}</h1>
//       <input
//         type="text"
//         placeholder="Pesquisar por cor/espécie"
//         onChange={handleChange}
//       />
//       {<Exibicao search={param} />}
//       </>
//     </div>
//   );
// };

// export default CatalogoListado;
import axios from "axios";
import { Container, Col, Form, Row } from "react-bootstrap";
import React, { useEffect, useState } from "react";
import Exibicao from "../Exibicao/Exibicao";
import "./Catalogo.css";

const CatalogoListado = () => {
  const [param, setParam] = useState("");

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setParam(event.target.value);
  };

  useEffect(() => {
    console.log(param);
  }, [param]);

  return (
      <>
      <Container className="form-container">
      <Form>
      <h1>Catálogo de Aves</h1>
      <Row className="mb-3">
      <Form.Group as={Col}>
      <Form.Label className="form-label" onChange={handleChange}>Pesquisar por nome (PT/EN/LAT) ou cor:</Form.Label>
      <Form.Control
                type="text"
                onChange={handleChange}
              />
      </Form.Group>
      </Row>
      { <Exibicao search={param} /> }
      </Form>
      </Container>
      </>
  );
};

export default CatalogoListado;
