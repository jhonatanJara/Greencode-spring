package pe.edu.upc.Greencode.init;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upc.Greencode.model.entity.User;
import pe.edu.upc.Greencode.model.repository.UserRepository;
import pe.edu.upc.Greencode.utils.Segment;

@Service
public class InitDB implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
	/*
		User gatherer1 = new User();
		gatherer1.setUsername("gatherer1");
		gatherer1.setPassword(bcpe.encode("gatherer"));
		gatherer1.setEnable(true);
		gatherer1.setSegment(Segment.GATHERER);
		gatherer1.setIdSegment(1);
		
		User gatherer2 = new User();
		gatherer2.setUsername("gatherer2");
		gatherer2.setPassword(bcpe.encode("gatherer"));
		gatherer2.setEnable(true);
		gatherer2.setSegment(Segment.GATHERER);
		gatherer2.setIdSegment(2);
		
		User gatherer3 = new User();
		gatherer3.setUsername("gatherer3");
		gatherer3.setPassword(bcpe.encode("gatherer"));
		gatherer3.setEnable(true);
		gatherer3.setSegment(Segment.GATHERER);
		gatherer3.setIdSegment(3);
		
		User recycler1 = new User();
		recycler1.setUsername("recycler1");
		recycler1.setPassword(bcpe.encode("recycler"));
		recycler1.setEnable(true);
		recycler1.setSegment(Segment.RECYCLER);
		recycler1.setIdSegment(1);
		
		User recycler2 = new User();
		recycler2.setUsername("recycler2");
		recycler2.setPassword(bcpe.encode("recycler"));
		recycler2.setEnable(true);
		recycler2.setSegment(Segment.RECYCLER);
		recycler2.setIdSegment(2);
		
		
		// ROLE_CUSTOMER, ROLE_PROVIDER, ROLE_ADMIN
		
		gatherer1.addAuthority("ROLE_GATHERER");
		gatherer2.addAuthority("ROLE_GATHERER");
		gatherer3.addAuthority("ROLE_GATHERER");
		
		recycler1.addAuthority("ROLE_RECYCLER");
		recycler2.addAuthority("ROLE_RECYCLER");

		
		
		userRepository.save(gatherer1);
		userRepository.save(gatherer2);
		userRepository.save(gatherer3);
		
		userRepository.save(recycler1);
		userRepository.save(recycler2);
*/
	
		
		/*Optional <Recycler> optional = recyclerRepository.findById(1);
		if(optional.isPresent()) {
			Recycler sergio = optional.get();
			//User sercas = new User("sercas", bcpe.encode("castaneda"), sergio);
			User user = new User();
			user.setId(sergio.getId());
			user.setUsername("sercas");
			user.setPassword(bcpe.encode("castaneda"));
			user.setEnable(true);
			//user.setAuthorities(null);
			sergio.setUser(user);
			
			//ROLE segmentos obejtivos
			user.addAuthority("ROLE_RECYCLER");
			//ACCESS
			user.addAuthority("ACCESS_RECYCLE");
			userRepository.save(user);
		}
		
		
		Optional <Gatherer> optional2 = gathererRepository.findById(2);
		if(optional2.isPresent()) {
			Gatherer jorge = optional2.get();
			System.out.println(jorge);
			//User jorja = new User("jorja", bcpe.encode("jara"), jorge);
			User user = new User();
			user.setId(jorge.getId());
			user.setUsername("jorje");
			user.setPassword(bcpe.encode("jara"));
			user.setEnable(true);
			//user.setAuthorities(null);
			jorge.setUser1(user);
			
		
			
			//ROLE segmentos obejtivos
			user.addAuthority("ROLE_GATHERER");
			//ACCESS
			user.addAuthority("ACCESS_VIEW_REQUEST");
			userRepository.save(user);
		}
		*/
		
	}
	

}
