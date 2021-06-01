package pe.edu.upc.Greencode.model.dao;

import java.util.List;

import pe.edu.upc.Greencode.model.entity.Gatherer;

public interface IGathererDao {
	public void insert(Gatherer gatherer);
	public List<Gatherer> list();
	public void delete(int idGatherer);
}
