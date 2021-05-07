package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Client;


@Repository

public interface ClientRepo extends CrudRepository<Client, Long> {

}
