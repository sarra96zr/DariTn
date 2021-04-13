package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Meubles;


@Repository

public interface MeubleRepo extends CrudRepository<Meubles, Long> {

}
