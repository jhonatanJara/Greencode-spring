package pe.edu.upc.Greencode.service;

import java.util.List;

import pe.edu.upc.Greencode.model.entity.District;
import pe.edu.upc.Greencode.model.entity.Gatherer;

public interface GathererService extends CrudService<Gatherer,Integer>{
	List<Gatherer> findByLastNameAndFirstName(String lastName, String firstName) throws Exception;
	List<Gatherer> findByLastNameStartingWithAndFirstNameStartingWith(String lastName,String firstName) throws Exception;
	List<Gatherer> findByDisctrict(District district) throws Exception;
}
