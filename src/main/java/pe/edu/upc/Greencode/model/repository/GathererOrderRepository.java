package pe.edu.upc.Greencode.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Greencode.model.entity.GathererOrder;
import pe.edu.upc.Greencode.model.entity.Gatherer;
import pe.edu.upc.Greencode.model.entity.Order;

@Repository
public interface GathererOrderRepository extends JpaRepository<GathererOrder,Integer>{
	List<GathererOrder> findByAmountAndPrice(Integer amount,float price);
	@Query("select g from GathererOrder g where g.amount like ?1% and g.price like ?2%")
	List<GathererOrder> finByAmountStartingWithAndPriceStartingWith(Integer amount,float price);

	List<GathererOrder> findByGatherer(Gatherer gatherer);
	List<GathererOrder> findByOrder(Order order);
}
