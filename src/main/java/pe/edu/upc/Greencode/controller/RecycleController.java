package pe.edu.upc.Greencode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.Greencode.model.entity.Category;
import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.model.entity.Waste;
import pe.edu.upc.Greencode.service.CategoryService;
import pe.edu.upc.Greencode.service.RecyclerService;
import pe.edu.upc.Greencode.service.WasteService;

@Controller
@RequestMapping("/recycle")
public class RecycleController {
	
	@Autowired
	private RecyclerService recyclerService;
	
	@Autowired
	private WasteService wasteService;
	/*
	@GetMapping
	public String waste(Model model) {
		try {
			List<Recycler> recyclers = recyclerService.getAll();
			model.addAttribute("recyclers",recyclers);
			
			List<Category> categories = categoryService.getAll();
			model.addAttribute("categories",categories);
			
		}catch(Exception e){
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "recycle/register";
	}*/
	
	
	@GetMapping	
	public String list(Model model) {
		try {
			List<Waste> wastes = wasteService.getAll();
			model.addAttribute("wastes", wastes);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "recycle/register";
	}
	
	/*@GetMapping
	public String newWaste(Model model) {
		Waste waste= new Waste();
		model.addAttribute("wasteNew", waste);
		return "recycle/register";
	}*/
	
	/*@GetMapping("new")	// GET: /region/new
	public String newregion(Model model) {
		Region region = new Region();
		model.addAttribute("regionNew", region);
		return "regions/new";
		
		@PostMapping("savenew")	// POST: /region/savenew
	public String saveNew(Model model, @ModelAttribute("regionNew") Region region) {		
		try {
			regionService.create(region);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "redirect:/regions";
	}	
	}*/
}
