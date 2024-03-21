package com.spring.secure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.secure.dto.LoginDto;
import com.spring.secure.dto.UserDto;
import com.spring.secure.service.UserService;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api")
public class AuthController {

	@Autowired
	private UserService userService;
	
	
	
	@Autowired
	private SecurityContextLogoutHandler logouthandler;
	
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }
    @PostMapping("/registration")
	public String saveUser(@RequestBody UserDto userDto) {
		userService.save(userDto);
		return "registered";
	}
    
    @PostMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
    	log.info("user loggged out");
    	logouthandler.logout(request, response, null);
    	logouthandler.setClearAuthentication(true);
		return "user loggedout";
	}
    
    @GetMapping("/welcome")
    public String welcome() {
    	return "Registration Successfull";
    }
}