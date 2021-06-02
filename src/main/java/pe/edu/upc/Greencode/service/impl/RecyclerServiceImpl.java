package pe.edu.upc.Greencode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Greencode.model.entity.District;
import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.model.repository.RecyclerRepository;
import pe.edu.upc.Greencode.service.RecyclerService;

@Service
public class RecyclerServiceImpl implements RecyclerService {

	@Autowired
	private RecyclerRepository recyclerRepository;
	
	@Override
	public JpaRepository<Recycler, Integer> getRepository() {
		return recyclerRepository;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Recycler> findByLastNameStartingWithAndFirstNameStartingWith(String lastName, String firstName)
			throws Exception {
		return recyclerRepository.findByLastNameStartingWithAndFirstNameStartingWith(lastName, firstName);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Recycler> findByLastNameAndFirstName(String lastName, String firstName) throws Exception {
	
		return recyclerRepository.findByLastNameAndFirstName(lastName, firstName);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Recycler> findByDistrict(District district) throws Exception {
		return recyclerRepository.findByDistrict(district);
	}

}
