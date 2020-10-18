package com.acme.homehealthy.service;

import com.acme.homehealthy.domain.model.Employee;
import com.acme.homehealthy.domain.repository.EmployeeRepository;
import com.acme.homehealthy.domain.service.EmployeeService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> getAllEmployee(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Id",id));
    }

    @Override
    public Employee createEmployee(Employee employeeRequest) {
        return employeeRepository.save(employeeRequest);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employeeRequest) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Id",id));
        return employeeRepository.save(
                employee.setUsername(employeeRequest.getUsername())
                        .setPassword(employeeRequest.getPassword()));
    }

    @Override
    public ResponseEntity<?> deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Id",id));
        employeeRepository.delete(employee);
        return ResponseEntity.ok().build();
    }

    @Override
    public Employee getUserByUsername(String username) {
        return employeeRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User", "Username", username));
    }

    @Override
    public Employee getUserByUsernameAndPassword(String name, String password) {
        return employeeRepository.findByUsernameAndPassword(name,password)
                .orElseThrow(()->new ResourceNotFoundException("User", "Username or password",name + " " + password));
    }
}