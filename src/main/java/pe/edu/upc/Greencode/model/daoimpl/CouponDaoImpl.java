package pe.edu.upc.Greencode.model.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Greencode.model.dao.ICouponDao;
import pe.edu.upc.Greencode.model.entity.Coupon;

public class CouponDaoImpl implements ICouponDao,Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "GreencodePU")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Coupon coupon) {
		em.persist(coupon);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Coupon> list() {
		List<Coupon> list=new ArrayList<Coupon>();
		Query q=em.createQuery("Select from Coupon c");
		list=(List<Coupon>) q.getResultList();
		return list;
	}
	
	@Transactional
	@Override
	public void delete(int idCoupon) {
		Coupon c= new Coupon();
		c= em.getReference(Coupon.class, idCoupon);
		em.remove(c);
	}

}
