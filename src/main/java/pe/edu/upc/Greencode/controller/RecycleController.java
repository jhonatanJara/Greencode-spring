package pe.edu.upc.Greencode.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.Greencode.model.entity.Gatherer;
import pe.edu.upc.Greencode.model.entity.Order;
import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.model.entity.Waste;
import pe.edu.upc.Greencode.model.entity.WasteOrder;
import pe.edu.upc.Greencode.service.GathererService;
import pe.edu.upc.Greencode.service.OrderService;
import pe.edu.upc.Greencode.service.RecyclerService;
import pe.edu.upc.Greencode.service.WasteOrderService;
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
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private WasteOrderService wasteOrderService;
	
	@GetMapping	
	public String list(Model model, @ModelAttribute("wasteSearch") Waste wasteSearch) {
		try {
			Optional<Recycler> recycler= recyclerService.findById(1);
			List<Waste> recyclerWastes = recycler.get().getWastes();
			
			
			List<Waste> wastes = wasteService.getAll();
			List<Waste> wa = new ArrayList<Waste>();
			for(int i=0; i< wastes.size(); i++) {
				if(wastes.get(i).getRecycler()==null) {
					wa.add(wastes.get(i));
				}
			}			
			recycler.get().setWastes(wa);
				
			
			model.addAttribute("wastes", wa);
			model.addAttribute("recyclerWastes",recyclerWastes);
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
			Optional<Recycler> recycler= recyclerService.findById(1);
			Optional<Waste> optional = wasteService.findById(id);
			Waste w= new Waste();
			
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
	
	@GetMapping("{id}/del")
	public String delWaste(@PathVariable("id") Integer id) {
		try {
			Optional<Waste> optional = wasteService.findById(id);
			
			if(optional.isPresent()) {
				wasteService.deleteById(id);
				return "redirect:/recycle";
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
			Optional<Recycler> recycler= recyclerService.findById(1);
			
			List<Gatherer> gatherers = gathererService.getAll();				
			List<Gatherer> newList = new ArrayList<Gatherer>();
			
			for(int i=0; i< gatherers.size(); i++) {
				if(recycler.get().getDistrict() == gatherers.get(i).getDistrict()) {
					newList.add(gatherers.get(i));
				}
			}		
			model.addAttribute("gatherers", newList);
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
			List<Gatherer> gatherers = gathererService.getAll();				
			List<Gatherer> newList = new ArrayList<Gatherer>();
			
			for(int i=0; i< gatherers.size(); i++) {
				if(gatherers.get(i).getCalification()>=8 && gatherers.get(i).getCalification()<=10 ) {
					newList.add(gatherers.get(i));
				}
			}		
			model.addAttribute("gatherers", newList);
			model.addAttribute("wasteSearch", wasteSearch);
			return "recycle/gatherers";
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "recycle/gatherers";
	}	
	
	@GetMapping("{id}/Request")
	public String newOrder(@PathVariable("id") Integer id) {
		try {
			Optional<Recycler> recycler= recyclerService.findById(1);
			Optional<Gatherer> gatherer= gathererService.findById(id);
			List<Waste> wastes = recycler.get().getWastes();	
			
			Order order= new Order();
			Date fecha = new Date();
			
			
			if(gatherer.isPresent()) {
			  order.setDate(fecha);
			  order.setStatus("In progress");
			  order.setRecycler(recycler.get());
			  order.setGatherer(gatherer.get());
			  
			  orderService.create(order);
			  
			  for(int i=0; i<= wastes.size(); i++) {
				  WasteOrder wasteOrder = new WasteOrder();
				  wasteOrder.setOrder(order);
				  wasteOrder.setWaste(wastes.get(i));
				  wasteOrder.setPrice(wastes.get(i).getCategory().getPriceKilo());
				  
				  wasteOrderService.create(wasteOrder);
				  wasteOrder = null;
			  }
			  order = null;
			  
			  return "redirect:/recycle/gatherers";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}	
		return "redirect:/recycle/gatherers";
	}
	
}
