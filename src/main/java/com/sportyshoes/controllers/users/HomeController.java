package com.sportyshoes.controllers.users;

//import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class HomeController {
	
//	@CrossOrigin(origins = "http://localhost:8083")
	@GetMapping
	public String index() {
		return "Hello Visitor Welcome to Sporty Shoes!.Get the best shoes for the money";
		
	}

}
