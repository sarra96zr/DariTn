package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Banque;




@Repository

public interface BanqueRepo extends CrudRepository<Banque, Integer> {

	@Query("SELECT p FROM Banque p WHERE p.nombanque= :nombanque")
	List<Banque> SearchProductByName(@Param("nombanque") String nombanque);
}
