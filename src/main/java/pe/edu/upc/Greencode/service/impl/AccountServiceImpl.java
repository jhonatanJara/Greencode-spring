package pe.edu.upc.Greencode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.Greencode.model.entity.Account;
import pe.edu.upc.Greencode.model.repository.AccountRepository;
import pe.edu.upc.Greencode.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public JpaRepository<Account, Integer> getRepository() {
		return accountRepository;
	}
	
}
