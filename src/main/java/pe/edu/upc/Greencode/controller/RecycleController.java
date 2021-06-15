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
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.Greencode.model.entity.Gatherer;
import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.model.entity.Waste;
import pe.edu.upc.Greencode.service.GathererService;
import pe.edu.upc.Greencode.service.RecyclerService;
import pe.edu.upc.Greencode.service.WasteService;

@Controller
@RequestMapping("/recycle")
@SessionAttributes("wasteEdit")

public class RecycleController {
	
	@Autowired
	private RecyclerService recyclerService;
	
	@Autowired
	private WasteService wasteService;
	
	@Autowired
	private GathererService gathererService;
	
	@GetMapping	
	public String list(Model model) {
		try {
			Optional<Recycler> recycler= recyclerService.findById(1);
			
			List<Waste> wastess = recycler.get().getWastes();				
			List<Waste> wastes = wasteService.getAll();
			List<Waste> wa = new ArrayList<Waste>();
			
			for(int i=0; i< wastes.size(); i++) {
				if(wastes.get(i).getRecycler()==null) {
					wa.add(wastes.get(i));
				}
			}				
			model.addAttribute("wastes", wa);
			model.addAttribute("wastess", wastess);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "recycle/wastes";
	}	
	
	@GetMapping("{id}/del")
	public String delWaste(@PathVariable("id") Integer id) {
		try {
			Optional<Waste> optional = wasteService.findById(id);
			if(optional.isPresent()) {
				wasteService.deleteById(id);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}	
		return "redirect:/recycle";
	}
	
	@GetMapping("{id}/new")
	public String newWaste(@PathVariable("id") Integer id) {
		try {
			Optional<Recycler> recycler= recyclerService.findById(1);
			Waste w= new Waste();
			Optional<Waste> optional = wasteService.findById(id);
			if(optional.isPresent()) {
				w.setName(optional.get().getName());
				w.setCategory(optional.get().getCategory());
				w.setRecycler(recycler.get());
				wasteService.create(w);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}	
		return "redirect:/recycle";
	}
	/* --------------GATHERE ----------     */
	@GetMapping("/gatherer")
	public String listGatherer(Model model) {
		try {
		
			List<Gatherer> gatherers = gathererService.getAll();
		
			model.addAttribute("gatherers", gatherers);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "recycle/gatherers";
	}
	
	@GetMapping("/gatherer/{id}/view")
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Gatherer> optional = gathererService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("gatherer", optional.get());
				return "recycle/viewGatherer";
			}	
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/rewards";
	}
	
}
