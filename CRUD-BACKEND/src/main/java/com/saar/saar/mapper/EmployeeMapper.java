package com.saar.saar.mapper;

import com.saar.saar.dto.EmployeeDto;
import com.saar.saar.entity.Employee;

public class EmployeeMapper {
	public static EmployeeDto EmployeeToDto(Employee employee)
	{
		return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
	}
	
	
	
	public static Employee EmployeeDtoToEmployee(EmployeeDto employeeDto)
	{
		return new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmail());
	}
}
