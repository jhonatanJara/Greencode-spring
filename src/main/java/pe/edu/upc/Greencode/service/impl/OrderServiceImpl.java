package pe.edu.upc.Greencode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.Greencode.model.entity.Order;
import pe.edu.upc.Greencode.model.repository.OrderRepository;
import pe.edu.upc.Greencode.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public JpaRepository<Order, Integer> getRepository() {		
		return orderRepository;
	}

}
