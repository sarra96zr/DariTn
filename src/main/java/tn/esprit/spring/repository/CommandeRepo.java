package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.entity.Meubles;



public interface CommandeRepo  extends CrudRepository<Commande, Long>  {
	@Query("SELECT o FROM Orders o WHERE o.meuble= :meubles")
	List<Commande> GetOrdersByMeuble(@Param("meuble") Meubles meuble);

}
