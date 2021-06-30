package pe.edu.upc.Greencode.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Greencode.model.entity.User;
import pe.edu.upc.Greencode.model.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Optional<User> optional = this.userRepository.findByUsername(username);
			if (optional.isPresent()) {
				MyUserDetails myUserDetails = new MyUserDetails( optional.get() );
				return myUserDetails;
			}			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		throw new UsernameNotFoundException("The user is not found");	
	}
	
	
	
}