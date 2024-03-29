package com.spring.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Dto.LoginDto;
import com.spring.Dto.UserDto;
import com.spring.customresponsehandler.CustomResponseHandler;
import com.spring.service.UserServiceImpl;

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
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * Controller for authorizing USER
 *
 */
@RestController
@Slf4j
@RequestMapping("/api")
@SecurityRequirement(name = "vehicle")
public class AuthController {

	@Autowired
	private UserServiceImpl userService;
	
	
	
	@Autowired
	private SecurityContextLogoutHandler logouthandler;
	
    @Autowired
    private AuthenticationManager authenticationManager;

	/**
	 *Method to authenticate a User
	 * @param loginDto Pass loginDto object as parameter to log in the User
	 * @return ResponseEntity Object with message User signed in successfully and HttpStatus ok and code 200
	 */
    @PostMapping("/login")
    public ResponseEntity<Object> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        log.info("user Logined");
     return   CustomResponseHandler.responsebuilder("User Signed-in Successfully!", HttpStatus.OK, authentication);
      
    }

	/**
	 *Method to register a user
	 * @param userDto DTO class having fields to register a user
	 * @return ResponseEntity having message User Registered Successfully and HttpStatus Created and Code 201 and return UserDto object
	 */
	@PostMapping("/registration")
	public ResponseEntity<Object> saveUser(@RequestBody UserDto userDto) {
		userService.save(userDto);
		log.info("user registered");
		 return   CustomResponseHandler.responsebuilder("User Registered Successfully!", HttpStatus.CREATED, userDto);
	}

	/**
	 *Method to log out a user and clear authentication object from security context
	 * @param request Http Request Object as parameter
	 * @param response Http Response Object as parameter
	 * @return ResponseEntity Object with message and HttpStatus ok and object
	 */
	@PostMapping("/logout")
	public ResponseEntity<Object> logout(HttpServletRequest request,HttpServletResponse response) {
    	log.info("user loggged out");
    	logouthandler.logout(request, response, null);
    	logouthandler.setClearAuthentication(true);
    	log.info("user logout");
    	return   CustomResponseHandler.responsebuilder("User Logged-Off Successfully!", HttpStatus.OK, logouthandler);
	}

	/**
	 *Role free endpoint for checking
	 * @return return a message This Endpoint can be accessed by any role
	 */
	@GetMapping("/welcome")
    public String welcome() {
    	return " This Endpoint can be accessed by any role";
    }
}