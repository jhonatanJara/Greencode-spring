package pe.edu.upc.Greencode.business;

import java.util.List;

import pe.edu.upc.Greencode.model.entity.Order;

public interface HistoryPurchaseService {
	List<Order> ordersbystatus(int id) throws Exception;
}
