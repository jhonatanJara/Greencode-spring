package pe.edu.upc.Greencode.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.Greencode.model.entity.Coupon;
import pe.edu.upc.Greencode.model.entity.Order;
import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.service.OrderService;
import pe.edu.upc.Greencode.service.RecyclerService;

@Controller
@RequestMapping("/history")
public class HistoryController {
	@Autowired
	private OrderService orderSevice;
	
	@Autowired
	private RecyclerService recyclerService;
	
	@GetMapping("purchase")
	public String listHistoryPurchase(Model model) {
		try {
			List<Order> orders = orderSevice.getAll();
			model.addAttribute("orders", orders);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "history/purchase";
	}
	
	@GetMapping("purchase/{id}/view")
	public String findHistoryPurchaseById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Order> optional = orderSevice.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("order", optional.get());
				return "history/viewPurchase";
			}	
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/history/purchase";
	}
}
