package pe.edu.upc.Greencode.model.service;

import java.util.List;

import pe.edu.upc.Greencode.model.entity.Coupon;

public interface ICouponService {
	public void insert(Coupon coupon);
	public List<Coupon> list();
	public void delete(int idCoupon);
}
