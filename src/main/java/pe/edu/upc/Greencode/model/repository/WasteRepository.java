package pe.edu.upc.Greencode.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Greencode.model.entity.Waste;

@Repository
public interface WasteRepository extends JpaRepository<Waste, Integer> {

}
