package pe.edu.upc.Greencode.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.Greencode.model.entity.Order;
import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.model.entity.Waste;
import pe.edu.upc.Greencode.service.RecyclerService;
import pe.edu.upc.Greencode.service.WasteService;

@Controller
@RequestMapping("/request")
public class RequestController {
	
	@Autowired
	private RecyclerService recyclerService;
	
	@Autowired
	private WasteService wasteService;
	
	
	@GetMapping
	public String list(Model model) {
		try {
			List<Recycler> recyclers = recyclerService.getAll();
			model.addAttribute("recyclers", recyclers);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "request/list";
	}
		
	@GetMapping("{id}")
	public String findById(Model model,@PathVariable("id") Integer id) {
		try {
			Optional<Recycler> recycler = recyclerService.findById(id);
			List<Waste> waste= wasteService.getAll();
			List<Waste> waste1 = new ArrayList<Waste>();
			for(int i=0; i< waste.size(); i++) {
				if(waste.get(i).getRecycler().getId()==recycler.get().getId()) {
					waste1.add(waste.get(i));
				}
			}
				model.addAttribute("waste1", waste1);
				return "request/view";
		}catch(Exception e){
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/request";
	}
	
	
}
