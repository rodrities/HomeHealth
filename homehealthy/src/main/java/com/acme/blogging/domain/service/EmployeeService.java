package com.acme.blogging.domain.service;

import com.acme.blogging.domain.model.Employee;
import com.acme.blogging.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
    Page<Employee> getAllEmployee(Pageable pageable);
    Employee getEmployeeById(Long id);
    Employee createEmployee(Employee employeeRequest);
    Employee updateEmployee(Long id, Employee employeeRequest);
    ResponseEntity<?> deleteEmployee(Long id);
    Employee getUserByUsername(String username);
    Employee getUserByUsernameAndPassowrd(String name, String password);
}
