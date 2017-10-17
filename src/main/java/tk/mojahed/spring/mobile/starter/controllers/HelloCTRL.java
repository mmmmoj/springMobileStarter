package tk.mojahed.spring.mobile.starter.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloCTRL {
	
	@RequestMapping("/hello")
	public String sayHi() {
		return "HI";
	}
}
