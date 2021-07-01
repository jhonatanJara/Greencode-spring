package pe.edu.upc.Greencode.business.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.Greencode.business.QualifyRecyclerService;
import pe.edu.upc.Greencode.model.entity.Recycler;
import pe.edu.upc.Greencode.model.repository.RecyclerRepository;



@Service
public class QualifyRecyclerServiceImpl implements QualifyRecyclerService{
	
	@Autowired
	private RecyclerRepository recyclerRepository;
	
	@Transactional
	@Override
	public void changeQualify(Recycler recycler) throws Exception  {
		recycler.setCalification(recycler.getPoints()+recycler.getCalification());
		recyclerRepository.save(recycler);
		//update(recycler);
	}
	
	
}
