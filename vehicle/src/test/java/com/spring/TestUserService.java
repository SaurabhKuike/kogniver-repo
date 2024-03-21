package com.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.Dto.UserDto;
import com.spring.entity.Roles;
import com.spring.entity.User;
import com.spring.repository.UserRepository;
import com.spring.service.UserServiceImpl;

@SpringBootTest
public class TestUserService {

    @MockBean
    private UserRepository userRepository;
    
    @MockBean
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void testSave() {

        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFullname("John Doe");
        userDto.setEmail("john.doe@example.com");
        userDto.setPassword("password123");
        userDto.setRole(List.of(
                new Roles(1, "ROLE_ADMIN"), new Roles(2, "ROLE_USER")));

        User expectedUser = new User(userDto.getId(), userDto.getFullname(), userDto.getEmail(), passwordEncoder.encode("encoded"), userDto.getRole());

        when(passwordEncoder.encode(userDto.getPassword())).thenReturn("password123");

        User savedUser = userService.save(userDto);
        System.out.println(expectedUser);
//        assertEquals(savedUser, expectedUser);
        verify(passwordEncoder).encode(userDto.getPassword()); 
    }
    
}
