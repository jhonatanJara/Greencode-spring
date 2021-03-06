package pe.edu.upc.Greencode.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.Greencode.model.entity.Waste;


@Controller
@RequestMapping("/")
@SessionAttributes("newUser")
public class FrontController {
	
	
	@GetMapping
	public String index(Model model) {
		Waste wasteSearch = new Waste();
		model.addAttribute("wasteSearch", wasteSearch);
		return "index";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	
}
