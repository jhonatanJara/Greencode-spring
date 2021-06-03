package pe.edu.upc.Greencode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Greencode.model.entity.Account;
import pe.edu.upc.Greencode.model.repository.AccountRepository;
import pe.edu.upc.Greencode.service.AccountService;

public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public JpaRepository<Account, Integer> getRepository() {
		return accountRepository;
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<Account> findByNameAccount (Integer numberAccount) throws Exception {
		return accountRepository.findByNameAccount(numberAccount);
	}
}
