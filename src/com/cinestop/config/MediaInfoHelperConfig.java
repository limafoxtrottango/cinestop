package com.cinestop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cinestop.helper.MediaInfoHelper;

@Configuration
public class MediaInfoHelperConfig {
	
	@Bean
	private MediaInfoHelper getMediaInfoHelperBean() {
		return new MediaInfoHelper();
	}
}
