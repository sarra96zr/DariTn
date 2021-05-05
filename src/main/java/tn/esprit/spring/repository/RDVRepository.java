package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.RDV;

@Repository
public interface RDVRepository extends JpaRepository<RDV, Long>{
	
	
	
	
	/*@Query("select e from RDV e where e.date Between :dateDeb and :dateFin ")
	List<RDV> findBetween(@Param("start")   Date start,@Param("end")  Date end);*/
	
	
	@Query("select e from RDV e where e.title LIKE CONCAT('%',:title,'%') ")
	public List<RDV> searchEvent(@Param("title") String title);
	
	
}
