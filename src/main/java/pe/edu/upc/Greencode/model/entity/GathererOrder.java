package pe.edu.upc.Greencode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="GathererOrder")
public class GathererOrder {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "GathererOrder_id", nullable = false)
	private Integer id;

	@Column(name="amount", nullable=false)
	private Integer amount;

	@Column(name="price", nullable= true , columnDefinition = "DECIMAL(3,1)")
	private float price;

	@ManyToOne
	@JoinColumn(name="order_id", nullable = false)
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="gatherer_id", nullable = false)
	private Gatherer gatherer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Gatherer getGatherer() {
		return gatherer;
	}

	public void setGatherer(Gatherer gatherer) {
		this.gatherer = gatherer;
	}

	
	
}

