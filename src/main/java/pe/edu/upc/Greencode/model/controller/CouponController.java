package pe.edu.upc.Greencode.model.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import pe.edu.upc.Greencode.model.entity.Coupon;
import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.model.serviceimpl.ICouponServiceImpl;
import pe.edu.upc.Greencode.model.serviceimpl.IGathererServiceImpl;


//@Named
//@RequestScoped
public class CouponController implements Serializable{

	private static final long serialVersionUID = 1L;

	//@Inject
	private ICouponServiceImpl cService;
	//@Inject
	private IGathererServiceImpl reService;
	
	private Coupon coupon;
	private Recycler recycler;
	
	List<Coupon> listCoupons;
	List<Recycler> listRecyclers;
	
	@PostConstruct
	public void init() {
		recycler=new Recycler();
		coupon = new Coupon();
		listCoupons= new ArrayList<Coupon>();
		listRecyclers=new ArrayList<Recycler>();
		this.listCoupon();
		this.listRecycler();
	}
	
	public String newCoupon() {
		this.setCoupon(new Coupon());
		return "coupon.xhtml";
	}
	
	public void insert() {
		cService.insert(coupon);
		cleanCoupon();
		this.listCoupon();
	}
	
	public void listCoupon() {
		listCoupons=cService.list();
	}
	
	public void listRecycler() {
		//listRecyclers = reService.list(); //Jhonatan su Service
	}
	
	public void cleanCoupon() {
		this.init();
	}
	
	public void delete(Coupon coupon) {
		cService.delete(coupon.getId());
		this.listCoupon();
	}
	
	public List<Recycler> getListRecyclers(){
		return listRecyclers;
	}
	
	public void setlistRecyclers(List<Recycler> listRecyclers) {
		this.listRecyclers = listRecyclers;
	}
	
	
	public Coupon getCoupon() {
		return coupon;
	}
	
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public List<Coupon> getlistCoupons() {
		return listCoupons;
	}
	
	public void setlistCoupons(List<Coupon> listCoupons) {
		this.listCoupons = listCoupons;
	}
	
	public Recycler getRecycler() {
		return recycler;
	}
	
}
