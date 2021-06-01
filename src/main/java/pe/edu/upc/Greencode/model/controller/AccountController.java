package pe.edu.upc.Greencode.model.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import pe.edu.upc.Greencode.model.entity.Account;
import pe.edu.upc.Greencode.model.entity.Gatherer;
import pe.edu.upc.Greencode.model.serviceimpl.IAccountServiceImpl;
import pe.edu.upc.Greencode.model.serviceimpl.IGathererServiceImpl;


//@Named
//@RequestScoped
public class AccountController implements Serializable{

	private static final long serialVersionUID = 1L;

	//@Inject
	private IAccountServiceImpl cService;
	//@Inject
	private IGathererServiceImpl reService;
	
	private Account account;
	private Gatherer gatherer;
	
	List<Account> listAccount;
	List<Gatherer> listGatherer;
	
	@PostConstruct
	public void init() {
		gatherer=new Gatherer();
		account = new Account();
		listAccount= new ArrayList<Account>();
		listGatherer=new ArrayList<Gatherer>();
		this.listAccount();
		this.listGatherer();
	}
	
	public String newAccount() {
		this.setAccount(new Account());
		return "account.xhtml";
	}
	
	public void insert() {
		cService.insert(account);
		cleanAccount();
		this.listAccount();
	}
	
	public void listAccount() {
		listAccount=cService.list();
	}
	
	public void listGatherer() {
		listGatherer= reService.list(); 
	}
	
	public void cleanAccount() {
		this.init();
	}
	
	public void delete(Account account) {
		cService.delete(account.getId());
		this.listAccount();
	}
	
	public List<Gatherer> getListGatherer(){
		return listGatherer;
	}
	
	public void setlistGatherer(List<Gatherer> listGatherer) {
		this.listGatherer = listGatherer;
	}
	
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account Account) {
		this.account = Account;
	}

	public List<Account> getlistAccount() {
		return listAccount;
	}
	
	public void setlistAccount(List<Account> listAccount) {
		this.listAccount = listAccount;
	}
	
	public Gatherer getGatherer() {
		return gatherer;
	}
	
}
