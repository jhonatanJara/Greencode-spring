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
	
	@Column(name="name", nullable=false, length=30)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		District other = (District) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
}
