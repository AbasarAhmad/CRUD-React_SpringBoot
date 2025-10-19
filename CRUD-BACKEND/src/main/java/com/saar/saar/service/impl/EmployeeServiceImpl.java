package com.saar.saar.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saar.saar.dto.EmployeeDto;
import com.saar.saar.entity.Employee;
import com.saar.saar.exception.ResouceNotFoundException;
import com.saar.saar.repository.EmployeeRepo;
import com.saar.saar.service.EmployeeService;
import com.saar.saar.mapper.EmployeeMapper;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public EmployeeDto creatEmployee(EmployeeDto employeeDto) {
		Employee emp= EmployeeMapper.EmployeeDtoToEmployee(employeeDto);
		Employee added =employeeRepo.save(emp);
		return EmployeeMapper.EmployeeToDto(added);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee emp=employeeRepo.findById(employeeId).orElseThrow(()-> new ResouceNotFoundException("Employee is not exist with given id : "+employeeId));
		return EmployeeMapper.EmployeeToDto(emp);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> employees =employeeRepo.findAll();
		return employees.stream().map((emp)->EmployeeMapper.EmployeeToDto(emp)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
		Employee employee=employeeRepo.findById(employeeId).orElseThrow(()->new ResouceNotFoundException("Employee is not exist with given id : "+employeeId));
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		Employee updatedEmp= employeeRepo.save(employee);
		return EmployeeMapper.EmployeeToDto(employee);
	}

	@Override
	public String deleteEmployee(Long employeeId) {
		Employee employee=employeeRepo.findById(employeeId).orElseThrow(()->new ResouceNotFoundException("Employee is not exist with given id : "+employeeId));
		employeeRepo.delete(employee);
		return "employee is deleted by id: "+employeeId;
	}

}
