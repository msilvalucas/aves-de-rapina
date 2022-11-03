import React from 'react'
import { InputGroup, Form, Container } from 'react-bootstrap';

// interface iBirdForm {
//     id: number;
//     namePT: string;
//     nameEN: string;
//     nameLAT: string;
//     size: number;
//     gender: string;
//     color: string;
//     family: string;
//     habitat: string;
    
// }

const BirdRegister = () => {
  return (
    <>
    <div className="container mt-5">
       <form>
        <h1>Cadastro de Ave</h1>
        <h2>Nomes</h2>
            <div className="form-row">
                <div className="form-group col-md-4">
                
                <input type="text" className="form-control" id="portugueseName" placeholder="Nome em português"/>
                </div>
                <div className="form-group col-md-4">
                
                <input type="text" className="form-control" id="englishName" placeholder="Nome em inglês"/>
                </div>
                <div className="form-group col-md-4">

                <input type="text" className="form-control" id="latinName" placeholder="Nome em latim"/>
                </div>
            </div>
            <h2>Outras características</h2>
            <div className="form-row">
                <div className="form-group col-md-4">
                <label htmlFor="labelSize">Tamanho</label>
                <input type="text" className="form-control" id="birdSize" placeholder="Digite o tamanho da ave"/>
                </div>
                <div className="form-group col-md-4">
                <label htmlFor="labelColor">Cor</label>
                <input type="text" className="form-control" id="birdColor" placeholder="Digite a cor da ave"/>
                </div>
                <div className="form-group col-md-4">
                <label htmlFor="labelGender">Gênero</label>
                <select id="selectGender" className="form-control">
                    <option selected>Escolher...</option>
                    <option>Fêmea</option>
                    <option>Macho</option>
                </select>
                </div>
            </div>
            <div className="form-row">
                <div className="form-group col-md-6">
                <label htmlFor="laberFamily">Família</label>
                <input type="text" className="form-control" id="birdFamily" placeholder="Família"/>
                </div>
                <div className="form-group col-md-6">
                <label htmlFor="labelHabitat">Habitat</label>
                <input type="text" className="form-control" id="birdHabitat" placeholder="Nome em inglês"/>
                </div>
            </div>
            <button type="submit" className="btn btn-primary">Entrar</button>
        </form>
    </div>
    <Container>
    <InputGroup className="mb-3">
    <InputGroup.Text id="basic-addon1">@</InputGroup.Text>
    <Form.Control
      placeholder="Username"
      aria-label="Username"
      aria-describedby="basic-addon1"
    />
  </InputGroup>

  <InputGroup className="mb-3">
    <Form.Control
      placeholder="Recipient's username"
      aria-label="Recipient's username"
      aria-describedby="basic-addon2"
    />
    <InputGroup.Text id="basic-addon2">@example.com</InputGroup.Text>
  </InputGroup>

  <Form.Label htmlFor="basic-url">Your vanity URL</Form.Label>
  <InputGroup className="mb-3">
    <InputGroup.Text id="basic-addon3">
      https://example.com/users/
    </InputGroup.Text>
    <Form.Control id="basic-url" aria-describedby="basic-addon3" />
  </InputGroup>

  <InputGroup className="mb-3">
    <InputGroup.Text>$</InputGroup.Text>
    <Form.Control aria-label="Amount (to the nearest dollar)" />
    <InputGroup.Text>.00</InputGroup.Text>
  </InputGroup>

  <InputGroup>
    <InputGroup.Text>With textarea</InputGroup.Text>
    <Form.Control as="textarea" aria-label="With textarea" />
  </InputGroup>
  </Container>
  </>
  )
}



export default BirdRegister