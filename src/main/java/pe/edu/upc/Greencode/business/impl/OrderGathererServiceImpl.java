package pe.edu.upc.Greencode.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.Greencode.business.OrderGathererService;
import pe.edu.upc.Greencode.model.entity.Gatherer;
import pe.edu.upc.Greencode.model.entity.Order;
import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.model.entity.Waste;
import pe.edu.upc.Greencode.model.entity.WasteOrder;
import pe.edu.upc.Greencode.model.repository.GathererRepository;
import pe.edu.upc.Greencode.model.repository.OrderRepository;
import pe.edu.upc.Greencode.model.repository.RecyclerRepository;
import pe.edu.upc.Greencode.model.repository.WasteOrderRepository;
import pe.edu.upc.Greencode.model.repository.WasteRepository;

@Service
public class OrderGathererServiceImpl implements OrderGathererService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private WasteOrderRepository wasteOrderRepository;
	
	@Autowired
	private RecyclerRepository  recyclerRepository;
	
	@Autowired
	private GathererRepository gathererRepository;
	
	@Autowired
	private WasteRepository wasteRepository;
	
	@Transactional
	@Override
	public Order newOrderGatherer(int recycler, int gatherer) throws Exception {

		Optional<Recycler> recyclerr= recyclerRepository.findById(recycler);
		Optional<Gatherer> gathererr= gathererRepository.findById(gatherer);
		Order order= new Order();
		
		if(recyclerr.isPresent() && gathererr.isPresent()) {
			order.setDate(new Date());
			order.setStatus("In progress");
			order.setRecycler(recyclerr.get());
			order.setGatherer(gathererr.get());
			
			orderRepository.save(order);
		}
		return order;
	}

	@Transactional
	@Override
	public void detailsOrderGatherer(Waste wastes, Order order) throws Exception {
		
		WasteOrder wasteOrder = new WasteOrder();
		wasteOrder.setOrder(order);
		wasteOrder.setWaste(wastes);
		wasteOrder.setPrice(wastes.getCategory().getPriceKilo());

		wasteOrderRepository.save(wasteOrder);	
	}

	@Transactional
	@Override
	public List<Gatherer> bestGatherers() throws Exception {
		List<Gatherer> gatherers = gathererRepository.findAll();			
		List<Gatherer> newList = new ArrayList<Gatherer>();
		
		for(int i=0; i< gatherers.size(); i++) {
			if(gatherers.get(i).getCalification()>=8 && gatherers.get(i).getCalification()<=10 ) {
				newList.add(gatherers.get(i));
			}
		}		
		return newList;
	}

	@Transactional
	@Override
	public List<Gatherer> gatherersByDistrict(int idRecycler) throws Exception {
		Optional<Recycler> recycler= recyclerRepository.findById(idRecycler);
		
		List<Gatherer> gatherers = gathererRepository.findAll();			
		List<Gatherer> newList = new ArrayList<Gatherer>();
		
		for(int i=0; i< gatherers.size(); i++) {
			if(recycler.get().getDistrict() == gatherers.get(i).getDistrict()) {
				newList.add(gatherers.get(i));
			}
		}		
		return newList;
	}

	@Transactional
	@Override
	public Waste addWaste(int idWaste) throws Exception {
		Optional<Waste> optional = wasteRepository.findById(idWaste);
		Waste w= new Waste();
		
		if(optional.isPresent()) {
			w.setName(optional.get().getName());
			w.setCategory(optional.get().getCategory());
			w.setImage(optional.get().getImage());
			w.setAvailable(false);
			wasteRepository.save(w);
		}
		return w;
	}

}
