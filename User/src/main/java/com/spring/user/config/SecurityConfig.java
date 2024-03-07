package com.spring.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class SecurityConfig {

	
	@Bean
	public UserDetailsService userDetailService(PasswordEncoder encoder) {
		
		UserDetails Admin=User.withUsername("Saurabh")
				.password(encoder.encode("$Aurabh123"))
				.roles("ADMIN","USER")
				.build();
		
		UserDetails user=User.withUsername("user")
				.password(encoder.encode("user"))
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(Admin,user);
	}
	
	@Bean
	public SecurityFilterChain securityfileChain(HttpSecurity http)throws Exception
	{
		
		return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/home").permitAll())
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/user/**").authenticated())
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/admin/**").authenticated())
                .formLogin(login -> login.loginPage("/login")
                        .defaultSuccessUrl("/home") 
                        .failureUrl("/login?error")
                        .permitAll())
                .build();
	}
	
	@Bean
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
}
