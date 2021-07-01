package pe.edu.upc.Greencode.business;

import java.util.List;

import pe.edu.upc.Greencode.model.entity.Order;
import pe.edu.upc.Greencode.model.entity.Waste;

public interface RequestRecyclersService {
	List<Order> ordersbystatus (int id) throws Exception;
	Order updateStatusOrder(int order) throws Exception;
}
