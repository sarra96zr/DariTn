package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.repository.AnnonceRepository;

@Service
public class AnnonceServiceImpl implements AnnonceService {


@Autowired
AnnonceRepository annonceRepository ;

private static final Logger L = LogManager.getLogger(AnnonceServiceImpl.class);

@Override
public List<Annonce> retrieveAllAnnonces() {
	List<Annonce> annonces = (List<Annonce>) annonceRepository.findAll();
	/*for (User user : users) {
		L.info("user :"+ user);
	}*/
	return annonces;
}

@Override
public Annonce addAnnonce(Annonce a) {
	return annonceRepository.save(a);
	
}

@Override
public void deleteAnnonce(String id) {
	annonceRepository.deleteById(Long.parseLong(id));
	
	
}

@Override
public Annonce updateAnnonce(Annonce a) {
	return annonceRepository.save(a);
}

@Override
public Optional<Annonce> retrieveAnnonce(String id) {
	Optional<Annonce> annonce = annonceRepository.findById(Long.parseLong(id));
	return annonce;
}


}

