import React, { useEffect, useState } from 'react'
import { deleteEmployee, listEmployees } from '../services/EmployeeServices'
import { useNavigate } from 'react-router-dom'

const ListEmployeeComponent = () => {
  const [employee, setEmployee] = useState([])
  const navigator = useNavigate();

  useEffect(() => {
   getAllEmployee();
  }, []); // ✅ runs only once on component mount

  function getAllEmployee(){
     listEmployees()
      .then((response) => {
        setEmployee(response.data);
      })
      .catch((error) => {
        console.error("Error fetching employees:", error);
      });
  }

  function addNewEmployee() {
    navigator('/add-employee')
  }

  function updateEmployee(id) {
    navigator(`/edit-employee/${id}`)
  }



function removeEmployee(id){
  console.log(id);
  deleteEmployee(id).then((response) =>{
  getAllEmployee();
  }).catch(error => {
    console.error(error);
  })
}

  return (
    <div className='container'>
      <h2 className='text-center'>List of Employees</h2>
      <button className="btn btn-primary mb-2" onClick={addNewEmployee}>Add Employee</button>
      <table className='table table-striped table-bordered'>
        <thead>
          <tr>
            <th>Emp Id</th>
            <th>Emp First Name</th>
            <th>Emp Last Name</th>
            <th>Emp Email Id</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {
            employee.map(emp => (
              <tr key={emp.id}>
                <td>{emp.id}</td>
                <td>{emp.firstName}</td>
                <td>{emp.lastName}</td>
                <td>{emp.email}</td>
                <td>
                  <button className='btn btn-info' onClick={() => updateEmployee(emp.id)}>Update</button>
                  <button className='btn btn-danger' onClick={() => removeEmployee(emp.id)}
                    style={{marginLeft: '10px'}} >Delete</button>
                </td>
              </tr>
            ))
          }
        </tbody>
      </table>
    </div>
  )
}

export default ListEmployeeComponent
