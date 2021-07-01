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


import pe.edu.upc.Greencode.model.entity.Order;
import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.model.entity.Waste;
import pe.edu.upc.Greencode.model.entity.WasteOrder;
import pe.edu.upc.Greencode.service.GathererService;
import pe.edu.upc.Greencode.service.OrderService;
import pe.edu.upc.Greencode.service.RecyclerService;
import pe.edu.upc.Greencode.service.WasteOrderService;
import pe.edu.upc.Greencode.service.WasteService;
/*
@Controller
@RequestMapping("/history")*/
public class HistoryController {
	/*@Autowired
	private GathererOrderService gathererorderSevice;
	
	@Autowired
	private OrderService orderSevice;
	
	@Autowired
	private RecyclerService recyclerService;
	
	@Autowired
	private GathererService gathererService;
	
	@Autowired
	private WasteService wasteService;
	
	@Autowired
	private WasteOrderService wasteOrderService;
	
	@GetMapping("purchase")
	public String listHistoryPurchase(Model model , @ModelAttribute("wasteSearch") Waste wasteSearch) {
		try {
			List<Order> orders = orderSevice.getAll();
			model.addAttribute("orders", orders);
			model.addAttribute("wasteSearch", wasteSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "history/purchase";
	}
	
	@GetMapping("sale")
	public String listHistorySale(Model model,@ModelAttribute("wasteSearch") Waste wasteSearch) {
		try {
			List<Order> orders = orderSevice.getAll();
			
			model.addAttribute("orders", orders);
			model.addAttribute("wasteSearch", wasteSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "history/sale";
	}
	
	@GetMapping("purchase/{id}/view")
	public String findHistoryPurchaseById(Model model, @PathVariable("id") Integer id, @ModelAttribute("wasteSearch") Waste wasteSearch) {
		
		try {
			Optional<Order> optional = orderSevice.findById(id);
			List<WasteOrder> listWasteOrder = wasteOrderService.getAll();
			List<Waste> waste1= new ArrayList<Waste>();
			
				for(int i=0; i<listWasteOrder.size(); i++) {
					if(listWasteOrder.get(i).getOrder().getId()==optional.get().getId()) {
						waste1.add(listWasteOrder.get(i).getWaste());
					}
				}
					
				model.addAttribute("optional", optional.get());
				model.addAttribute("waste1", waste1);
				model.addAttribute("wasteSearch", wasteSearch);
				return "history/viewPurchase";	
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/history/purchase";
	}
	
	@GetMapping("sale/{id}/view")
	public String findHistorySaleById(Model model, @PathVariable("id") Integer id, @ModelAttribute("wasteSearch") Waste wasteSearch) {
		try {
			Optional<Order> optional = orderSevice.findById(id);
			Optional<Recycler> recycler= recyclerService.findById(optional.get().getRecycler().getId());
			List<WasteOrder> listWasteOrder = wasteOrderService.getAll();
			List<Waste> waste1= new ArrayList<Waste>();
			
			for(int i=0; i<listWasteOrder.size(); i++) {
				if(listWasteOrder.get(i).getOrder().getId()==optional.get().getId()) {
					waste1.add(listWasteOrder.get(i).getWaste());
				}
			}
				model.addAttribute("optional", optional.get());
				model.addAttribute("waste1", waste1);
				model.addAttribute("wasteSearch", wasteSearch);
				return "history/viewSale";	
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/history/sale";
	}*/
}
