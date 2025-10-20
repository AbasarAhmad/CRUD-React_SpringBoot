package com.saar.saar.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saar.saar.dto.EmployeeDto;
import com.saar.saar.service.EmployeeService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")

@AllArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;

	@PostMapping("/add")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto)
	{
		EmployeeDto savedEmployee = employeeService.creatEmployee(employeeDto);
		return new ResponseEntity<EmployeeDto>(savedEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{empId}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long empId)
	{
		EmployeeDto foundEmployee = employeeService.getEmployeeById(empId);
		return new ResponseEntity<EmployeeDto>(foundEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<EmployeeDto>> getEmployeeById()
	{
		List<EmployeeDto> employees = employeeService.getAllEmployee();
		return ResponseEntity.ok(employees);
	}
	
	@PutMapping("/update/{empId}")
	public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable Long empId, @RequestBody EmployeeDto employeeDto)
	{
		EmployeeDto updatedEmployee = employeeService.updateEmployee(empId, employeeDto);
		return new ResponseEntity<EmployeeDto>(updatedEmployee, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable Long empId)
	{
		String str=employeeService.deleteEmployee(empId);
		return new ResponseEntity<String>(str, HttpStatus.CREATED);
	}
}
