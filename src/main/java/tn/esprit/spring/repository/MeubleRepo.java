package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Meubles;


@Repository

public interface MeubleRepo extends CrudRepository<Meubles, Long> {
	@Query("SELECT m FROM Meubles m WHERE m.Nom_meuble= :nom_meuble")
	List<Meubles> SearchProductByName(@Param("nom_meuble") String name_meuble);
	@Query("select m from Meubles m where m.prix between :min and :max")
	public List<Meubles> Range(@Param("min") float min, @Param("max") float max);
	 @Query(value = "SELECT * from Meubles m WHERE m.Nom_meuble = :name", nativeQuery = true)
		Meubles getByName(@Param("name")String name);
}
