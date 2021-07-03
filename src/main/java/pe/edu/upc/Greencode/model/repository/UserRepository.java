package pe.edu.upc.Greencode.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Greencode.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	Optional <User> findByUsername(String username);
	User findByUsernameAndPassword(String username, String password);
	
	@Query("select u from User u where u.username=?1")
     User BuscarPorUsuario(String username);
}
