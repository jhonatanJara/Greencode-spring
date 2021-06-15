package pe.edu.upc.Greencode.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import pe.edu.upc.Greencode.service.OrderService;

@Controller
@RequestMapping("/history")
public class HistoryController {
	@Autowired
	private OrderService orderSevice;
	
	@GetMapping("purchase")
	public String list(Model model) {
		return "history/purchase";
	}
}
