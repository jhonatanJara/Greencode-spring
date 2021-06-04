package pe.edu.upc.Greencode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GathererController {
	
	@GetMapping("/dashboard")
	public String Home() {
		return "dashboard";
	}
}
