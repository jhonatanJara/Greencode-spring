package pe.edu.upc.Greencode.model.service;

import java.util.List;

import pe.edu.upc.Greencode.model.entity.Gatherer;


public interface IGathererService {
	public void insert(Gatherer gatherer);
	public List<Gatherer> list();
	public void delete(int idGatherer);
}
