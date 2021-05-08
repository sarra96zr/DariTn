package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Client;


@Repository

public interface ClientRepo extends CrudRepository<Client, Long> {

	@Query("select c from User c where c.id_user= :client")
	Client findByClientId(@Param("client") long client);
}
