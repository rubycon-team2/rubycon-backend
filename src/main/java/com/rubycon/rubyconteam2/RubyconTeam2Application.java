package com.rubycon.rubyconteam2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class RubyconTeam2Application {

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
	}

	public static void main(String[] args) {
		SpringApplication.run(RubyconTeam2Application.class, args);
	}
}

@RestController
class HomeContoller{
	@GetMapping("/")
	public String index() {
		return "Hello Spring Boot with AWS EB :)";
	}
}