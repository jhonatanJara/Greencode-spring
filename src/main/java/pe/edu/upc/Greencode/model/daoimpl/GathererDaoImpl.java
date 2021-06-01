package pe.edu.upc.Greencode.model.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.Greencode.model.dao.IGathererDao;
import pe.edu.upc.Greencode.model.entity.Gatherer;

public class GathererDaoImpl implements IGathererDao,Serializable{

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "GreencodePU")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Gatherer gatherer) {
		em.persist(gatherer);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Gatherer> list() {
		List<Gatherer> list= new ArrayList<Gatherer>();
		Query q=em.createQuery("Select r from Gatherer r");
		list=(List<Gatherer>) q.getResultList();
		return list;
	}

	@Override
	public void delete(int idGatherer) {
		Gatherer r= new Gatherer();
		r= em.getReference(Gatherer.class, idGatherer);
		em.remove(r);
	}

}
