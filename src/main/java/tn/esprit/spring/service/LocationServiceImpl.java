package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.Location;
import tn.esprit.spring.repository.AnnonceRepository;
import tn.esprit.spring.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService{
	
	@Autowired
	LocationRepository locarepo;

	@Override
	public Double calculPrix(Double prix, Date datedeb, Date datefin) {
		
		 double prix1;
	        final long MILLISECONDS_PER_DAY = 1000 * 60 * 60 * 24; 

	        return prix1= ((prix/31)*(datefin.getTime()-datedeb.getTime()))/ (MILLISECONDS_PER_DAY);
	         //annoncerepo.save(entity)
	           
	}

	@Override
	public Location addLocation( Date datedeb, Date datefin) {
		//User u = new tn.esprit.spring.entity.User(1, "zeineb","yah", "zeineb", "pass", , annonces, notifications)
		Location l = new Location(datedeb, datefin, calculPrix(300.2,datedeb, datefin),null,null);
		return locarepo.save(l);
	}

	@Override
	public List<Location> retrieveAllLocation() {
		List<Location> annonces = (List<Location>) locarepo.findAll();
		return annonces;
	}
	
	

}