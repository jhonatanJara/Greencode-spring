package pe.edu.upc.Greencode.business;

import java.util.List;

import pe.edu.upc.Greencode.model.entity.Coupon;
import pe.edu.upc.Greencode.model.entity.Recycler;

public interface RecyclerCouponService {

	List<Coupon> availableCoupons() throws Exception;
	
	void successfulCoupon(Recycler recycler, Coupon coupon) throws Exception;
}
