package pe.edu.upc.Greencode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Greencode.model.entity.District;
import pe.edu.upc.Greencode.model.entity.Gatherer;
import pe.edu.upc.Greencode.model.repository.GathererRepository;
import pe.edu.upc.Greencode.service.GathererService;

public class GathererServiceImpl implements GathererService {
	
	@Autowired
	private GathererRepository gathererRepository;
		
	@Override
	public JpaRepository<Gatherer, Integer> getRepository() {
			return gathererRepository;
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<Gatherer> findByLastNameAndFirstName(String lastName, String firstName) throws Exception {
		return gathererRepository.findByLastNameAndFirstName(lastName, firstName);
		}

	@Transactional(readOnly=true)
	@Override
	public List<Gatherer> findByLastNameStartingWithAndFirstNameStartingWith(String lastName, String firstName)
			throws Exception {
		return gathererRepository.finByLastNameStartingWithAndFirstNameStartingWith(lastName, firstName);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Gatherer> findByDisctrict(District district) throws Exception {
		return gathererRepository.findByDistrict(district);
	}



}
