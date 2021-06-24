package pe.edu.upc.Greencode.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users", indexes = {@Index(columnList = "username", name = "user_index_username")})
public class User {
	// EmbeddedId primary key
	@Id
	private Integer id;
	
	@Column(name = "username", length = 30, nullable = false)
	private String username;
	
	@Column(name = "password", length = 60, nullable = false)
	private String password;
	
	@Column(name = "enable")
	private boolean enable;
	
	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "id")
	private Recycler recycler;
	
	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "id")
	private Gatherer gatherer;
	
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Authority> authorities;
	
	public User() {
		this.enable = true;
		this.authorities = new ArrayList<>();
	}
	public User( String username, String password ) {
		this.username = username;
		this.password = password;
		this.enable = true;
		this.authorities = new ArrayList<>();
	}
	
	public List<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
	//RECYCLER
	public User( String username, String password, Recycler recycler ) {
		this.id = recycler.getId();
		this.username = username;
		this.password = password;
		this.enable = true;
		this.recycler = recycler;		
		this.authorities = new ArrayList<>();
		recycler.setUser(this);
	}
	
	//GATHERER
	public User( String username, String password, Gatherer gatherer ) {
		this.id = gatherer.getId();
		this.username = username;
		this.password = password;
		this.enable = true;
		this.gatherer = gatherer;		
		this.authorities = new ArrayList<>();
		gatherer.setUser1(this);
	}
	
	// Add ROLE or ACCESS to user
	public void addAuthority( String auth ) {
		Authority authority = new Authority();
		authority.setAuthority( auth ) ;
		authority.setUser( this );
		
		this.authorities.add( authority );
	}

	public Gatherer getGatherer() {
		return gatherer;
	}
	public void setGatherer(Gatherer gatherer) {
		this.gatherer = gatherer;
	}
	public Recycler getRecycler() {
		return recycler;
	}
	public void setRecycler(Recycler recycler) {
		this.recycler = recycler;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	
	
}