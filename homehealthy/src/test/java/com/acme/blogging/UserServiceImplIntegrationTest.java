package com.acme.blogging;

import com.acme.blogging.domain.model.Employee;
import com.acme.blogging.domain.model.User;
import com.acme.blogging.domain.repository.EmployeeRepository;
import com.acme.blogging.domain.repository.UserRepository;
import com.acme.blogging.domain.service.EmployeeService;
import com.acme.blogging.domain.service.UserService;
import com.acme.blogging.exception.ResourceNotFoundException;
import com.acme.blogging.resource.EmployeeResource;
import com.acme.blogging.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@ExtendWith(SpringExtension.class)
public class UserServiceImplIntegrationTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;



    @TestConfiguration
    static class UserServiceImplTestConfiguration{
        @Bean
        public UserService postService() {
            return new UserServiceImpl();
        }
    }


    @Test
    @DisplayName("When getUserByUsername With Valid Username The Return User")
    public void whengetUserByUsernameWithValidUsernameTheReturnUser(){
        //Arrange
        String username = "Heal2020";
        User user = new User();
        user.setId(10L);
        user.setUsername(username);
        Mockito.when(userRepository.findByUsername(username))
                .thenReturn(Optional.of(user));
        //Act
        User foundUser = userService.getUserByUsername(username);
        //Asset
        assertThat(foundUser.getUsername()).isEqualTo(username);
    }

    @Test
    @DisplayName("When getUserByUsernameAndPassword With Invalid User or Password Then Throws ResourceNotFoundException")
    public void whengetUserByUsernameAndPasswordWithInvalidUserorPasswordThenThrowsResourceNotFoundException(){
        //Arrange
        String template = "Resource %s not found for %s with value %s";
        String username = "Heal2021";
        String password = "password";
        User user = new User();
        user.setId(1001L);
        user.setUsername(username);
        user.setPassword(password);
        Mockito.when(userRepository.findByUsername(username))
                .thenReturn(Optional.empty());

        String exceptedMessage = String.format(template,"User", "Username or password", username + " " + password);
        //Act
        Throwable exception = catchThrowable(()->{
            User foundUser = userService.getUserByUsernameAndPassowrd(username,password);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(exceptedMessage);
    }

    @Test
    @DisplayName("When getUserName With Invalid User Then Throws ResourceNotFoundException")
    public void whenGetUserNameWithInvalidUserThenThrowsResourceNotFoundException(){
        //Arrange
        String template = "Resource %s not found for %s with value %s";
        String username = "Heal2022";
        User user = new User();
        user.setId(1002L);
        user.setUsername(username);
        Mockito.when(userRepository.findByUsername(username))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template,"User","Username",username);
        //Act
        Throwable exception = catchThrowable(()->{
            User foundUser = userService.getUserByUsername(username);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }

}
