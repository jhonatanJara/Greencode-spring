package pe.edu.upc.Greencode.model.dao;
import java.util.List;

import pe.edu.upc.Greencode.model.entity.Account;

public interface IAccountDao {
	public void insert(Account account);
	public List<Account> list();
	public void delete(int idAccount);
}
