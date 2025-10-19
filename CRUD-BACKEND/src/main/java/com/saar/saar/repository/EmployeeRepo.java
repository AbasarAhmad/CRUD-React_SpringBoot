package com.saar.saar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saar.saar.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
