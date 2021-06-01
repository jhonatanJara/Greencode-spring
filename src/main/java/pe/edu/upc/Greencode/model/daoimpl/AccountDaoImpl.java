package pe.edu.upc.Greencode.model.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Greencode.model.dao.IAccountDao;
import pe.edu.upc.Greencode.model.entity.Account;

public class AccountDaoImpl implements IAccountDao, Serializable {
private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "GreencodePU")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Account account) {
		em.persist(account);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> list() {
		List<Account> list=new ArrayList<Account>();
		Query q=em.createQuery("Select from Account c");
		list=(List<Account>) q.getResultList();
		return list;
	}
	
	@Transactional
	@Override
	public void delete(int idAccount) {
		Account c= new Account();
		c= em.getReference(Account.class, idAccount);
		em.remove(c);
	}

}

