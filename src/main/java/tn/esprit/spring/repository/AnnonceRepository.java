package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.*;


@Repository
public interface AnnonceRepository extends CrudRepository<Annonce, Long> {

	@Query("SELECT a FROM Annonce a WHERE a.titre= :annonce_title")
	List<Annonce> RechercheAnnonce(@Param("annonce_title") String annonce_title);

	@Query("SELECT a FROM Annonce a WHERE a.id= :id_user")
	List<Annonce> ListeParUser(@Param("id_user") String id_user);
	
	
}
