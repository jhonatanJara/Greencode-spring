package pe.edu.upc.Greencode.business;

import java.util.List;

import pe.edu.upc.Greencode.model.entity.Gatherer;
import pe.edu.upc.Greencode.model.entity.Order;
import pe.edu.upc.Greencode.model.entity.Waste;

public interface OrderGathererService {
	
	Order newOrderGatherer(int recycler, int gatherer) throws  Exception;
	
	void detailsOrderGatherer(Waste wastes, Order order) throws  Exception;
	
	List<Gatherer> bestGatherers() throws Exception;
	
	List<Gatherer> gatherersByDistrict(int idRecycler) throws Exception;
	
	Waste addWaste(int idWaste) throws Exception;

}
