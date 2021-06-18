package pe.edu.upc.hope.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FrontController {
	
	
	@GetMapping("layout")
	public String layout() {
		return "layout/layout";
	}
	
	
	@GetMapping("home")
	public String home() {
		return "layout/home";
	}
	
}
