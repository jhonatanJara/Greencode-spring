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
import pe.edu.upc.Greencode.utils.Segmento;

@Service
public class InitDB implements CommandLineRunner{

	@Autowired
	private RecyclerRepository recyclerRepository;
	
	@Autowired
	private GathererRepository gathererRepository;
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		
		
		
		User recycler1 = new User();
		recycler1.setUsername("recycler1");
		recycler1.setPassword(bcpe.encode("recycler"));
		recycler1.setEnable(true);
		recycler1.setSegmento(Segmento.RECYCLER);
		recycler1.setIdSegmento(1);
		
		User gatherer1 = new User();
		gatherer1.setUsername("gatherer1");
		gatherer1.setPassword(bcpe.encode("gatherer"));
		gatherer1.setEnable(true);
		gatherer1.setSegmento(Segmento.GATHERER);
		gatherer1.setIdSegmento(1);
		
		//ROLE_RECYCLER, ROLE_GATHERER, ROLE_ADMIN
		recycler1.addAuthority("ROLE_RECYCLER");
		gatherer1.addAuthority("ROLE_GATHERER");
		
		//ACCESS
		
		//recycler1.addAuthority("ACCESS_DESC");
		
		userRepository.save(recycler1);
		userRepository.save(gatherer1);
		
		
		
		
		
		/*
		Optional <Gatherer> optional2 = gathererRepository.findById(1);
		if(optional2.isPresent()) {
			Gatherer jorge = optional2.get();
			User jorja = new User("jorja", bcpe.encode("jara"), jorge);
			//ROLE segmentos obejtivos
			jorja.addAuthority("ROLE_GATHERER");
			//ACCESS
			jorja.addAuthority("ACCESS_VIEW_REQUEST");
			userRepository.save(jorja);
		}
		*/
		
	}
	

}
