package pe.edu.upc.Greencode.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Categories")
public class Category {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "category_id", nullable = false)
	private int id;
	
	@Column(name="name", nullable=false, length=10)
	private String name;
	
	@Column(name="price_kilo", nullable=false, columnDefinition = "DECIMAL(3,2)")
	private Float priceKilo;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Waste> wastes;
	
	public Category() {
		wastes= new ArrayList<Waste>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPriceKilo() {
		return priceKilo;
	}

	public void setPriceKilo(Float priceKilo) {
		this.priceKilo = priceKilo;
	}

	public List<Waste> getWastes() {
		return wastes;
	}

	public void setWastes(List<Waste> wastes) {
		this.wastes = wastes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((priceKilo == null) ? 0 : priceKilo.hashCode());
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
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (priceKilo == null) {
			if (other.priceKilo != null)
				return false;
		} else if (!priceKilo.equals(other.priceKilo))
			return false;
		return true;
	}
	
	
}
