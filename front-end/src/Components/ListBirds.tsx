import axios from 'axios'
import React, { useState, useEffect } from 'react'
import { Container, Table } from 'react-bootstrap'
import BirdRegister from './BirdRegister'

interface IBirdFormState {
    id: number,
    namePT: string,
    nameEN: string,
    nameLAT: string,
    size: string,
    gender: string,
    color: string,
    family: string,
    habitat: string,
  }
  


const List = () => {
    const [birds, setBirds] = useState<IBirdFormState[]>([]);

    useEffect(() => {
        getBirds();
    }, []);

    const getBirds = () => {
        axios.get('http://localhost:8080/birds/')
        .then(res => setBirds(res.data))
        .catch(err => console.log(err, "teste"))

        
    }

  return (
    <Container>
        
    <Table striped bordered hover size="sm">
      <thead>
        <tr>
          <th>ID</th>
          <th>Nome</th>
          <th>Cor</th>
          <th>Gênero</th>
          <th>Família</th>
        </tr>
      </thead>
      <tbody>
        {birds.map((bird) => <tr>
          <td>{bird.id}</td>
          <td>{bird.namePT}</td>
          <td>{bird.color}</td>
          <td>{bird.gender}</td>
          <td>{bird.family}</td>

        </tr>
        )}
        
        
      </tbody>
    </Table>
    </Container>
  )
}

export default List