package pe.edu.upc.Greencode.business;

import java.util.List;

import pe.edu.upc.Greencode.model.entity.Order;
import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.model.entity.Waste;

public interface RequestRecyclersService {
	List<Order> ordersbystatus (int id) throws Exception;
	Order updateStatusOrderAccept(int order) throws Exception;
	void updatePointsRecycler (Order order) throws Exception;
	void updateStatusOrderDeny(int order) throws Exception;

}
