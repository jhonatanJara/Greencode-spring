package pe.edu.upc.Greencode.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.Greencode.model.entity.Order;
import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.service.OrderService;
import pe.edu.upc.Greencode.service.RecyclerService;

@Controller
@RequestMapping("/rate")
public class QualifyController {
	@Autowired
	private OrderService orderSevice;
	
	@Autowired
	private RecyclerService recyclerService;
	
	@GetMapping("recycler/{id}")
	public String rateRecycler(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Order> order = orderSevice.findById(id);
			Optional<Recycler> recycler= recyclerService.findById(order.get().getRecycler().getId());
				model.addAttribute("recycler", recycler.get());
				return "rate/recycler";	
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/history/purchase";
	}
	
	

}
