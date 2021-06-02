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
@Table(name="Wastes")
public class Waste {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "waste_id", nullable = false)
	private Integer id;
	
	@Column(name="name", nullable=false, length=30)
	private String name;
	
	@Column(name="weight", nullable=true, columnDefinition = "DECIMAL(4,1)")
	private Float weight;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category categories;
	
	@ManyToOne
	@JoinColumn(name = "recycler_id", nullable = false)
	private Recycler recyclers;

	public Waste() {
		super();
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

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Category getCategories() {
		return categories;
	}

	public void setCategories(Category categories) {
		this.categories = categories;
	}

	public Recycler getRecyclers() {
		return recyclers;
	}

	public void setRecyclers(Recycler recyclers) {
		this.recyclers = recyclers;
	}

	
	
}
