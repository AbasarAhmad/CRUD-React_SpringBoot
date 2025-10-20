import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { createEmployee, getEmployee, updateEmployee } from '../services/EmployeeServices';

const AddEmployee = () => {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');

    const { id } = useParams();

    const [errors, setErrors] = useState({
        firstName: '',
        lastName: '',
        email: ''
    });

    const navigator = useNavigate();

    // ✅ Load employee details for update mode
    useEffect(() => {
        if (id) {
            getEmployee(id)
                .then((response) => {
                    setFirstName(response.data.firstName);
                    setLastName(response.data.lastName);
                    setEmail(response.data.email);
                })
                .catch((error) => {
                    console.error(error);
                });
        }
    }, [id]);  // ✅ only run once when `id` changes

    // ✅ Form submission (create or update)
    function saveEmployee(e) {
        e.preventDefault();
        if (validationForm()) {
            const employee = { firstName, lastName, email };

            if (id) {
                updateEmployee(id, employee).then(() => {
                    navigator('/employee');
                });
            } else {
                createEmployee(employee).then(() => {
                    navigator('/employee');
                });
            }
        }
    }

    // ✅ Form validation
    function validationForm() {
        let valid = true;
        const errorsCopy = { ...errors };

        if (firstName.trim()) {
            errorsCopy.firstName = '';
        } else {
            errorsCopy.firstName = 'First name is required';
            valid = false;
        }

        if (lastName.trim()) {
            errorsCopy.lastName = '';
        } else {
            errorsCopy.lastName = 'Last name is required';
            valid = false;
        }

        if (email.trim()) {
            errorsCopy.email = '';
        } else {
            errorsCopy.email = 'Email is required';
            valid = false;
        }

        setErrors(errorsCopy);
        return valid;
    }

    // ✅ Page title handler
    function pageTitle() {
        if (id) {
            return <h2 className='text-center'>Update Employee</h2>;
        } else {
            return <h2 className='text-center'>Add Employee</h2>;
        }
    }

    return (
        <div className='container'>
            <br />
            <div className='row'>
                <div className='card col-md-6 offset-md-3 offset-md-3'>
                    {pageTitle()}
                    <div className='card-body'>
                        <form className='form-group-mb-2'>
                            <label className='form-label'>First Name</label>
                            <input
                                type='text'
                                name='firstName'
                                value={firstName}
                                className={`form-control ${errors.firstName ? 'is-invalid' : ''}`}
                                placeholder='Enter Employee First Name'
                                onChange={(e) => setFirstName(e.target.value)}
                            />
                            {errors.firstName && <div className='invalid-feedback'>{errors.firstName}</div>}

                            <label className='form-label mt-2'>Last Name</label>
                            <input
                                type='text'
                                name='lastName'
                                value={lastName}
                                className={`form-control ${errors.lastName ? 'is-invalid' : ''}`}
                                placeholder='Enter Employee Last Name'
                                onChange={(e) => setLastName(e.target.value)}
                            />
                            {errors.lastName && <div className='invalid-feedback'>{errors.lastName}</div>}

                            <label className='form-label mt-2'>Email</label>
                            <input
                                type='email'
                                name='email'
                                value={email}
                                className={`form-control ${errors.email ? 'is-invalid' : ''}`}
                                placeholder='Enter Employee Email'
                                onChange={(e) => setEmail(e.target.value)}
                            />
                            {errors.email && <div className='invalid-feedback'>{errors.email}</div>}

                            <button className='btn btn-success mt-3' onClick={saveEmployee}>
                                Submit
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default AddEmployee;
