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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Gatherers",
indexes= {@Index(columnList="last_name,first_name",name = "gatherers_index_first_name"),
		@Index(columnList = "district_id", name="recyclers_index_district_id")},
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
	
	@Column(name="mobile_number", nullable=false, length = 9)
	private Integer mobileNumber;
	
	@Column(name="email", nullable=false, length=40)
	private String email;
	
	@Column(name="address", nullable=false, length=50)
	private String address;
	
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
	
	@OneToMany(mappedBy = "gatherer", fetch = FetchType.LAZY)
	private List<Account> accounts;
	
	@OneToMany(mappedBy = "gatherer", fetch = FetchType.LAZY)
	private List<GathererOrder> gathererOrders;

	public Gatherer() {
		super();
		accounts=new ArrayList<Account>();
		gathererOrders=new ArrayList<GathererOrder>();
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

	public List<GathererOrder> getGathererOrders() {
		return gathererOrders;
	}

	public void setGathererOrders(List<GathererOrder> gathererOrders) {
		this.gathererOrders = gathererOrders;
	}


	
}
