package com.example.Prep.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

//@Configuration
public class CustomContentNegotiationStrategy {

	@Bean
	ContentNegotiationStrategy contentNegotiationStrategy() {
		return new HeaderContentNegotiationStrategy();
	}

}
