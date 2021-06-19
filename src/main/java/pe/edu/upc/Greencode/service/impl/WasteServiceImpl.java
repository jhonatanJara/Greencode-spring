package pe.edu.upc.Greencode.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Greencode.model.entity.Waste;
import pe.edu.upc.Greencode.model.repository.WasteRepository;
import pe.edu.upc.Greencode.service.WasteService;

@Service
public class WasteServiceImpl implements WasteService {

	@Autowired
	private WasteRepository wasteRepository;
	
	@Override
	public JpaRepository<Waste, Integer> getRepository() {
		return wasteRepository;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Waste> findByName(String name) throws Exception {
		return wasteRepository.findByName(name);
	}

}
