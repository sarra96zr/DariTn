package tn.esprit.spring.service;

import java.util.List;


import tn.esprit.spring.entity.Surveillance;


public interface SurveillanceService {
	
	List<Surveillance> retrieveAllSurveillance();

	public long addSurveillance(Surveillance surveillance);
	public void deleteSurveillance(int id_ab);
	Surveillance updateSurveillance(Surveillance ab);
	Surveillance retrieveSurveillance(String id_ab);
}
