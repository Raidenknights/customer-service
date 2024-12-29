package com.example.Prep.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.Prep.constants.Constants;

/**
 * This is a configuration class which enables security filter chain for the
 * spring boot application.
 * 
 * @author Manas Vishnoi
 */
@Configuration
@EnableWebSecurity
public class CustomerSecurityConfiguration {

	/**
	 * This is the default security chain for authenticating API's.
	 * 
	 * @param http
	 * @return
	 * @throws Exception
	 */
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

		return http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers(Constants.OPEN_AI_IMAGE_GENERATION_URL).permitAll())
				.authorizeHttpRequests(auth -> auth.requestMatchers(Constants.OPEN_AI_CHAT_RESPONSE_URL).permitAll())
				.authorizeHttpRequests(auth -> auth.requestMatchers("create/user/new").permitAll()
						.requestMatchers("/customer/fetch/{username}").authenticated())
				.build();
	}

	/**
	 * This bean will used for password encoder for BCryptPassword encoder.
	 * 
	 */
	@Bean
	PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

}
