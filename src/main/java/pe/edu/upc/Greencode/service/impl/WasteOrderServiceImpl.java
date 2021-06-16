package pe.edu.upc.Greencode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.Greencode.model.entity.WasteOrder;
import pe.edu.upc.Greencode.model.repository.WasteOrderRepository;
import pe.edu.upc.Greencode.service.WasteOrderService;

@Service
public class WasteOrderServiceImpl implements WasteOrderService {

	@Autowired
	private WasteOrderRepository wasteOrderRepository;
	
	@Override
	public JpaRepository<WasteOrder, Integer> getRepository() {
		return wasteOrderRepository;
	}

}
