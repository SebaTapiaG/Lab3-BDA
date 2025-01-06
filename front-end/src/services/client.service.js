import httpClient from "@/http-common";

const getAll = () => {
  return httpClient.get("/api/cliente");
}

const get = id => {
  return httpClient.get(`/api/cliente/${id}`);
}

const getByEmail = email => {
  return httpClient.get(`/api/cliente/email/${email}`);
}

const login = userObj => {
    return httpClient.post("/api/cliente/login", userObj);
}

const register = userObj => {
    return httpClient.post("/api/cliente/register", userObj);
}

const getTarjetas = email => {
  return httpClient.get(`/api/cliente/getTarjetas/${email}`);
}

const addTarjeta = (email, tarjeta) => {
  return httpClient.post(`/api/cliente/addTarjeta/${email}`, tarjeta);
}

const deleteTarjeta = (email, tarjeta) => {
  return httpClient.post(`/api/cliente/deleteTarjeta/${email}/${tarjeta}`);
}

export default {
    getAll,
    get,
    getByEmail,
    login,
    register,
    addTarjeta,
    getTarjetas,
    deleteTarjeta
};