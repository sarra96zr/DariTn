package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.Disponible;
import tn.esprit.spring.entity.Location;
import tn.esprit.spring.entity.Type_Annonce;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long>{

	@Query("SELECT a FROM Location a WHERE a.annonce.disponible = :type")
	List<Location> Listelocation(@Param("type") Disponible type );
	
	//List<Location> Listelocation(Disponible enCours);
	
	
	
}
