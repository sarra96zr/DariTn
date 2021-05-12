package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Surveillance;
import tn.esprit.spring.entity.User;

public interface SurveillanceRepo extends CrudRepository<Surveillance,Long> {
/*	@Query("SELECT f FROM Surveillance f WHERE f.id=:id ")
	public List<Surveillance> getSubById(@Param("id")Long id);
	@Query("SELECT f FROM Surveillance f WHERE f.user=:user ")
	public List<Surveillance> getSubByUser(@Param("user")User user); */

}
