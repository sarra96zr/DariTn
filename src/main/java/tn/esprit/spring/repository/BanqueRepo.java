package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Banque;



@Repository

public interface BanqueRepo extends CrudRepository<Banque, Long> {

}
