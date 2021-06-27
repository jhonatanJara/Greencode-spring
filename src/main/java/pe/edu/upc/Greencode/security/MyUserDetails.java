package pe.edu.upc.Greencode.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import pe.edu.upc.Greencode.model.entity.User;
import pe.edu.upc.Greencode.utils.Segmento;

public class MyUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private User user;
	public MyUserDetails(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		this.user.getAuthorities().forEach(authority -> {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
			grantedAuthorities.add(grantedAuthority);
		});
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.user.isEnable();
	}
	
	// Agregando nuevos get para obtener el cliente o proveedor vinculado a la cuenta
	
		public Segmento getSegmento() {
			return this.user.getSegmento();
		}
		public Integer getIdSegmento() {
			return this.user.getIdSegmento();
		}
	
	
	/*
	// Add new gets for get data from user or recycler
	public String getLastName() {
		return this.user.getRecycler().getLastName();
	}
	public String getFirstName() {
		return this.user.getRecycler().getFirstName();
	}
	*/
	
	

}