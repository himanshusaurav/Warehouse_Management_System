package com.jsp.warehouse.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigured {

	@Bean
	 PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder(12);
	}
	
	@Bean
	 SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		return httpSecurity.csrf( csrf -> csrf.disable())
				.authorizeHttpRequests(authorize->
				authorize.requestMatchers("/register")
				.permitAll()
				.anyRequest().authenticated())
				.formLogin(Customizer.withDefaults())
				.build();

	}
}




