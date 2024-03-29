package com.spring.user.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.spring.user.security.CustomuserDetalService;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class SecurityConfig {

	@Autowired
	private CustomuserDetalService userDetailService;

    
    
	  @Bean
		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	          http
	                  
	                  .authorizeHttpRequests(requests -> requests
	                          .requestMatchers("/api/home","/api/register","/admin/adminprofile","/v3/api-docs","/swagger-ui/index.html").permitAll()
	                          .requestMatchers("/api/user/**").hasAnyRole("ADMIN", "USER")
	                          .requestMatchers("/api/admin/**").hasRole("ADMIN")
	                          .anyRequest().authenticated()).csrf(csrf -> csrf.disable()).httpBasic(withDefaults());
		            
		    return http.build();
		           // .logout(logout->logout.logoutUrl("/authfac/user/logout").permitAll())
		           
		}



protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(this.userDetailService).passwordEncoder(passwordencoder());
}

	@Bean
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
}
