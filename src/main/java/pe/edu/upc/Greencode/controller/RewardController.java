package pe.edu.upc.Greencode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.Greencode.model.entity.Category;
import pe.edu.upc.Greencode.service.CategoryService;

@Controller
@RequestMapping("/")
public class RewardController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("rewards")	
	public String list(Model model) {
		try {
			List<Category> categories = categoryService.getAll();
			model.addAttribute("categories", categories);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "coupons/list";
	}
}
