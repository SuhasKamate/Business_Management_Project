package com.business.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(auth -> auth
				// Public pages
				.requestMatchers("/home", "/about", "/location", "/products", "/login",
						"/css/**", "/JavaScript/**", "/Images/**", "/Videos/**", "/error")
					.permitAll()
				// Admin-only area
				.requestMatchers("/admin/**", "/addAdmin", "/addingAdmin", "/updateAdmin/**",
						"/updatingAdmin/**", "/deleteAdmin/**", "/addUser", "/addingUser",
						"/updateUser/**", "/updatingUser/**", "/deleteUser/**", "/addProduct",
						"/addingProduct", "/updateProduct/**", "/updatingProduct/**",
						"/deleteProduct/**")
					.hasRole("ADMIN")
				// Logged-in customers
				.requestMatchers("/product/**")
					.hasRole("USER")
				.anyRequest().authenticated())
			.formLogin(form -> form
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.usernameParameter("email")
				.passwordParameter("password")
				.defaultSuccessUrl("/home", false)
				.failureUrl("/login?error")
				.permitAll())
			.logout(logout -> logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/home")
				.permitAll());

		return http.build();
	}
}
