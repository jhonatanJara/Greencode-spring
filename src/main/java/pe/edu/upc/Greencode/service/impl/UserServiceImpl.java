package pe.edu.upc.Greencode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.Greencode.model.entity.User;
import pe.edu.upc.Greencode.model.repository.UserRepository;
import pe.edu.upc.Greencode.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;
	

	@Override
	public User BuscarPorUsuario(String username) throws Exception {
		
		return repo.BuscarPorUsuario(username);
	}

}

