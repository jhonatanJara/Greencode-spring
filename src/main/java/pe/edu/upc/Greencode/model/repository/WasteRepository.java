package pe.edu.upc.Greencode.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Greencode.model.entity.Waste;

@Repository
public interface WasteRepository extends JpaRepository<Waste, Integer> {

	@Query("select r from Waste r where r.name like ?1% and r.image is not NULL")
	List<Waste> findByName(String name);
}
