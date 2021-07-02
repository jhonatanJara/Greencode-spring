package pe.edu.upc.Greencode.service;

import java.util.List;

import pe.edu.upc.Greencode.model.entity.Gatherer;
import pe.edu.upc.Greencode.model.entity.User;

public interface UserService {
	
	User BuscarPorUsuario(String username) throws Exception;
}
