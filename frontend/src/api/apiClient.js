import axios from "axios";

const instance = axios.create({
  baseURL: process.env.REACT_APP_API_URL || "http://localhost:8080",
  timeout: 10000, // Set a timeout if needed
  headers: {
    "Content-Type": "application/json",
  },
});

export default instance;
