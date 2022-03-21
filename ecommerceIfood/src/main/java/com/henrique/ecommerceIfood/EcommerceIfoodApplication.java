package com.henrique.ecommerceIfood;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EcommerceIfoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceIfoodApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


	public static Algorithm getAlgorithm(String secret){
		return Algorithm.HMAC256(secret.getBytes());
	}
}
