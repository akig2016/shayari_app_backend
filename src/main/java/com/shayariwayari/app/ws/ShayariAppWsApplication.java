package com.shayariwayari.app.ws;

import com.shayariwayari.app.ws.user.security.AppPropertyReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ShayariAppWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShayariAppWsApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() { return new BCryptPasswordEncoder();}
	@Bean
	public SpringApplicationContext springApplicationContext(){return  new SpringApplicationContext();}
	@Bean("AppPropertyReader")
	public AppPropertyReader getAppPropertyReader(){
		return new AppPropertyReader();
	}
}
