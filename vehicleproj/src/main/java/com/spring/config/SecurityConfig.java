package com.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import com.spring.service.CustomUserDetailsService;

import lombok.extern.slf4j.Slf4j;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
    
	@Autowired
	private CustomUserDetailsService customuserdetailservice;
	
@Bean
public SecurityFilterChain SecurityFilterChain (HttpSecurity http) throws Exception
{
	log.debug("entered security chain method");
    http.authorizeHttpRequests(requests -> requests
            .requestMatchers("/home","/api/login",
					"/api/logout","/api/registration"
					,"/swagger-ui/index.html","/v3/api-docs").permitAll()
            .requestMatchers("/api/admin/**").hasRole("ADMIN")
            .requestMatchers("/api/user").hasAnyRole("USER", "ADMIN")
            .anyRequest().authenticated()).httpBasic(withDefaults()).csrf(csrf -> csrf.disable());
    log.debug("security chain method exit");
	return http.build();
}



protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	log.debug("config method entered");
    auth.userDetailsService(customuserdetailservice).passwordEncoder(passwordencoder());
    log.debug("config method exited");
}




@Bean
SecurityContextLogoutHandler getsecuritycontext() {
	return new SecurityContextLogoutHandler();
}
@Bean
public AuthenticationManager authenticationManager(
		UserDetailsService userDetailsService,
		PasswordEncoder passwordEncoder) {
	DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	authenticationProvider.setUserDetailsService(userDetailsService);
	authenticationProvider.setPasswordEncoder(passwordEncoder);

	return new ProviderManager(authenticationProvider);
}
@Bean
public PasswordEncoder passwordencoder() {
	return new BCryptPasswordEncoder();
}

}