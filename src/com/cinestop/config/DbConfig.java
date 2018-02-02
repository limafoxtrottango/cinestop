package com.cinestop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cinestop.dao.DBQuery;

@Configuration
public class DbConfig {
	
	@Bean
	public DBQuery getDbQueryBean() {
		return new DBQuery();
	}
}
