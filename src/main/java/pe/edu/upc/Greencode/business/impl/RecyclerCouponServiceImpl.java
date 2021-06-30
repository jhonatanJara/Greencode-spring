package pe.edu.upc.Greencode.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.Greencode.business.RecyclerCouponService;
import pe.edu.upc.Greencode.model.entity.Coupon;
import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.model.repository.CouponRepository;
import pe.edu.upc.Greencode.model.repository.RecyclerRepository;

@Service
public class RecyclerCouponServiceImpl implements RecyclerCouponService {

	@Autowired
	private RecyclerRepository recyclerRepository;
	
	@Autowired
	private CouponRepository couponRepository;
	
	@Override
	public List<Coupon> availableCoupons() throws Exception {

		List<Coupon> coupons = couponRepository.findAll();
		List<Coupon> newCoupons= new ArrayList<Coupon>();
		
		for(int i=0; i<coupons.size(); i++) {
			if(coupons.get(i).getRecycler() == null)
				newCoupons.add(coupons.get(i));
			}

		return newCoupons;
	}

	@Transactional
	@Override
	public void successfulCoupon(Recycler recycler, Coupon coupon) throws Exception {
		
		coupon.setRecycler(recycler);
		recycler.setPoint(recycler.getPoint()-coupon.getScore());
		
		recyclerRepository.save(recycler);
		couponRepository.save(coupon);
		
	}
}
