package org.java.spring.auth.db.conf;

import org.java.spring.auth.db.serv.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AuthConf {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.cors().disable()
		.authorizeHttpRequests()
		.requestMatchers("/photo/create/**", "/*/edit/**", "/*/*/delete/**", "/*/*/*/create")
				.hasAuthority("ADMIN")
				.requestMatchers("/**", "/photo/**")
				.permitAll()
				.and().formLogin().defaultSuccessUrl("http://localhost:8080/")
				.and().logout().logoutSuccessUrl("http://localhost:5173/");
		return http.build();
	}

	@Bean
	UserDetailsService userDetailsService() {
		return new UserService();
	}

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
}
