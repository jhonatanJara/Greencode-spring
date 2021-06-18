package pe.edu.upc.Greencode.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Recyclers",
indexes = { @Index(columnList = "last_name, first_name", name = "recyclers_index_last_first_name"),
			@Index(columnList = "district_id", name="recyclers_index_district_id")},
uniqueConstraints = {@UniqueConstraint(columnNames = {"email", "dni", "recycler_user", "mobile_number"}) })

public class Recycler {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "recycler_id", nullable = false)
	private Integer id;
	
	@Column(name="recycler_user", nullable=false, length=30)
	private String recyclerUser;
	
	@Column(name="recycler_password", nullable=false, length=60)
	private String recyclerPassword;
	
	@Column(name="first_name", nullable=false, length=20)
	private String firstName;
	
	@Column(name="last_name", nullable=false, length=20)
	private String lastName;
	
	@Column(name="dni", nullable=false, length=8)
	private Integer dni;
	
	@Column(name="mobile_number", nullable=false, length = 9)
	private Integer mobileNumber;
	
	@Column(name="email", nullable=false, length=40)
	private String email;
	
	@Column(name="address", nullable=false, length=50)
	private String address;
	
	@Column(name="image", nullable=true)
	private String image;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="date_birth", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dateBirth;
	
	@Column(name="calification", nullable=false)
	private Integer calification;
	
	@Transient
	private Integer points;
	
	
	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@Column(name="points", nullable=false, columnDefinition = "DECIMAL(4,1)")
	private Float point;
	
	@Column(name="type", nullable=false, length=15) 
	private String type;
	
	@ManyToOne
	@JoinColumn(name="district_id", nullable = false)
	private District district;
	
	@OneToMany(mappedBy = "recycler", fetch = FetchType.LAZY)
	private List<Coupon> coupons;
	
	@OneToMany(mappedBy = "recycler", fetch = FetchType.LAZY)
	private List<Waste> wastes;
	
	@OneToMany(mappedBy = "recycler", fetch = FetchType.LAZY)
	private List<Order> orders;

	public Recycler() {
		super();
		coupons= new ArrayList<Coupon>();
		orders= new ArrayList<Order>();
		wastes= new ArrayList<Waste>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRecyclerUser() {
		return recyclerUser;
	}

	public void setRecyclerUser(String recyclerUser) {
		this.recyclerUser = recyclerUser;
	}

	public String getRecyclerPassword() {
		return recyclerPassword;
	}

	public void setRecyclerPassword(String recyclerPassword) {
		this.recyclerPassword = recyclerPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Integer getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public Integer getCalification() {
		return calification;
	}

	public void setCalification(Integer calification) {
		this.calification = calification;
	}

	public Float getPoint() {
		return point;
	}

	public void setPoint(Float point) {
		this.point = point;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public List<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}

	public List<Waste> getWastes() {
		return wastes;
	}

	public void setWastes(List<Waste> wastes) {
		this.wastes = wastes;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
