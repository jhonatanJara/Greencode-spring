package pe.edu.upc.Greencode.service;

import java.util.List;

import pe.edu.upc.Greencode.model.entity.GathererOrder;
import pe.edu.upc.Greencode.model.entity.Gatherer;
import pe.edu.upc.Greencode.model.entity.Order;

public interface GathererOrderService extends CrudService<GathererOrder,Integer> {
	List<GathererOrder> findByAmountAndPrice(Integer amount,float price) throws Exception;
	List<GathererOrder> finByAmountStartingWithAndPriceStartingWith(Integer amount,float price) throws Exception;
	List<GathererOrder> findByGatherer(Gatherer gatherer) throws Exception;
	List<GathererOrder> findByOrder(Order order) throws Exception;
}


