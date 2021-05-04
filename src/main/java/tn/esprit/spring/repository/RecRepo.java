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
		
		@Query(value="select * from reclamations r INNER JOIN t_user c ON r.client_id_user=c.id_user INNER JOIN panier p ON c.t_panier_client=p.id_panier where p.id_panier =:idd ",nativeQuery=true)
		
		List<Reclamations> findRecWithPID(@Param("idd") Long id);
		
		
		//@Query("select r.id_reclam from reclamations r INNER JOIN client c ON r.client.id_user=c.id_user INNER JOIN panier p ON c.panier.id_panier=p.id_panier where p.id_panier =:idd ") 
		//List<Long> findRecWithPID1(@Param("idd") Long id);
}

