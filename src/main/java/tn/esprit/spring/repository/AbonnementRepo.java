package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Abonnement;


public interface AbonnementRepo extends CrudRepository<Abonnement, Long> {
	@Query("SELECT p FROM Abonnement p WHERE p.type= :type")
	List<Abonnement> SearchAbonnementByType(@Param("type") String type);

}
