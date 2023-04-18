package com.qa.springdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatController {

	@GetMapping("/index.html")
	public String greeting() {
		return "Hello Ello";
	}

}
