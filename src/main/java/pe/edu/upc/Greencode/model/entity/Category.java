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
	private Integer id;
	
	@Column(name="name", nullable=false, length=10)
	private String name;
	
	@Column(name="price_kilo", nullable=false, columnDefinition = "DECIMAL(3,2)")
	private Float priceKilo;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Waste> wastes;
	
	public Category() {
		wastes= new ArrayList<Waste>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	
}
