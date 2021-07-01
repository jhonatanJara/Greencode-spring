package pe.edu.upc.Greencode.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.upc.Greencode.model.entity.Gatherer;
import pe.edu.upc.Greencode.model.entity.Order;
import pe.edu.upc.Greencode.model.entity.Waste;
import pe.edu.upc.Greencode.model.entity.WasteOrder;
import pe.edu.upc.Greencode.service.GathererService;
import pe.edu.upc.Greencode.service.OrderService;
import pe.edu.upc.Greencode.service.WasteOrderService;

@Controller
@RequestMapping("/history")
public class HistoryPurchaseController {

	@Autowired
	private OrderService orderSevice;
	
	@Autowired
	private WasteOrderService wasteOrderService;

	@Autowired
	private GathererService gathererService;
	
	
	
	@GetMapping("purchase")
	public String listHistoryPurchase(Model model , @ModelAttribute("wasteSearch") Waste wasteSearch) {
		try {
			Optional<Gatherer> gatherer=gathererService.findById(1);
			List<Order> orders = gatherer.get().getOrders();
			model.addAttribute("orders", orders);
			model.addAttribute("wasteSearch", wasteSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "history/purchase";
	}
	

	@GetMapping("purchase/{id}/view")
	public String findHistoryPurchaseById(Model model, @PathVariable("id") Integer id, @ModelAttribute("wasteSearch") Waste wasteSearch) {
		
		try {
			Optional<Order> optional = orderSevice.findById(id);
			List<WasteOrder> listWasteOrders = optional.get().getWasteOrders();
				model.addAttribute("optional", optional.get());
				model.addAttribute("listWasteOrders", listWasteOrders);
				model.addAttribute("wasteSearch", wasteSearch);
				return "history/viewPurchase";	
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/history/purchase";
	}
	
	
	
}
