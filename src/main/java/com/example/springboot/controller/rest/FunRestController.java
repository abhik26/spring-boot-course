package com.example.springboot.controller.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	private final String teamName;
	private final String coachName;
	
	FunRestController(@Value("${team.name}") String teamName, @Value("${coach.name}") String coachName) {
		this.teamName = teamName;
		this.coachName = coachName;
	}

	@GetMapping("/hello-world")
	public String sayHello() {
		return "Hello World! Time on server is: " + LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k!";
	}
	
	@GetMapping("/fortune")
	public String getFortune() {
		return "Today is your lucky day!";
	}
	
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach name: " + coachName + ", team name: " + teamName;
	}
}
