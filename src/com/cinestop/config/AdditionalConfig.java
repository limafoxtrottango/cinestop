package com.cinestop.config;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdditionalConfig {
	
	@Bean(name="objectMapper")
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}
