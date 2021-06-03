package pe.edu.upc.Greencode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.Greencode.model.entity.Transaction;
import pe.edu.upc.Greencode.model.repository.TransactionRepository;
import pe.edu.upc.Greencode.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public JpaRepository<Transaction, Integer> getRepository(){
		return transactionRepository;
	}

}
