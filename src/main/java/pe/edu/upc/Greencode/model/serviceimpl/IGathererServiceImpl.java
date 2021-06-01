package pe.edu.upc.Greencode.model.serviceimpl;


import java.io.Serializable;
import java.util.List;

import pe.edu.upc.Greencode.model.dao.IGathererDao;
import pe.edu.upc.Greencode.model.entity.Gatherer;
import pe.edu.upc.Greencode.model.service.IGathererService;


public class IGathererServiceImpl implements IGathererService, Serializable{

	private static final long serialVersionUID = 1L;

	//@Inject	
	private IGathererDao mD;
	
	@Override
	public void insert(Gatherer gatherer) {
		mD.insert(gatherer);
	}


	@Override
	public void delete(int idGatherer) {
		mD.delete(idGatherer);
	}

	@Override
	public List<Gatherer> list() {
		return mD.list();

	}

}
