package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Reclamations;





public interface RecService {
	List<Reclamations> retrieveAllRecs();
	void deleteRec(String id_r);
	Reclamations updateRec(Reclamations  r);
	Reclamations retrieveRec(String id_r);
	Reclamations addRec(Reclamations r);

}
