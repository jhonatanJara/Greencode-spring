package pe.edu.upc.Greencode.business.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.Greencode.business.QualifyGathererService;
import pe.edu.upc.Greencode.model.entity.Gatherer;
import pe.edu.upc.Greencode.model.repository.GathererRepository;




@Service
public class QualifyGathererServiceImpl implements QualifyGathererService{
	
	@Autowired
	private GathererRepository gathererRepository;
	
	@Transactional
	@Override
	public void changeQualify(Gatherer gatherer) throws Exception  {
		gatherer.setCalification(gatherer.getPoints()+gatherer.getCalification());
		gathererRepository.save(gatherer);
		
	}
	
	
}
