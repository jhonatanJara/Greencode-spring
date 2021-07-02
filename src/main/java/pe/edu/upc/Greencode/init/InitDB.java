package pe.edu.upc.Greencode.init;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.Greencode.model.entity.Gatherer;
import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.model.entity.User;
import pe.edu.upc.Greencode.model.repository.GathererRepository;
import pe.edu.upc.Greencode.model.repository.RecyclerRepository;
import pe.edu.upc.Greencode.model.repository.UserRepository;
import pe.edu.upc.Greencode.utils.Segment;

@Service
public class InitDB implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private GathererRepository gathererRepository;
	
	@Autowired
	private RecyclerRepository recyclerRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
	
		Optional<Recycler> optional = recyclerRepository.findById(1);
		if (optional.isPresent()) {

			Recycler user1 = optional.get();
			User user = new User();
			user.setUsername("sergio");
			user.setPassword(bcpe.encode("castañeda"));
			user.setEnable(true);
			user.setSegment(Segment.RECYCLER);
			user.setIdSegment(user1.getId());
			user1.setUser(user);
			user.addAuthority("ROLE_RECYCLER");
			userRepository.save(user);
		}
		
		Optional<Recycler> optional1 = recyclerRepository.findById(2);
		if(optional1.isPresent()) {
			
			Recycler user1 = optional1.get();
			User user = new User();
			user.setUsername("angela");
			user.setPassword(bcpe.encode("diaz"));
			user.setEnable(true);
			user.setSegment(Segment.RECYCLER);
			user.setIdSegment(user1.getId());
			user1.setUser(user);
			user.addAuthority("ROLE_RECYCLER");
			userRepository.save(user);
		}
		
		Optional <Gatherer> optional2 = gathererRepository.findById(1);
		if(optional2.isPresent()) {
			Gatherer jorge = optional2.get();
			
			User user = new User();
			user.setUsername("jorje");
			user.setPassword(bcpe.encode("jara"));
			user.setEnable(true);
			user.setSegment(Segment.GATHERER);
			user.setIdSegment(jorge.getId());
			jorge.setUser(user);
			
			user.addAuthority("ROLE_GATHERER");
			
			userRepository.save(user);
		}
		
		
		Optional <Gatherer> optional3 = gathererRepository.findById(2);
		if(optional3.isPresent()) {
			Gatherer jorge = optional3.get();
		
			User user = new User();
			user.setUsername("alexandra");
			user.setPassword(bcpe.encode("gutierrez"));
			user.setEnable(true);
			user.setSegment(Segment.GATHERER);
			user.setIdSegment(jorge.getId());
			jorge.setUser(user);
			
			user.addAuthority("ROLE_GATHERER");
			
			userRepository.save(user);
		}
	*/
	}
	

}
