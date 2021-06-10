package pe.edu.upc.Greencode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Greencode.model.entity.Coupon;
import pe.edu.upc.Greencode.model.repository.CouponRepository;
import pe.edu.upc.Greencode.service.CouponService;

@Service
public class CouponServiceImpl implements CouponService{

	@Autowired
	private CouponRepository couponRepository;
	
	@Override
	public JpaRepository<Coupon, Integer> getRepository() {
		return couponRepository;
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<Coupon> findByNameCoupon(String nameCoupon) throws Exception {
		return couponRepository.findByNameCoupon(nameCoupon);
	}

}
