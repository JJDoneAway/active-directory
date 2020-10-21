package com.example.demo;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	@GetMapping(path = "hello")
	public Authentication hello(//
			Authentication authentication//
	) {

		return authentication;
	}

	@GetMapping(path = "api/hello")
	public String helloApi(//
			Authentication authentication//
	) {

		return "open Access";
	}

}
