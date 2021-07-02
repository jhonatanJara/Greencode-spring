package pe.edu.upc.Greencode.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.Greencode.business.HistoryPurchaseService;
import pe.edu.upc.Greencode.model.entity.Gatherer;
import pe.edu.upc.Greencode.model.entity.Order;
import pe.edu.upc.Greencode.model.repository.GathererRepository;

@Service
public class HistoryPurchaseServiceImpl implements HistoryPurchaseService {
	
	@Autowired
	private GathererRepository gathererRepository;

	@Override
	public List<Order> ordersbystatus(int id) throws Exception {
		
		Optional<Gatherer> gatherer= gathererRepository.findById(1);
		List<Order> order= gatherer.get().getOrders();
		List<Order> ordersCompleted=new ArrayList<Order>();
		for(int i=0; i< order.size(); i++) {
			String x="Completed";
			if(x.equals(order.get(i).getStatus())) {
				ordersCompleted.add(order.get(i));
			}
		}
		return ordersCompleted;
	}

}
