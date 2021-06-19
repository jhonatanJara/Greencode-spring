package pe.edu.upc.Greencode.service;

import java.util.List;

import pe.edu.upc.Greencode.model.entity.Waste;

public interface WasteService extends CrudService<Waste, Integer>{
	List<Waste> findByName(String name) throws Exception;
}
