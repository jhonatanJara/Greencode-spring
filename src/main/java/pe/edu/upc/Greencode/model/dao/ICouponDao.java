package pe.edu.upc.Greencode.model.dao;
import java.util.List;

import pe.edu.upc.Greencode.model.entity.Coupon;

public interface ICouponDao {
	public void insert(Coupon coupon);
	public List<Coupon> list();
	public void delete(int idCoupon);
}
