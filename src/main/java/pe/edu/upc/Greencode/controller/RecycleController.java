package pe.edu.upc.Greencode.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.Greencode.business.OrderGathererService;
import pe.edu.upc.Greencode.model.entity.Gatherer;
import pe.edu.upc.Greencode.model.entity.Order;
import pe.edu.upc.Greencode.model.entity.Waste;
import pe.edu.upc.Greencode.service.GathererService;
import pe.edu.upc.Greencode.service.WasteService;

@Controller
@RequestMapping("/recycle")

public class RecycleController {
	
	@Autowired
	private WasteService wasteService;
	
	@Autowired
	private GathererService gathererService;
	
	@Autowired
	private OrderGathererService orderGathererService;
	
	public List<Waste> listWastes = new ArrayList<Waste>();
	
	@GetMapping	
	public String list(Model model, @ModelAttribute("wasteSearch") Waste wasteSearch) {
		try {
			List<Waste> wastes = wasteService.availableWastes();
			
			model.addAttribute("wastes", wastes);
			model.addAttribute("recyclerWastes",listWastes);
			model.addAttribute("wasteSearch", wasteSearch);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "recycle/wastes";
	}	

	
	@GetMapping("{id}/new")
	public String newWaste(@PathVariable("id") Integer id) {
		try {
			
			Waste w = orderGathererService.addWaste(id);
			listWastes.add(w);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}	
		return "redirect:/recycle";
	}
	
	@GetMapping("{id}/del")
	public String delWaste(@PathVariable("id") Integer id) {
		try {
			Optional<Waste> optional = wasteService.findById(id);
			
			if(optional.isPresent()) {
				//wasteService.deleteById(id);
				for(int i=0; i<listWastes.size(); i++) {
					if(listWastes.get(i).getId()==optional.get().getId()) {
						listWastes.remove(listWastes.get(i));
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}	
		return "redirect:/recycle";
	}
	

	@GetMapping("/gatherers")
	public String listGatherers(Model model, @ModelAttribute("wasteSearch") Waste wasteSearch) {
		try {
			
			List<Gatherer> gatherers = gathererService.getAll();
			
			model.addAttribute("gatherers", gatherers);
			model.addAttribute("wasteSearch", wasteSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "recycle/gatherers";
	}

	
	@GetMapping("/gatherers/{id}/view")
	public String findById(Model model, @PathVariable("id") Integer id, @ModelAttribute("wasteSearch") Waste wasteSearch) {
		try {
			
			Optional<Gatherer> optional = gathererService.findById(id);
			
			if (optional.isPresent()) {
				
				model.addAttribute("gatherer", optional.get());
				model.addAttribute("wasteSearch", wasteSearch);
				return "recycle/viewGatherer";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/recycle/gatherers";
	}
	
	
	@GetMapping("/gatherers/byDistrict")
	public String byDistrict(Model model, @ModelAttribute("wasteSearch") Waste wasteSearch) {
		try {
			List<Gatherer> gatherers = orderGathererService.gatherersByDistrict(1);	
			
			model.addAttribute("gatherers", gatherers);
			model.addAttribute("wasteSearch", wasteSearch);
			return "recycle/gatherers";
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "recycle/gatherers";
	}	
	
	
	@GetMapping("/gatherers/best")
	public String bestGatherers(Model model, @ModelAttribute("wasteSearch") Waste wasteSearch) {
		try {
			List<Gatherer> gatherers = orderGathererService.bestGatherers();
					
			model.addAttribute("gatherers", gatherers);
			model.addAttribute("wasteSearch", wasteSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "recycle/gatherers";
	}	
	
	
	@GetMapping("{id}/Request")
	public String newOrder(@PathVariable("id") Integer id) {
		try {
			Order order = orderGathererService.newOrderGatherer(1, id);
			
			for(int i=0; i<= listWastes.size(); i++) {
				orderGathererService.detailsOrderGatherer(listWastes.get(i), order);
			}  
			order = null;
			listWastes.clear();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}	
		return "redirect:/recycle/gatherers";
	}
}
