package pe.edu.upc.Greencode.controller;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
//nuevo
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.upc.Greencode.model.entity.Account;
import pe.edu.upc.Greencode.model.entity.Gatherer;
import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.model.entity.Transaction;
import pe.edu.upc.Greencode.model.entity.Waste;
import pe.edu.upc.Greencode.service.AccountService;
import pe.edu.upc.Greencode.service.GathererService;
import pe.edu.upc.Greencode.service.TransactionService;
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

	@GetMapping
	public String list(Model model, @ModelAttribute("wasteSearch") Waste wasteSearch) {
		try {
			
			//Account account = new Account();
			/*
			 
			 Optional<Gatherer> gatherer= gathererService.findById(1);//Jorge Jara
			List<Account> list=gatherer.get().getAccounts();
			
			for(int i=0; i<= list.size(); i++) {
				Date fecha = new Date();
				Transaction transaction= new Transaction();
				transaction.setDate(fecha);
				transaction.setName("Nose");
				transaction.setTypePayment("Linea");
				transaction.setTypeTransaction("Recharge");
				transactionService.create(transaction);
				transaction = null;
				fecha=null;
				
			  } 
			  */
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
			@ModelAttribute("wasteSearch") Waste wasteSearch) {
		try {
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
		return "redirect:/";
	}
}
