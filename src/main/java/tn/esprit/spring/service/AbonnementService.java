package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Abonnement;



public interface AbonnementService {
	
	List<Abonnement> retrieveAllAbonnement();
	public long addAbonnement(Abonnement abonnement);
	void deleteAbonnement(String id_ab);
	Abonnement updateAbonnement(Abonnement ab);
	Abonnement retrieveAbonnement(String id_ab);
	List<Abonnement> SearchAbonnementByType(String type_abonnement);
	public List<Abonnement> Range(Date db, Date df);
	List<Abonnement> orderByAscendingId();
	List<Abonnement> orderByDescendingId();
	
 

}
