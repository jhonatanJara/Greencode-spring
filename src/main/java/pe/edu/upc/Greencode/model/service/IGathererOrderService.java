package pe.edu.upc.Greencode.model.service;

import java.util.List;

import pe.edu.upc.Greencode.model.entity.GathererOrder;

public interface IGathererOrderService {
	public void insert(GathererOrder gathererOrder);
	public List<GathererOrder> list();
	public void delete(int idGathererOrder);
}
