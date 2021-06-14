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
	
	@Column(name="weight", nullable=true, columnDefinition = "DECIMAL(4,2)")
	private Float weight;
	
	@Column(name="image", nullable=true)
	private String image;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "recycler_id", nullable = true)
	private Recycler recycler;

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Recycler getRecycler() {
		return recycler;
	}

	public void setRecycler(Recycler recycler) {
		this.recycler = recycler;
	}

	
	
	
	
}
