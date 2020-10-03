package com.acme.blogging.service;

import com.acme.blogging.domain.model.Employee;
import com.acme.blogging.domain.model.User;
import com.acme.blogging.domain.repository.EmployeeRepository;
import com.acme.blogging.domain.service.EmployeeService;
import com.acme.blogging.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService {

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
        return employeeRepository.findByEmployee(username)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User", "Username", username));
    }

    @Override
    public Employee getUserByUsernameAndPassowrd(String name, String password) {
        return employeeRepository.findByUsernameAndPassword(name,password)
                .orElseThrow(()->new ResourceNotFoundException("User", "Username or password",name + " " + password));
    }
}
