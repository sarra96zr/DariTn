package tn.esprit.spring.service;

import java.util.List;

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
	public void ajouterRec(int client, Reclamations r);
	public void modifierRec(int rec);
	List<Reclamations> findRecWithPID(long id);
	//List<Long> findRecWithPID1(long id);
	void addOrUpdateRec(int client,Reclamations rec);
	void update(Reclamations r);

}
