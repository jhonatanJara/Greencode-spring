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
@Table(name="Districts")
public class District {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "district_id", nullable = false)
	private Integer id;
	
	@Column(name="district_name", nullable=false, length=30)
	private String name;

	@OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
	private List<Recycler> recyclers;
	
	@OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
	private List<Gatherer> gatherers;
	
	public District() {
		super();
		gatherers= new ArrayList<Gatherer>();
		recyclers= new ArrayList<Recycler>();
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

	public List<Recycler> getRecyclers() {
		return recyclers;
	}

	public void setRecyclers(List<Recycler> recyclers) {
		this.recyclers = recyclers;
	}

	public List<Gatherer> getGatherers() {
		return gatherers;
	}

	public void setGatherers(List<Gatherer> gatherers) {
		this.gatherers = gatherers;
	}

	
	
}
