package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.entity.Meubles;


@Repository
public interface CommandeRepo  extends CrudRepository<Commande, Long>  {
	@Query("SELECT c FROM Commande c WHERE c.m= :meuble")
	List<Commande> GetOrdersByMeubles(@Param("meuble") Meubles meuble);
	

}
