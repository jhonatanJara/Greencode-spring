package pe.edu.upc.Greencode.controller;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.Greencode.model.entity.Account;
import pe.edu.upc.Greencode.model.entity.Gatherer;
import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.model.entity.Transaction;
import pe.edu.upc.Greencode.model.entity.User;
import pe.edu.upc.Greencode.model.entity.Waste;
import pe.edu.upc.Greencode.security.MyUserDetails;
import pe.edu.upc.Greencode.security.MyUserDetailsService;
import pe.edu.upc.Greencode.service.AccountService;
import pe.edu.upc.Greencode.service.GathererService;
import pe.edu.upc.Greencode.service.TransactionService;
import pe.edu.upc.Greencode.service.UserService;
import pe.edu.upc.Greencode.service.WasteService;

@Controller
@RequestMapping("/recharge")
public class RechargeController {
	
	@Autowired
	private  GathererService  gathererService;
	@Autowired
	private  TransactionService  transactionService;
	
	@Autowired
	private WasteService wasteService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService;
	

	@GetMapping
	public String list(Model model, @ModelAttribute("wasteSearch") Waste wasteSearch) {
		try {
			
			 model.addAttribute("transaction", new Transaction());
			 model.addAttribute("wasteSearch", wasteSearch);
			 
			 return "recharge/rechargeAccount";
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "request/list";
	}
	

	@PostMapping("/save")
	public String saveQualifyRecycler(Model model, @ModelAttribute("transaction") Transaction transaction,
			@ModelAttribute("wasteSearch") Waste wasteSearch ) {
		try {
	
			
				int idAccountLogeado = 1;
				Optional<Account> account = accountService.findById(idAccountLogeado);
				//User user = new User();
				
				if(account.isPresent()) {
					transaction.setAccount(account.get());
					transaction.setDate(new Date());
			     	transaction.setTypePayment("Online");
			     	transaction.setTypeTransaction("Recharge");
			     	transaction.setName("");
			     	
					transactionService.create(transaction);
					System.out.println(transaction.toString());
				}
				model.addAttribute("user", new User());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "Recharge/rechargeConfirmation";
	}
	
	public String UsuarioLogeado() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        String username = userDetail.getUsername().trim();
        //  String perfil = userDetail.getAuthorities().toString();
        return username;
    }


	@PostMapping("/history")
	public String saveHistory(Model model, @ModelAttribute("transaction") Transaction transaction,
			@ModelAttribute("wasteSearch") Waste wasteSearch , @ModelAttribute("user") User user , RedirectAttributes attributes ) {
		try {
			PasswordEncoder  encoder = new BCryptPasswordEncoder();
			User userBus = userService.BuscarPorUsuario(UsuarioLogeado().trim());
			
			
			
			System.out.println("data user : "+userBus.toString());
			System.out.println("Ckave : "+user.getPassword());
			
			boolean valida = false;
			if (userBus != null) {
	            if (encoder.matches(user.getPassword() , userBus.getPassword())) {
	            	System.out.println("soy igual");
	            	valida = true;
	            } 
	        }

		System.out.println("Accion : "+valida);
				if(valida == false) {
					attributes.addFlashAttribute("error", "Contraseña incorrecta");
					//return "Recharge/rechargeConfirmation";
				}
				
	
			/*
			
			
			  */
			
			// OBtener usuarioLogeado
			//System.out.println("User :"+userService);
			System.out.println("User :"+UsuarioLogeado());
			System.out.println("Contraseña  :"+user.getPassword());
			
			
			
				int idAccountLogeado = 1;
				Optional<Account> account = accountService.findById(idAccountLogeado);
				
				if(account.isPresent()) {
					transaction.setAccount(account.get());
					transaction.setDate(new Date());
			     	transaction.setTypePayment("Online");
			     	transaction.setTypeTransaction("Recharge");
			     	transaction.setName("");
					transactionService.create(transaction);
					System.out.println(transaction.toString());
				}

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "history/viewRecharge";
	}

}
