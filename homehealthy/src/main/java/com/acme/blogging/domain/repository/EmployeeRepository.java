package com.acme.blogging.domain.repository;

import com.acme.blogging.domain.model.Employee;
import com.acme.blogging.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByEmployee (String username);
    Optional<Employee> findByUsernameAndPassword(String username, String password);
}
