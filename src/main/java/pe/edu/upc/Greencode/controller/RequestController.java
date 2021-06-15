package pe.edu.upc.Greencode.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.service.RecyclerService;

@Controller
@RequestMapping("/request")
public class RequestController {

	@Autowired
	private RecyclerService recyclerService;
	
	@GetMapping
	public String list(Model model) {
		try {
			List<Recycler> recyclers = recyclerService.getAll();
			model.addAttribute("recyclers", recyclers);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "request/list";
	}
		
	@GetMapping("{id}")
	public String findById(Model model,@PathVariable("id") Integer id) {
		try {
			Optional<Recycler> optional=recyclerService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("recycler", optional.get());//Extrae el elemeto del optional y lo envia como atributo
				return "request/view";
			}
		}catch(Exception e){
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/request";
	}
}
