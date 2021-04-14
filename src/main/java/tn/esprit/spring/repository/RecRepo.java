package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Reclamations;


@Repository

public interface RecRepo extends CrudRepository<Reclamations, Long> {

}
