package pe.edu.upc.Greencode.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Greencode.model.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
