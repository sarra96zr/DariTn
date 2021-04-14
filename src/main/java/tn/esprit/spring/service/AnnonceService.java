package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.*;

public interface AnnonceService {



	List<Annonce> retrieveAllAnnonces();
	Annonce addAnnonce(Annonce a);
	void deleteAnnonce(String id);
	Annonce updateAnnonce(Annonce a);
	Optional<Annonce> retrieveAnnonce(String id);


}
