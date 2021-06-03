package pe.edu.upc.Greencode.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Greencode.model.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
List<Account> findByNameAccount (Integer numberAccount);
}

