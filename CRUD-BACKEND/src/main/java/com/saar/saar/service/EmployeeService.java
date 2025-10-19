package com.saar.saar.service;

import java.util.List;

import com.saar.saar.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto creatEmployee ( EmployeeDto employeeDto);
	EmployeeDto getEmployeeById(Long employeeId);
	List<EmployeeDto> getAllEmployee();
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto);
	String deleteEmployee(Long employeeId);

}
