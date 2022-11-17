import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8080",
  headers: { "content-type": "application/x-www-form-urlencoded" },
  auth: {
    username: "my-trusted-client",
    password: "secret",
  }
});

export default api;
