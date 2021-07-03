package pe.edu.upc.Greencode.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.Greencode.business.RequestRecyclersService;
import pe.edu.upc.Greencode.model.entity.Gatherer;
import pe.edu.upc.Greencode.model.entity.Order;
import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.model.entity.Waste;
import pe.edu.upc.Greencode.model.repository.GathererRepository;
import pe.edu.upc.Greencode.model.repository.OrderRepository;
import pe.edu.upc.Greencode.model.repository.RecyclerRepository;

@Service
public class RequestRecyclersServiceImpl implements RequestRecyclersService{
	
	@Autowired
	private GathererRepository gathererRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private RecyclerRepository recyclerRepository;
	
	@Override
	public List<Order> ordersbystatus(int id) throws Exception {
		
		Optional<Gatherer> gatherer= gathererRepository.findById(1);
		List<Order> order= gatherer.get().getOrders();
		List<Order> order1=new ArrayList<Order>();
		for(int i=0; i< order.size(); i++) {
			String x="In progress";
			System.out.println(order.get(i).getStatus());
			if(x.equals(order.get(i).getStatus())) {
				System.out.println("In progress");
				order1.add(order.get(i));
			}
		}
		return order1;
	}

	@Transactional
	@Override
	public Order updateStatusOrderAccept(int order) throws Exception {
		Optional<Order> optional = orderRepository.findById(order);
		
		if(optional.isPresent()) {
			optional.get().setStatus("Completed");
			orderRepository.save(optional.get());
		}
		return optional.get();
	}

	
	
	@Transactional
	@Override
	public void  updatePointsRecycler(Order order) throws Exception {
		Recycler recycler=recyclerRepository.getById(order.getRecycler().getId());
		recycler.setPoint(recycler.getPoint()+ order.getTotalAmount()/10);
		recyclerRepository.save(recycler);
	}

	@Transactional
	@Override
	public void updateStatusOrderDeny(int order) throws Exception {
		Optional<Order> optional = orderRepository.findById(order);
		if(optional.isPresent()) {
			optional.get().setStatus("Denied");
			orderRepository.save(optional.get());
		}
	}
	
}
