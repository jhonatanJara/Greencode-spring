package pe.edu.upc.Greencode.model.serviceimpl;

import java.io.Serializable;
import java.util.List;


import pe.edu.upc.Greencode.model.dao.IGathererOrderDao;
import pe.edu.upc.Greencode.model.entity.GathererOrder;
import pe.edu.upc.Greencode.model.service.IGathererOrderService;

public class IGathererOrderServiceImpl implements IGathererOrderService, Serializable{

		private static final long serialVersionUID = 1L;
			
			//@Inject
			private IGathererOrderDao cD;
			
			@Override
			public void insert(GathererOrder gathererOrder) {
				cD.insert(gathererOrder);
			}

			@Override
			public List<GathererOrder> list() {
				return cD.list();
			}

			@Override
			public void delete(int idGathererOrder) {
				cD.delete(idGathererOrder);
			}

		

}
