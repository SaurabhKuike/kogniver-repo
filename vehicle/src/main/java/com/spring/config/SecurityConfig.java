package com.spring.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import com.spring.service.CustomUserDetailsService;

import lombok.extern.slf4j.Slf4j;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Class having Security Configuration
 */
@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
    
	@Autowired
	private CustomUserDetailsService customuserdetailservice;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests
                // Permit access to Swagger UI and API documentation endpoints without authentication
                .requestMatchers(FREETOACCESSSWAGGERENDPOINTS).permitAll()
                // Secure other endpoints
                .requestMatchers("/home", "/api/login", "/api/logout", "/api/registration").permitAll()
                .requestMatchers("/api/admin/**").hasRole("ADMIN")
                .requestMatchers("/api/user").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated())
                .httpBasic(withDefaults())
                .csrf(AbstractHttpConfigurer::disable); // Disable CSRF protection for simplicity, you might want to enable it in a real application
	    return http.build();
	}
	
	private static final String [] FREETOACCESSSWAGGERENDPOINTS={"/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**", "/swagger-resources/**", "/webjars/**"};

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
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
@Bean
public PasswordEncoder passwordencoder() {
	return new BCryptPasswordEncoder();
}


}