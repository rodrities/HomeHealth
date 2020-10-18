package com.acme.homehealthy.controller;

import com.acme.homehealthy.domain.model.Employee;
import com.acme.homehealthy.domain.service.EmployeeService;
import com.acme.homehealthy.resource.EmployeeResource;
import com.acme.homehealthy.resource.SaveEmployeeResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public Page<EmployeeResource> getAllEmployee(Pageable pageable){
        Page<Employee> employees = employeeService.getAllEmployee(pageable);
        List<EmployeeResource> resources = employees.getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources,pageable,resources.size());
    }

    @GetMapping("/employees/{employeeId}")
    public EmployeeResource getEmployeeById(@PathVariable (value = "employeeId") Long id){
        return convertToResource(employeeService.getEmployeeById(id));
    }

    @PostMapping("/employees")
    public EmployeeResource createEmployee(@Valid @RequestBody SaveEmployeeResource resource){
        Employee employee = convertToEntity(resource);
        return convertToResource(employeeService.createEmployee(employee));
    }

    @PutMapping("/employees/{employeeId}")
    public EmployeeResource updateEmployee(@PathVariable (value = "employeeId") Long id, @Valid @RequestBody SaveEmployeeResource resource){
        Employee employee = convertToEntity(resource);
        return convertToResource(employeeService.updateEmployee(id,employee));
    }

    @GetMapping("/employees/username/{username}")
    public EmployeeResource getUserByUsername(@PathVariable(value = "username" ) String username) {
        return convertToResource(employeeService.getUserByUsername(username));
    }

    @GetMapping("/employees/username/{username}/password/{password}")
    public EmployeeResource getUserByUsernameAndPassword(@PathVariable(value = "username")String username, @PathVariable(value = "password") String password){
        return convertToResource(employeeService.getUserByUsernameAndPassword(username,password));
    }

    private Employee convertToEntity(SaveEmployeeResource resource){
        return mapper.map(resource, Employee.class);
    }

    private EmployeeResource convertToResource(Employee entity){
        return mapper.map(entity,EmployeeResource.class);
    }
}
