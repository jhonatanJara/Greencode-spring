package pe.edu.upc.Greencode.model.controller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import pe.edu.upc.Greencode.model.entity.District;
import pe.edu.upc.Greencode.model.entity.Gatherer;
import pe.edu.upc.Greencode.model.serviceimpl.IGathererServiceImpl;


//@Named
//@RequestScoped
public class GathererController {
	
	//@Inject
   // private IDistrictService dService;
	
	//@Inject
	private IGathererServiceImpl rService;
	private District district;
	private Gatherer gatherer;
	
	List<District> listDistricts;
	List<Gatherer> lisGatherers;
	
	@PostConstruct
	public void init() {
		this.district= new District();
		this.listDistricts= new ArrayList<District>();
		this.lisGatherers = new ArrayList<Gatherer>();
		this.gatherer= new Gatherer();
		this.list();
		this.listD();
	}
	
	public String newGatherer() {
		this.setGatherer(new Gatherer());
		return "gatherer.xhtml";
	}
	
	public void insert() {
		rService.insert(gatherer);
		cleanGatherer();
		this.list();
	}
	
	public void list() {
		lisGatherers = rService.list();
	}
	
	public void listD() {
		//listDistricts = dService.list();
	}
	
	public void cleanGatherer() {
		this.init();
	}
	public void delete(Gatherer gatherer) {
		rService.delete(gatherer.getId());
		this.list();
	}

	//Get and Set
	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Gatherer getGatherer() {
		return gatherer;
	}

	public void setGatherer(Gatherer gatherer) {
		this.gatherer = gatherer;
	}

	public List<District> getListDistricts() {
		return listDistricts;
	}

	public void setListDistricts(List<District> listDistricts) {
		this.listDistricts = listDistricts;
	}

	public List<Gatherer> getLisGatherers() {
		return lisGatherers;
	}

	public void setLisGatherers(List<Gatherer> lisGatherers) {
		this.lisGatherers = lisGatherers;
	}
}