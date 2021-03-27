package com.Health;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages={"com.Controller","com.Dao","com.Model","com.Health"})
public class SearchForHealthCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchForHealthCareApplication.class, args);
	}

}
