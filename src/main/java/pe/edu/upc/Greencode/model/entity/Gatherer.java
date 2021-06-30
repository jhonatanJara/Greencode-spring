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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Gatherers",
indexes= {@Index(columnList="last_name,first_name",name = "gatherers_index_last_first_name"),
		@Index(columnList = "district_id", name="gatherers_index_district_id")},
uniqueConstraints = {@UniqueConstraint(columnNames = {"email", "dni", "gatherer_user", "mobile_number"}) })
public class Gatherer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "gatherer_id", nullable = false)
	private Integer id;
	
	@Column(name="gatherer_user", nullable=false, length=30)
	private String user;
	
	@Column(name="gatherer_password", nullable=false, length=60)
	private String password;
	
	@Column(name="first_name", nullable=false, length=20)
	private String firstName;
	
	@Column(name="last_name", nullable=false, length=20)
	private String lastName;
	
	@Column(name="dni", nullable=false, length=8)
	private Integer dni;
	
	@Column(name="image", nullable=true)
	private String image;
	
	@Column(name="mobile_number", nullable=false, length = 9)
	private Integer mobileNumber;
	
	@Column(name="email", nullable=false, length=40)
	private String email;
	
	@Column(name="address", nullable=false, length=50)
	private String address;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="date_birth", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dateBirth;
	
	@Column(name="calification", nullable=false, columnDefinition = "DECIMAL(3,1)")
	private Float calification;
	
	@Column(name="type", nullable=false, length=15) 
	private String type;
	
	@Column(name="profit", nullable=false, columnDefinition = "DECIMAL(4,1)")
	private Float profit;
	
	@ManyToOne
	@JoinColumn(name="district_id", nullable = false)
	private District district;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable = true)
	private User user1;
	
	@OneToMany(mappedBy = "gatherer", fetch = FetchType.LAZY)
	private List<Account> accounts;
	
	@OneToMany(mappedBy = "gatherer", fetch = FetchType.LAZY)
	private List<Order> orders;
	
	@Transient
	private Integer points;
	
	
	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	@Column(name="points", nullable=true, columnDefinition = "DECIMAL(4,1)")
	private Float point;

	public Gatherer() {
		super();
		accounts=new ArrayList<Account>();
		orders=new ArrayList<Order>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public Float getCalification() {
		return calification;
	}

	public void setCalification(Float calification) {
		this.calification = calification;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getProfit() {
		return profit;
	}

	public void setProfit(Float profit) {
		this.profit = profit;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	
	


	
}