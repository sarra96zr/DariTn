package tn.esprit.spring.service;

import java.util.List;

import ch.qos.logback.core.net.server.Client;
import tn.esprit.spring.entity.Reclamations;
import tn.esprit.spring.entity.Type_Rec;





public interface RecService {
	List<Reclamations> retrieveAllRecs();
	void deleteRec(String id_r);
	Reclamations updateRec(Reclamations  r);
	Reclamations retrieveRec(String id_r);
	Reclamations addRec(Reclamations r);
	List<Reclamations> RechercheRec(Type_Rec type);
	List<Reclamations> findByClientId(int client);
}
