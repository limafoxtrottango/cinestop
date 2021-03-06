package com.cinestop.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cinestop.constants.CinestopConstants;
import com.cinestop.dao.MovieInfoDaoImpl;

@Configuration
public class MovieInfoDaoImplConfig {

	@Bean
	@Primary
	public DataSource dataSourceBean() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.url(CinestopConstants.DB_URL);
		dataSourceBuilder.username(CinestopConstants.DATABASE_USERNAME);
		dataSourceBuilder.password(CinestopConstants.DATABASE_PASSWORD);
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
