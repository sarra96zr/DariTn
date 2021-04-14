package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Notifications;


@Repository

public interface NotRepo extends CrudRepository<Notifications, Long> {

}
