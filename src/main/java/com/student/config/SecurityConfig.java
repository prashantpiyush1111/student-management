package com.student.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class SecurityConfig {

    @Value("${app.admin.username}")
    private String adminUsername;

    @Value("${app.admin.password}")
    private String adminPassword;

    @Value("${app.demo.username}")
    private String demoUsername;

    @Value("${app.demo.password}")
    private String demoPassword;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        CookieCsrfTokenRepository csrfTokenRepository =
                CookieCsrfTokenRepository.withHttpOnlyFalse();

        http
            .csrf(csrf -> csrf
                .csrfTokenRepository(csrfTokenRepository)
            )

            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/login.html",
                    "/login",
                    "/csrf",
                    "/css/**",
                    "/js/**"
                ).permitAll()

                .requestMatchers(HttpMethod.GET, "/api/students/**")
                    .authenticated()

                .requestMatchers(HttpMethod.POST, "/api/students/**")
                    .hasRole("ADMIN")

                .requestMatchers(HttpMethod.PUT, "/api/students/**")
                    .hasRole("ADMIN")

                .requestMatchers(HttpMethod.DELETE, "/api/students/**")
                    .hasRole("ADMIN")

                .requestMatchers("/dashboard.html", "/dashboard/**", "/")
                    .authenticated()

                .anyRequest().authenticated()
            )

            .formLogin(form -> form
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/dashboard", true)
                .failureUrl("/login.html?error=true")
                .permitAll()
            )

            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login.html?logout=true")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID", "XSRF-TOKEN")
                .permitAll()
            )

            .sessionManagement(session -> session
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false)
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {

        requireCredential("app.admin.username", adminUsername);
        requireCredential("app.admin.password", adminPassword);
        requireCredential("app.demo.username", demoUsername);
        requireCredential("app.demo.password", demoPassword);

        UserDetails admin = User.builder()
                .username(adminUsername)
                .password(passwordEncoder.encode(adminPassword))
                .roles("ADMIN")
                .build();

        UserDetails demoUser = User.builder()
                .username(demoUsername)
                .password(passwordEncoder.encode(demoPassword))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, demoUser);
    }

    private void requireCredential(String property, String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalStateException(property + " is missing");
        }
    }
}
