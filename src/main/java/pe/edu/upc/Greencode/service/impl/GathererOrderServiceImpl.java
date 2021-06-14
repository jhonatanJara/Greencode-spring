package pe.edu.upc.Greencode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Greencode.model.entity.GathererOrder;
import pe.edu.upc.Greencode.model.entity.Order;
import pe.edu.upc.Greencode.model.entity.Gatherer;
import pe.edu.upc.Greencode.model.repository.GathererOrderRepository;
import pe.edu.upc.Greencode.service.GathererOrderService;

@Service
public class GathererOrderServiceImpl implements GathererOrderService{
	@Autowired
	private GathererOrderRepository gathererorderRepository;
		
	@Override
	public JpaRepository<GathererOrder, Integer> getRepository() {
			return gathererorderRepository;
	}
	

	@Transactional(readOnly=true)
	@Override
	public List<GathererOrder> findByGatherer(Gatherer gatherer) throws Exception {
		return gathererorderRepository.findByGatherer(gatherer);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<GathererOrder> findByOrder(Order order) throws Exception {
		return gathererorderRepository.findByOrder(order);
	}

}
