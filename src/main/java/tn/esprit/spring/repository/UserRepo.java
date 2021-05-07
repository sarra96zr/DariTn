package tn.esprit.spring.repository;




import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.entity.Banque;
import tn.esprit.spring.entity.Expert_financier;
import tn.esprit.spring.entity.User;


@Repository
public interface UserRepo extends CrudRepository<User, Long>{
	
	@Query(value="SELECT a FROM Expert_financier a WHERE a.bank=:bank")
    Optional<Expert_financier> findbankagentbybankid(@Param("bank")Banque bank);
    
    
	
	
	


}