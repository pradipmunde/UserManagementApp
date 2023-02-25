package com.pradip.configuration;

import org.springframework.context.annotation.Bean;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfiguration {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
		
	}

}
