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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.Greencode.model.entity.Order;
import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.service.OrderService;
import pe.edu.upc.Greencode.service.RecyclerService;

@Controller
@RequestMapping("/qualify")
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
			List<Integer> points= new ArrayList<Integer>();
			points.add(1);
			points.add(2);
			points.add(3);
			points.add(4);
			points.add(5);
			model.addAttribute("lpoints",points);
				return "qualify/recycler";	
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/history/purchase";
	}
	

	@PostMapping("recycler/save")
	public String saveQualifyRecycler(Model model, @ModelAttribute("recycler") Recycler recycler) {
		try {
				recycler.setCalification(recycler.getPoints()+recycler.getCalification());
				recyclerService.update(recycler);
				
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/history/purchase";
	}
	

}
