import axios from "axios";
import React, { useState, useEffect } from "react";
import { Table } from "react-bootstrap";
import './Exibicao.css';

interface IBirdFormState {
  id: number;
  namePT: string;
  nameEN: string;
  nameLAT: string;
  size: string;
  gender: string;
  color: string;
  family: string;
  habitat: string;
}

const List = ({search} : {search : string}) => {
  const [birds, setBirds] = useState<IBirdFormState[]>([]);

  useEffect(() => {
    getBirds();
  }, [search]);

  const getBirds = () => {
    axios
      .get("http://localhost:8080/birds/search?param=" + search)
      .then((res) => setBirds(res.data))
      .catch((err) => console.log(err, "teste"));
  };

  return (
      <Table striped bordered hover size="sm">
        <thead>
          <tr className="table-row">
            <th>ID</th>
            <th>Nomes PT / EN / LAT</th>
            <th>Cor</th>
            <th>Gênero</th>
            <th>Tamanho (CM)</th>
            <th>Família</th>
            <th>Habitat</th>
          </tr>
        </thead>
        <tbody>
          {birds.map((bird) => (
            <tr>
              <td>{bird.id}</td>
              <td>
                {bird.namePT} | {bird.nameEN} | {bird.nameLAT}
              </td>
              <td>{bird.color}</td>
              <td>{bird.gender}</td>
              <td>{bird.size}</td>
              <td>{bird.family}</td>
              <td>{bird.habitat}</td>
            </tr>
          ))}
        </tbody>
      </Table>
  );
};

export default List;
