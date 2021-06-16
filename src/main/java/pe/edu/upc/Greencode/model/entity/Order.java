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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Orders")
public class Order {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "order_id", nullable = false)
	private Integer id;
	
	@Column(name="date", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="total_amount", nullable=true, columnDefinition = "DECIMAL(5,2)")
	private Float totalAmount;
	
	@Column(name="status", nullable = false, length = 20)
	private String status;

	@ManyToOne
	@JoinColumn(name="recycler_id", nullable = false)
	private Recycler recycler;

	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
	private List<WasteOrder> wasteOrders;
	
	@ManyToOne
	@JoinColumn(name="gatherer_id", nullable = false)
	private Gatherer gatherer;
	
	public Order() {
		super();
		wasteOrders= new ArrayList<WasteOrder>();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Recycler getRecycler() {
		return recycler;
	}

	public void setRecycler(Recycler recycler) {
		this.recycler = recycler;
	}

	public List<WasteOrder> getWasteOrders() {
		return wasteOrders;
	}

	public void setWasteOrders(List<WasteOrder> wasteOrders) {
		this.wasteOrders = wasteOrders;
	}

	public Gatherer getGatherer() {
		return gatherer;
	}

	public void setGatherer(Gatherer gatherer) {
		this.gatherer = gatherer;
	}

	
	
	
}
