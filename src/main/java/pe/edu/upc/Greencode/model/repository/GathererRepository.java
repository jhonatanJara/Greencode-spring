package pe.edu.upc.Greencode.model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Greencode.model.entity.District;
import pe.edu.upc.Greencode.model.entity.Gatherer;

@Repository
public interface GathererRepository extends JpaRepository<Gatherer,Integer>{
	List<Gatherer> findByLastNameAndFirstName(String lastName,String firstName);
	
	@Query("select g from Gatherer g where g.lastName like ?1% and g.firstName like ?2%")
	List<Gatherer> finByLastNameStartingWithAndFirstNameStartingWith(String lastName,String firstName);
	
	List<Gatherer> findByDistrict(District disctrict);
	
}
