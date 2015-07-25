package com.cspinformatique.forms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
@SpringBootApplication
public class CspForms {
	public static void main(String[] args){
		SpringApplication.run(CspForms.class, args);
	}
}
