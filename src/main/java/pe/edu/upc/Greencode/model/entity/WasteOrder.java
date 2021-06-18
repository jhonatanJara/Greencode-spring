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
@Table(name="WasteOrder")
public class WasteOrder {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "WasteOrder_id", nullable = false)
	private Integer id;


	@Column(name="price", nullable= true , columnDefinition = "DECIMAL(3,1)")
	private float price;
	

	@ManyToOne
	@JoinColumn(name="order_id", nullable = false)
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="waste_id", nullable = false)
	private Waste waste;

	
	
	public WasteOrder() {
		super();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Waste getWaste() {
		return waste;
	}

	public void setWaste(Waste waste) {
		this.waste = waste;
	}

	
	
	
}

