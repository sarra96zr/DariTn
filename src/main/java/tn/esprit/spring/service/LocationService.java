package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.Location;

public interface LocationService {

	Location addLocation(Date datedeb, Date datefin);
	public Double calculPrix (Double prix,Date datedeb, Date datefin);
	List<Location> retrieveAllLocation();
	Long addOrUpdateLocation(Location l);
	void deleteLocation(String id);
	public void sendTextEmail(Location r);
}
