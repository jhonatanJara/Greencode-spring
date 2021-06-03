package pe.edu.upc.Greencode.service;

import java.util.List;

import pe.edu.upc.Greencode.model.entity.Coupon;

public interface CouponService extends CrudService<Coupon,Integer>{
	List<Coupon>findByNameCoupon (String nameCoupon) throws Exception;
}
