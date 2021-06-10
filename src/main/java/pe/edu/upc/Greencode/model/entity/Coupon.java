package pe.edu.upc.Greencode.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Coupons", indexes= {@Index(columnList="name_coupon", name="coupons_index_name_coupon")})

public class Coupon {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "coupon_id", nullable = false)
	private Integer id;
	
	@Column(name="name_coupon", nullable=false, length=50)
	private String nameCoupon;
	
	@Column(name="date_expiration", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date dateExpiration;
	
	@Column(name="code", nullable=false, length=10)
	private String code;
	
	@Column(name="score", nullable=false)
	private Integer score;
	
	@ManyToOne
	@JoinColumn(name="recycler_id", nullable = true)
	private Recycler recycler;

	public Coupon() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameCoupon() {
		return nameCoupon;
	}

	public void setNameCoupon(String nameCoupon) {
		this.nameCoupon = nameCoupon;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Recycler getRecycler() {
		return recycler;
	}

	public void setRecycler(Recycler recycler) {
		this.recycler = recycler;
	}
}
