package pe.edu.upc.Greencode.model.serviceimpl;

import java.io.Serializable;
import java.util.List;

import pe.edu.upc.Greencode.model.dao.IAccountDao;
import pe.edu.upc.Greencode.model.entity.Account;
import pe.edu.upc.Greencode.model.service.IAccountService;


public class IAccountServiceImpl implements IAccountService, Serializable{
private static final long serialVersionUID = 1L;
	
	//@Inject
	private IAccountDao cD;
	
	@Override
	public void insert(Account account) {
		cD.insert(account);
	}

	@Override
	public List<Account> list() {
		return cD.list();
	}

	@Override
	public void delete(int idAccount) {
		cD.delete(idAccount);
	}

}
