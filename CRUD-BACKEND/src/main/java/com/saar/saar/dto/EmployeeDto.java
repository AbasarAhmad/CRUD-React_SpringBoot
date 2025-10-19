package com.saar.saar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

	public static final String HttpStatus = null;
	private Long id;	
	private String firstName;
	private String lastName;	
	private String email;

}
