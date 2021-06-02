package pe.edu.upc.Greencode.service;

import java.util.List;

import pe.edu.upc.Greencode.model.entity.District;
import pe.edu.upc.Greencode.model.entity.Recycler;

public interface RecyclerService extends CrudService<Recycler, Integer>{
	
	List<Recycler> findByLastNameAndFirstName(String lastName, String firstName) throws Exception;
	List<Recycler> findByLastNameStartingWithAndFirstNameStartingWith(String lastName, String firstName) throws Exception;
	List<Recycler> findByDistrict(District district) throws Exception;
}
