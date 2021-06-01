package pe.edu.upc.Greencode.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="GathererOrder")
public class GathererOrder {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "GathererOrder_id", nullable = false)
	private int id;

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

	public GathererOrder() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getamount() {
		return amount;
	}

	public void setamount(Integer amount) {
		this.amount = amount;
	}

	public float getprice() {
		return price;
	}

	public void setprice(float price) {
		this.price = price;
	}

	public Order getorder() {
		return order;
	}

	public void setorder (Order order) {
		this.order = order;
	}
	
	public Gatherer getgatherer() {
		return gatherer;
	}

	public void setRecycler(Gatherer gatherer) {
		this.gatherer = gatherer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		//result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + id;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((gatherer == null) ? 0 : gatherer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GathererOrder other = (GathererOrder) obj;
		if (amount == null) {
			if (other.amount!= null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (id != other.id)
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (gatherer == null) {
			if (other.gatherer != null)
				return false;
		} else if (!gatherer.equals(other.gatherer))
			return false;
		return true;
	}
}

