package pe.edu.upc.Greencode.model.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Greencode.model.dao.IGathererOrderDao;
import pe.edu.upc.Greencode.model.entity.GathererOrder;

public class GathererOrderDaoImpl implements IGathererOrderDao, Serializable {
private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "GreencodePU")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(GathererOrder gathererOrder) {
		em.persist(gathererOrder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GathererOrder> list() {
		List<GathererOrder> list=new ArrayList<GathererOrder>();
		Query q=em.createQuery("Select from GathererOrder c");
		list=(List<GathererOrder>) q.getResultList();
		return list;
	}
	
	@Transactional
	@Override
	public void delete(int idGathererOrder) {
		GathererOrder c= new GathererOrder();
		c= em.getReference(GathererOrder.class, idGathererOrder);
		em.remove(c);
	}

}
