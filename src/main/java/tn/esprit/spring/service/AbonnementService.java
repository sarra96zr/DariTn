package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Abonnement;


public interface AbonnementService {
	
	List<Abonnement> retrieveAllAbonnement();
	Abonnement addAbonnement(Abonnement ab);
	void deleteAbonnement(String id_ab);
	Abonnement updateAbonnement(Abonnement ab);
	Abonnement retrieveAbonnement(String id_ab);
	List<Abonnement> SearchAbonnementByType(String type_abonnement);
 

}
