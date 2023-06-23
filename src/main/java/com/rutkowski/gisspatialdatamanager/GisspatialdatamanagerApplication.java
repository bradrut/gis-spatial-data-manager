package com.rutkowski.gisspatialdatamanager;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class GisspatialdatamanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GisspatialdatamanagerApplication.class, args);
	}

	/*
	 * TODO: Refactor to put beans like this in ApplicationConfig.java (I think the issue is that currently it's not found on classpath)
	 */
	@Bean
  public ModelMapper modelMapper() {
      return new ModelMapper();
  }

}
