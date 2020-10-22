package com.acme.homehealthy.Initialization.controller;

import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.acme.homehealthy.Initialization.domain.service.CustomerService;
import com.acme.homehealthy.Initialization.resource.CollaboratorResource;
import com.acme.homehealthy.Initialization.resource.CustomerResource;
import com.acme.homehealthy.Initialization.resource.SaveCollaboratorResource;
import com.acme.homehealthy.Initialization.resource.SaveCustomerResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Customers", description = "Initialization API")
@RestController
@RequestMapping("api/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/customer/{customerId}")
    public CustomerResource getCustomerByUsername(@Valid @PathVariable (value = "customerId") Long customerId){
        return convertToResource(customerService.getCustomerById(customerId));
    }

    @GetMapping("/customers/{username}/{password}")
    public CustomerResource getCustomerByUsernameAndPassword(   @Valid @PathVariable (value = "username") String username,
                                                                @Valid @PathVariable (value = "password") String password){
        return convertToResource(customerService.getCustomerByUsernameAndPassword(username,password));
    }

    @PostMapping("/customers")
    public CustomerResource createCustomer(@Valid @RequestBody SaveCustomerResource resource){
        Customer customer = convertToEntity(resource);
        return convertToResource(customerService.createCustomer(customer));
    }

    @PutMapping("/customers/{customerId}")
    public CustomerResource updateCustomer( @Valid @PathVariable (value = "customerId") Long customerId,
                                            @Valid @RequestBody SaveCustomerResource resource){
        Customer customer = convertToEntity(resource);
        return convertToResource(customerService.updateCustomer(customerId,customer));
    }

    @DeleteMapping("/customers/{username}")
    public ResponseEntity<?> deleteCustomer(@Valid @PathVariable (value = "username") String username){
        return  customerService.deleteCustomer(username);
    }

    private Customer convertToEntity(SaveCustomerResource resource){
        return mapper.map(resource, Customer.class);
    }

    private CustomerResource convertToResource(Customer customer){
        return mapper.map(customer, CustomerResource.class);
    }
}
