package pe.edu.upc.Greencode.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Greencode.model.entity.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon,Integer>{
	List<Coupon> finByNameCoupon (String nameCoupon);
}
