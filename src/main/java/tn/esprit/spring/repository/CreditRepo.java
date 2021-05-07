package tn.esprit.spring.repository;


import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Credit;

public interface CreditRepo extends CrudRepository<Credit, Integer>{
	@Query(value="SELECT c FROM Credit c WHERE c.client=:client")
	List<Credit> getcreditsbyclient(@Param("client") Client C);
}
