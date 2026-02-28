package com.demo.CamCon;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CamConApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamConApplication.class, args);
	}
	
	
	
	@Bean //Indicates that a method produces a bean to be managed by the Spring container
	public ModelMapper myMapper()
	{
		//create model mapper instance
		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper;	} 

}
