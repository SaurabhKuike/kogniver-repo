package com.spring.secure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
    @Value("${spring.security.user.name}")
    private String username;

    @Value("${spring.security.user.password}")
    private String password;

    @Value("${spring.security.user.roles}")
    private String roles;
    
    
@Bean
public SecurityFilterChain SecurityFilterChain (HttpSecurity http) throws Exception
{
    http.authorizeHttpRequests(requests -> requests
            .requestMatchers("/home","/api/login","/api/logout","/api/registration").permitAll()
            .requestMatchers("/api/admin/**").hasRole("ADMIN")
            .requestMatchers("/api/user").hasAnyRole("USER", "ADMIN")
            .anyRequest().authenticated()).httpBasic(withDefaults()).csrf(csrf -> csrf.disable());
	return http.build();
}



protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService()).passwordEncoder(passwordencoder());
}


@Bean
public UserDetailsService userDetailsService() {
    UserDetails user = User.builder()
            .username(username)
            .password(passwordencoder().encode(password))
            .roles(roles)
            .build();
    return new InMemoryUserDetailsManager(user);
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