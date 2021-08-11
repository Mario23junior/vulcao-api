package com.project.vulcao.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class ModelMapperConfig {
   
	@Bean
	ModelMapper ModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
 	}
}
