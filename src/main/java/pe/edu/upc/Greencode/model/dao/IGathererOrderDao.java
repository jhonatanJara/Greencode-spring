package pe.edu.upc.Greencode.model.dao;

import java.util.List;

import pe.edu.upc.Greencode.model.entity.GathererOrder;

public interface IGathererOrderDao {
	public void insert(GathererOrder gathererOrder);
	public List<GathererOrder> list();
	public void delete(int idGathererOrder);
}
