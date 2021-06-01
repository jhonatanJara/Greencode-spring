package pe.edu.upc.Greencode.model.service;

import java.util.List;

import pe.edu.upc.Greencode.model.entity.Account;

public interface IAccountService {
	public void insert(Account account);
	public List<Account> list();
	public void delete(int idAccount);
}
