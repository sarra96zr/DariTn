package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Disponible;
import tn.esprit.spring.entity.Location;
import tn.esprit.spring.entity.Vente;

@Repository
public interface VenteRepository extends CrudRepository<Vente, Long>{

	@Query("SELECT a FROM Vente a WHERE a.annonce.disponible = :type")
	List<Vente> ListeVente(@Param("type") Disponible type );
	
	
}
