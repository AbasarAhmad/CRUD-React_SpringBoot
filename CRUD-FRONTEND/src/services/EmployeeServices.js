import axios from "axios";

const BASE_URL = "http://localhost:8081/api/employee";

export const listEmployees = () => axios.get(`${BASE_URL}/get`);
export const createEmployee = (employee) => axios.post(`${BASE_URL}/add`, employee);
export const getEmployee = (empId) => axios.get(`${BASE_URL}/get/${empId}`);
export const updateEmployee = (empId, employee) => axios.put(`${BASE_URL}/update/${empId}`, employee);
export const deleteEmployee = (empId) => axios.delete(`${BASE_URL}/delete/${empId}`);

