package pe.edu.upc.Greencode.service;
import java.util.List;

import pe.edu.upc.Greencode.model.entity.Account;

public interface AccountService extends CrudService<Account,Integer> {
	List<Account> findByNameAccount (Integer numberAccount) throws Exception;
}

