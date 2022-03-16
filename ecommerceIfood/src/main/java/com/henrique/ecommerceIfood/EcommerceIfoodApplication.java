package com.henrique.ecommerceIfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EcommerceIfoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceIfoodApplication.class, args);
	}

}
