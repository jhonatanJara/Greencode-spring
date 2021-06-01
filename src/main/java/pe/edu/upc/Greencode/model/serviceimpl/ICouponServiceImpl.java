package pe.edu.upc.Greencode.model.serviceimpl;


import java.io.Serializable;
import java.util.List;

import pe.edu.upc.Greencode.model.dao.ICouponDao;
import pe.edu.upc.Greencode.model.entity.Coupon;
import pe.edu.upc.Greencode.model.service.ICouponService;


public class ICouponServiceImpl implements ICouponService, Serializable{

	private static final long serialVersionUID = 1L;
	
	//@Inject
	private ICouponDao cD;
	
	@Override
	public void insert(Coupon coupon) {
		cD.insert(coupon);
	}

	@Override
	public List<Coupon> list() {
		return cD.list();
	}

	@Override
	public void delete(int idCoupon) {
		cD.delete(idCoupon);
	}

}