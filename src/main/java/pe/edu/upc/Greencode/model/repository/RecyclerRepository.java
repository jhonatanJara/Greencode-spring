package pe.edu.upc.Greencode.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Greencode.model.entity.District;
import pe.edu.upc.Greencode.model.entity.Recycler;

@Repository
public interface RecyclerRepository extends JpaRepository<Recycler, Integer>{	
	List<Recycler> findByLastNameAndFirstName(String lastName, String firstName);
	
	@Query("select r from Recycler r where r.lastName like ?1% and r.firstName like ?2%")
	List<Recycler> findByLastNameStartingWithAndFirstNameStartingWith(String lastName, String firstName);
	
	List<Recycler> findByDistrict(District district);
}
