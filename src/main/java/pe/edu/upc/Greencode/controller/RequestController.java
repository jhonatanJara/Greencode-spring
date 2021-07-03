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
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.Greencode.business.OrderGathererService;
import pe.edu.upc.Greencode.business.RequestRecyclersService;
import pe.edu.upc.Greencode.model.entity.Gatherer;
import pe.edu.upc.Greencode.model.entity.Order;
import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.model.entity.Waste;
import pe.edu.upc.Greencode.model.entity.WasteOrder;
import pe.edu.upc.Greencode.service.GathererService;
import pe.edu.upc.Greencode.service.OrderService;
import pe.edu.upc.Greencode.service.WasteOrderService;

@Controller
@RequestMapping("/request")
@SessionAttributes("orderEdit")
public class RequestController {
	
	
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private GathererService gathererService;
	
	@Autowired
	private RequestRecyclersService requestRecyclersService;
	
	@Autowired
	private WasteOrderService wasteOrderService;
	
	
	@GetMapping
	public String list(Model model,@ModelAttribute("wasteSearch") Waste wasteSearch) {
		try {
			List<Order> orders= requestRecyclersService.ordersbystatus(1);
			System.out.println(orders);
			model.addAttribute("orders", orders);
			model.addAttribute("wasteSearch", wasteSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "request/list";
	
	}
	
/*PRIMERA PARTE*/
	@GetMapping("{id}")
	public String findById(Model model ,@PathVariable("id") Integer id,@ModelAttribute("wasteSearch") Waste wasteSearch) {
		try {
			Optional<Order> order= orderService.findById(id);//Jorge Jara
			List<WasteOrder> wasteOrders= order.get().getWasteOrders();
				model.addAttribute("wasteOrders", wasteOrders);
				model.addAttribute("order", order.get());
				model.addAttribute("wasteSearch", wasteSearch);
				return "request/view";
		}catch(Exception e){
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/request";
	}
	
	/*Update*/
	@GetMapping("{id}/update/accept")
	public String acceptId(Model model ,@PathVariable("id") Integer id,@ModelAttribute("wasteSearch") Waste wasteSearch) {
		try {
			Optional<Order> order= orderService.findById(id);//Jorge Jara
			Order order1= requestRecyclersService.updateStatusOrderAccept(id);//Jorge Jara
			List<WasteOrder> wasteOrders = order.get().getWasteOrders(); 
			
				if(order.isPresent()) {
					model.addAttribute("wasteOrders", wasteOrders);
					model.addAttribute("orderEdit", order1);	
					model.addAttribute("wasteSearch", wasteSearch);
				}
				return "request/purchase";					
		}catch(Exception e){
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/request";
	}
	
	@GetMapping("{id}/update/deny")
	public String denyId(Model model ,@PathVariable("id") Integer id,@ModelAttribute("wasteSearch") Waste wasteSearch) {
		try {
			Optional<Order> order= orderService.findById(id);//Jorge Jara
			requestRecyclersService.updateStatusOrderDeny(id);
				if(order.isPresent()) {	
					model.addAttribute("wasteSearch", wasteSearch);
				}				
		}catch(Exception e){
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/request";
	}
	
	@PostMapping("change")
	public String updateOrder(Model model, @ModelAttribute("orderEdit") Order orderEdit,@ModelAttribute("wasteSearch") Waste wasteSearch) {
		try {
			Optional<Order> order= orderService.findById(orderEdit.getId());//Jorge Jara
			Order order1= requestRecyclersService.updateStatusOrderAccept(orderEdit.getId());//Jorge Jara	
			orderService.update(orderEdit);
			requestRecyclersService.updatePointsRecycler(order1);
			model.addAttribute("wasteSearch", wasteSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/request";	
	}

}
