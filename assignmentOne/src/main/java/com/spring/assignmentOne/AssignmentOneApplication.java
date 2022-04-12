package com.spring.assignmentOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.spring.assignmentOne.**")
public class AssignmentOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentOneApplication.class, args);
	}

//	@Bean
//	public ModelMapper modelMapper(){
//		return new ModelMapper();
//	}

}
