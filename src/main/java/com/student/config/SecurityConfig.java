package com.student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
	
	@Bean
	public UserDetailsService userDetailsService() {
	    PasswordEncoder encoder = new BCryptPasswordEncoder();

	    UserDetails admin = User.builder()
	            .username("admin")
	            .password(encoder.encode("admin123")) // 🔥 encrypted
	            .roles("ADMIN")
	            .build();

	    return new InMemoryUserDetailsManager(admin);
	}
}