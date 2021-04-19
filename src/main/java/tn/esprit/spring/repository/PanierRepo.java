package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Panier;

@Repository
public interface PanierRepo extends CrudRepository<Panier, Long>  {

}
