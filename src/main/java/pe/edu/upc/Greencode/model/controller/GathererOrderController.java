package pe.edu.upc.Greencode.model.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import pe.edu.upc.Greencode.model.entity.GathererOrder;
import pe.edu.upc.Greencode.model.entity.Order;
import pe.edu.upc.Greencode.model.entity.Gatherer;
import pe.edu.upc.Greencode.model.serviceimpl.IGathererOrderServiceImpl;
import pe.edu.upc.Greencode.model.service.IGathererService;

public class GathererOrderController {
	//@Inject
	   //private IOrderService oService;
	     private IGathererService gService;
		
		//@Inject
		private IGathererOrderServiceImpl rService;
		private GathererOrder gathererorder;
		private Order order;
		private Gatherer gatherer;
		
		List<GathererOrder> lisGathererorders;
		List<Order> lisOrders;
		List<Gatherer> lisGatherers;
		
		@PostConstruct
		public void init() {
			this.gathererorder = new GathererOrder();
			this.lisGathererorders = new ArrayList<GathererOrder>();
			this.order= new Order();
			this.lisOrders= new ArrayList<Order>();
			this.lisGatherers = new ArrayList<Gatherer>();
			this.gatherer= new Gatherer();
			this.list();
			this.listO();
			this.listG();
		}
		
		public String newGathererOrder() {
			this.setGathererOrder(new GathererOrder());
			return "gathererorder.xhtml";
		}
		
		public void insert() {
			rService.insert(gathererorder);
			cleanGathererOrder();
			this.list();
		}
		
		public void list() {
			lisGathererorders = rService.list();
		}
		
		public void listO() {
			//lisOrder = oService.list();
		}
		
		public void listG() {
			lisGatherers = gService.list();
		}
		
		public void cleanGathererOrder() {
			this.init();
		}
		public void delete(GathererOrder gathererorder) {
			rService.delete(gathererorder.getId());
			this.list();
		}

		//Get and Set
		public GathererOrder getGathererOrder() {
			return gathererorder;
		}

		public void setGathererOrder(GathererOrder gathererorder) {
			this.gathererorder = gathererorder;
		}
		
		public Order getOrder() {
			return order;
		}

		public void setOrder(Order order) {
			this.order = order;
		}

		public Gatherer getGatherer() {
			return gatherer;
		}

		public void setGatherer(Gatherer gatherer) {
			this.gatherer = gatherer;
		}

		public List<GathererOrder> getLisGathererOrders() {
			return lisGathererorders;
		}

		public void setLisGathererOrders(List<GathererOrder> lisGathererorders) {
			this.lisGathererorders = lisGathererorders;
		}
		
		public List<Order> getListOrder() {
			return lisOrders;
		}

		public void setListOrder(List<Order> listOrder) {
			this.lisOrders = listOrder;
		}

		public List<Gatherer> getLisGatherers() {
			return lisGatherers;
		}

		public void setLisGatherers(List<Gatherer> lisGatherers) {
			this.lisGatherers = lisGatherers;
		}
}
