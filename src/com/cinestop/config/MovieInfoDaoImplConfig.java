package com.cinestop.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cinestop.constants.DatabaseConstants;
import com.cinestop.dao.MovieInfoDaoImpl;

@Configuration
public class MovieInfoDaoImplConfig {

	@Bean
	@Primary
	public DataSource dataSourceBean() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.url(DatabaseConstants.DB_URL);
		dataSourceBuilder.username(DatabaseConstants.DATABASE_USERNAME);
		dataSourceBuilder.password(DatabaseConstants.DATABASE_PASSWORD);
		return dataSourceBuilder.build();
	}

	@Bean("movieInfoDaoImpl")
	public MovieInfoDaoImpl movieInfoDaoImpl() {
		return new MovieInfoDaoImpl(jdbcTemplateBean());
	}

	@Bean
	public JdbcTemplate jdbcTemplateBean() {
		return new JdbcTemplate(dataSourceBean());
	}
}
