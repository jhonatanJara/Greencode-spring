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

import pe.edu.upc.Greencode.model.entity.Coupon;
import pe.edu.upc.Greencode.model.entity.Order;
import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.model.entity.Waste;
import pe.edu.upc.Greencode.service.OrderService;
import pe.edu.upc.Greencode.service.RecyclerService;
import pe.edu.upc.Greencode.service.WasteService;

@Controller
@RequestMapping("/history")
public class HistoryController {
	@Autowired
	private OrderService orderSevice;
	
	@Autowired
	private RecyclerService recyclerService;
	
	@Autowired
	private WasteService wasteService;
	
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
			Optional<Recycler> recycler= recyclerService.findById(optional.get().getRecycler().getId());
			List<Waste> waste= wasteService.getAll();
			List<Waste> waste1 = new ArrayList<Waste>();
			for(int i=0; i< waste.size(); i++) {
				if(waste.get(i).getRecycler().getId()==recycler.get().getId()) {
					waste1.add(waste.get(i));
				}
			}
				model.addAttribute("optional", optional.get());
				model.addAttribute("waste1", waste1);
				return "history/viewPurchase";	
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/history/purchase";
	}
}
