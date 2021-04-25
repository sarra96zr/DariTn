package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import ch.qos.logback.core.net.server.Client;
//import java.util.List;
import tn.esprit.spring.entity.Reclamations;
import tn.esprit.spring.entity.Type_Rec;
import tn.esprit.spring.entity.Client;

@Repository

public interface RecRepo extends CrudRepository<Reclamations, Long> {

		
		//@Query("SELECT r FROM Reclamations r WHERE r.type= :type")
		//List<Reclamations> RechercheRec(@Param("type") Type_Rec type);
		List<Reclamations> findByType(Type_Rec type);
		@Query("select r from Reclamations r where r.client= :client")
		List<Reclamations> findByClientId(@Param("client") Client client);

}

