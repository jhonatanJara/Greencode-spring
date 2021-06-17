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
@RequestMapping("/request")
@SessionAttributes("wasteOrderEdit")
public class RequestController {
	
	
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private GathererService gathererService;
	
	@Autowired
	private RecyclerService recyclerService;
	
	@Autowired
	private WasteService wasteService;
	
	@Autowired
	private WasteOrderService wasteOrderService;
	

	
	
	@GetMapping
	public String list(Model model) {
		try {
			Optional<Gatherer> gatherer= gathererService.findById(1);//Jorge Jara
			List<Order> orders= orderService.getAll();
			List<Order> ordersEmpty = new ArrayList<Order>();
			for(int i=0; i< orders.size(); i++) {
				if(gatherer.get().getId() == orders.get(i).getGatherer().getId()) {
					ordersEmpty.add(orders.get(i));
				}
			}	
			model.addAttribute("ordersEmpty", ordersEmpty);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "request/list";
	}
/*PRIMERA PARTE*/
	@GetMapping("{id}")
	public String findById(Model model ,@PathVariable("id") Integer id) {
		try {
			Optional<Order> order= orderService.findById(id);//Jorge Jara
			//---------
			List<WasteOrder> wasteOrders = wasteOrderService.getAll();
			List<WasteOrder> wasteOrdersEmpty = new ArrayList<WasteOrder>();
			for(int i=0; i< wasteOrders.size(); i++) {
				if(wasteOrders.get(i).getOrder().getId()==id) {
					wasteOrdersEmpty.add(wasteOrders.get(i));
				}
			}
				model.addAttribute("wasteOrdersEmpty", wasteOrdersEmpty);
				model.addAttribute("order", order.get());
				return "request/view";
		}catch(Exception e){
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/request";
	}
	
	@GetMapping("{id}/update")
	public String updateId(Model model ,@PathVariable("id") Integer id) {
		try {
			Optional<Order> order= orderService.findById(id);//Jorge Jara
			//---------
			List<WasteOrder> wasteOrders = wasteOrderService.getAll();
			List<WasteOrder> wasteOrdersEmpty = new ArrayList<WasteOrder>();
			for(int i=0; i< wasteOrders.size(); i++) {
				if(wasteOrders.get(i).getOrder().getId()==id) {
					wasteOrdersEmpty.add(wasteOrders.get(i));
				}
			}
				model.addAttribute("wasteOrdersEmpty", wasteOrdersEmpty);
				model.addAttribute("order", order.get());
				return "request/purchase";
		}catch(Exception e){
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/request";
	}
	
	
	@PostMapping("/change")
	public String updateOrder(Model model, @ModelAttribute("wasteOrdersEmpty") WasteOrder wasteOrder) {
		try {
			wasteOrderService.update(wasteOrder);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/request";	
	}
	
	
	/*
	@GetMapping("{id}/update")
	public String editById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Order> order = orderService.findById(id);
			List<WasteOrder> wasteOrders=new  ArrayList<WasteOrder>();
			wasteOrders=order.get().getWasteOrders();
			for(int i=0; i<= wasteOrders.size(); i++) {
				  model.addAttribute("wasteOrderEdit", wasteOrders.get(i));
			  }
			model.addAttribute("wasteOrders", wasteOrders);
				return "request/purchase";
				
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/request/list";
	}
	
	
	@GetMapping("purchase")
	public String requestPurchase(Model model) {
		try {
			Optional<Gatherer> gatherer= gathererService.findById(1);//Jorge Jara
			List<Order> orders= orderService.getAll();
			List<Order> ordersEmpty = new ArrayList<Order>();
			for(int i=0; i< orders.size(); i++) {
				if(gatherer.get().getId() == orders.get(i).getGatherer().getId()) {
					ordersEmpty.add(orders.get(i));
				}
			}	
			model.addAttribute("ordersEmpty", ordersEmpty);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "request/list";
	}
*/
	
	
}
