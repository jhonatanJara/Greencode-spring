package pe.edu.upc.Greencode.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.Greencode.business.RecyclerCouponService;
import pe.edu.upc.Greencode.model.entity.Coupon;
import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.model.entity.Waste;
import pe.edu.upc.Greencode.service.CouponService;
import pe.edu.upc.Greencode.service.RecyclerService;

@Controller
@RequestMapping("/rewards")
public class RewardController {

	@Autowired
	private RecyclerCouponService recyclerCouponService;
	
	@Autowired
	private CouponService couponService;
	
	@Autowired
	private RecyclerService recyclerService;
	
	@GetMapping	
	public String list(Model model, @ModelAttribute("wasteSearch") Waste wasteSearch) {
		try {
			Optional<Recycler> recycler= recyclerService.findById(1);
			List<Coupon> recyclerCoupons = recycler.get().getCoupons();
			
			if(recycler.isPresent()) {
				
				List<Coupon> availableCoupons = recyclerCouponService.availableCoupons();
					
				model.addAttribute("recyclerCoupons", recyclerCoupons);
				model.addAttribute("coupons", availableCoupons);
				model.addAttribute("recycler", recycler.get());
				model.addAttribute("wasteSearch", wasteSearch);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "coupons/list";
	}
	
	
	@GetMapping("{id}/view")
	public String findById(Model model, @PathVariable("id") Integer id, @ModelAttribute("wasteSearch") Waste wasteSearch) {
		try {
			Optional<Coupon> optional = couponService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("coupon", optional.get());
				model.addAttribute("wasteSearch", wasteSearch);
				return "coupons/view";
			}	
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/rewards";
	}
	
	
	@GetMapping("{id}/swap")
	public String swapPoints(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Recycler> recycler= recyclerService.findById(1);
			Optional<Coupon> coupon = couponService.findById(id);
			
			if(coupon.isPresent() && coupon.get().getScore() <= recycler.get().getPoint()) {
		
				recyclerCouponService.successfulCoupon(recycler.get(), coupon.get());
				return "redirect:/rewards";
				
			}else {
				return "redirect:/rewards/{id}/view";
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "";
	}
		
}
