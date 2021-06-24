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
		
		/*
		Optional <Recycler> optional = recyclerRepository.findById(1);
		if(optional.isPresent()) {
			Recycler sergio = optional.get();
			User sercas = new User("sercas", bcpe.encode("castaneda"), sergio);
			//ROLE segmentos obejtivos
			sercas.addAuthority("ROLE_RECYCLER");
			//ACCESS
			sercas.addAuthority("ACCESS_RECYCLE");
			userRepository.save(sercas);
		}
		*/
		
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
