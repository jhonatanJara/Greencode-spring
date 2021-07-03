package pe.edu.upc.Greencode.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.Greencode.model.entity.Gatherer;
import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.model.entity.User;
import pe.edu.upc.Greencode.model.entity.Waste;
import pe.edu.upc.Greencode.security.MyUserDetails;
import pe.edu.upc.Greencode.service.GathererService;
import pe.edu.upc.Greencode.service.RecyclerService;
import pe.edu.upc.Greencode.service.UserService;
import pe.edu.upc.Greencode.utils.Segment;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private GathererService gathererService;
	
	@Autowired
	private RecyclerService recyclerService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String profile(Model model,@ModelAttribute("wasteSearch") Waste wasteSearch) {
				// Obtener el usuarioDetails para obtener los datos de reciclador o recolector 
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				MyUserDetails myUserDetails = (MyUserDetails)authentication.getPrincipal();
				
				// Obtener los datos del reciclador o recolector 
				try {
					if (myUserDetails.getSegment() == Segment.GATHERER) {
						Optional<Gatherer> optional = gathererService.findById(myUserDetails.getIdSegment());
						if (optional.isPresent()) {
							model.addAttribute("segment", "GATHERER");
							model.addAttribute("gatherer", optional.get());
						}
					} 
					else if (myUserDetails.getSegment() == Segment.RECYCLER) {
						Optional<Recycler> optional = recyclerService.findById(myUserDetails.getIdSegment());
						if (optional.isPresent()) {
							model.addAttribute("segment", "RECYCLER");
							model.addAttribute("recycler", optional.get());
						}
					}
					model.addAttribute("wasteSearch", wasteSearch);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return "profile/profile";
		
	}
	
	@GetMapping("gathererEdit")	// GET: /profile/{id}/edit
	public String gathererEdit(Model model,@ModelAttribute("wasteSearch") Waste wasteSearch) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MyUserDetails myUserDetails = (MyUserDetails)authentication.getPrincipal();
		
		try {
			Optional<Gatherer> optional = gathererService.findById(myUserDetails.getIdSegment());
			if (optional.isPresent()) {
				model.addAttribute("gatherer", optional.get());
				return "profile/gathererEdit";
			}
		model.addAttribute("wasteSearch", wasteSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/profile";
	}
	@GetMapping("recyclerEdit")	// GET: /recycler/{id}/edit
	public String recyclerEdit(Model model,@ModelAttribute("wasteSearch") Waste wasteSearch) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MyUserDetails myUserDetails = (MyUserDetails)authentication.getPrincipal();
		
		try {
			Optional<Recycler> optional = recyclerService.findById(myUserDetails.getIdSegment());
			if (optional.isPresent()) {
				model.addAttribute("recycler", optional.get());
				return "profile/recyclerEdit";
			}
		model.addAttribute("wasteSearch", wasteSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/profile";
	}
	
	@PostMapping("saveGathererEdit")	// POST: /region/saveGathererEdit
	public String saveUserEdit(Model model, @ModelAttribute("gatherer") Gatherer gatherer,@ModelAttribute("wasteSearch") Waste wasteSearch) {		
		try {
			gathererService.update(gatherer);
			model.addAttribute("wasteSearch", wasteSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "redirect:/profile";
	}	
	@PostMapping("saveRecyclerEdit")	// POST: /recycler/saveRecyclerEdit
	public String saveUserEdit(Model model, @ModelAttribute("recycler") Recycler recycler,@ModelAttribute("wasteSearch") Waste wasteSearch) {		
		try {
			recyclerService.update(recycler);
			model.addAttribute("wasteSearch", wasteSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "redirect:/profile";
	}	
	
	
}
