package pe.edu.upc.Greencode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/layout")
public class FrontController {
	
	@GetMapping
	public String Home() {
		return "layout/layout";
	}
}
