package com.acme.blogging;

import com.acme.blogging.domain.model.Employee;
import com.acme.blogging.domain.repository.EmployeeRepository;
import com.acme.blogging.domain.service.EmployeeService;
import com.acme.blogging.exception.ResourceNotFoundException;
import com.acme.blogging.service.EmployeeServiceImp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@ExtendWith(SpringExtension.class)
public class EmployeeServiceImpIntegrationTest {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @TestConfiguration
    static class EmployeeServiceImplTestConfiguration{
        @Bean
        public EmployeeService postService() {
            return new EmployeeServiceImp();
        }
    }

    @Test
    @DisplayName("When getEmployeByUsername With Valid Username The Return User")
    public void whengetEmployeeByUsernameWithValidUsernameTheReturnUser(){
        //Arrange
        String username = "Heal2020";
        Employee employee = new Employee();
        employee.setId(10L);
        employee.setUsername(username);
        Mockito.when(employeeRepository.findByEmployee(username))
                .thenReturn(Optional.of(employee));
        //Act
        Employee foundUser = employeeService.getUserByUsername(username);
        //Asset
        assertThat(foundUser.getUsername()).isEqualTo(username);
    }

    @Test
    @DisplayName("When getEmployeeByUsernameAndPassword With Invalid User or Password Then Throws ResourceNotFoundException")
    public void whenGetEmployeeByUsernameAndPasswordWithInvalidUserorPasswordThenThrowsResourceNotFoundException(){
        //Arrange
        String template = "Resource %s not found for %s with value %s";
        String username = "Heal2021";
        String password = "password";
        Employee employee = new Employee();
        employee.setId(1001L);
        employee.setUsername(username);
        employee.setPassword(password);
        Mockito.when(employeeRepository.findByEmployee(username))
                .thenReturn(Optional.empty());

        String exceptedMessage = String.format(template,"User", "Username or password", username + " " + password);
        //Act
        Throwable exception = catchThrowable(()->{
            Employee foundUser = employeeService.getUserByUsernameAndPassowrd(username,password);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(exceptedMessage);
    }

    @Test
    @DisplayName("When getEmployeeName With Invalid User Then Throws ResourceNotFoundException")
    public void whenGetEmployeeNameWithInvalidUserThenThrowsResourceNotFoundException(){
        //Arrange
        String template = "Resource %s not found for %s with value %s";
        String username = "Heal2022";
        Employee employee = new Employee();
        employee.setId(1002L);
        employee.setUsername(username);
        Mockito.when(employeeRepository.findByEmployee(username))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template,"User","Username",username);
        //Act
        Throwable exception = catchThrowable(()->{
            Employee foundUser = employeeService.getUserByUsername(username);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}
