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

import pe.edu.upc.Greencode.business.QualifyRecyclerService;
import pe.edu.upc.Greencode.model.entity.Order;
import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.model.entity.Waste;
import pe.edu.upc.Greencode.service.OrderService;

@Controller
@RequestMapping("/qualify")
public class QualifyRecyclerController {
	@Autowired
	private OrderService orderSevice;
	@Autowired
	private QualifyRecyclerService qualifyRecyclerService;
	
	@GetMapping("recycler/{id}")
	public String qualifyRecycler(Model model, @PathVariable("id") Integer id, @ModelAttribute("wasteSearch") Waste wasteSearch) {
		try {
			Optional<Order> order = orderSevice.findById(id);
			Recycler recycler=order.get().getRecycler();
			model.addAttribute("recycler", recycler);
			List<Integer> points= new ArrayList<Integer>();
			points.add(1);
			points.add(2);
			points.add(3);
			points.add(4);
			points.add(5);
			model.addAttribute("lpoints",points);
			model.addAttribute("wasteSearch", wasteSearch);
				return "qualify/recycler";	
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/history/purchase";
	}
	
	@PostMapping("recycler/save")
	public String saveQualifyRecycler(Model model, @ModelAttribute("recycler") Recycler recycler,@ModelAttribute("wasteSearch") Waste wasteSearch) {
		try {
				qualifyRecyclerService.changeQualify(recycler);
				model.addAttribute("wasteSearch", wasteSearch);
				
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/history/purchase";
	}
}
