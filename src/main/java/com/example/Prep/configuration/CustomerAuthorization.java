package com.example.Prep.configuration;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.Prep.entity.CustomerEntity;
import com.example.Prep.repository.CustomerRepository;

/**
 * This is a custom authentication provider. It will authenticate all incoming
 * requests as per filter chain.
 * 
 * @author Manas Vishnoi
 */
@Component
public class CustomerAuthorization implements AuthenticationProvider {

	private static final Logger logger = LoggerFactory.getLogger(CustomerAuthorization.class);

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		CustomerEntity customersData = customerRepository.findByusername(username);
		logger.debug("authenticating user");

		if (customersData == null) {
			throw new BadCredentialsException("Username is not registered in the Database");
		}

		if (passwordEncoder.matches(password, customersData.getPassword())) {
			logger.debug("User found");
			List<GrantedAuthority> authorities = new ArrayList<>();
			logger.debug("customers " + customersData.getRole());
			authorities.add(new SimpleGrantedAuthority(customersData.getRole()));
			return new UsernamePasswordAuthenticationToken(username, password, authorities);
		} else {
			throw new BadCredentialsException("Wrong Password. Please enter new password");
		}

	}

	@Override
	public boolean supports(Class<?> authentication) {

		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
