package com.student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers("/login", "/login.html").permitAll()
						.requestMatchers("/api/students/**").authenticated().anyRequest().authenticated())
				.formLogin(
						form -> form.loginPage("/login.html").defaultSuccessUrl("/dashboard.html", true).permitAll());

		return http.build();
	}
}