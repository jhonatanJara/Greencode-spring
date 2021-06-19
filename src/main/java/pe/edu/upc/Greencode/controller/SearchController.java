package pe.edu.upc.Greencode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.Greencode.model.entity.Waste;
import pe.edu.upc.Greencode.service.WasteService;

@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private WasteService wasteService;
	
	@GetMapping("wastes")
	public String searchWastes(Model model , @ModelAttribute("wasteSearch") Waste wasteSearch) {
		
		List<Waste> wastes =null;
		
		try {
			wastes= wasteService.findByName(wasteSearch.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("wastes", wastes);
		model.addAttribute("wasteSearch", wasteSearch);
		return "recycle/wastes";
	}
}
