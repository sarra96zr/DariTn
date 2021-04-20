package tn.esprit.spring.service;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService{

	@Override
	public Double calculPrix(Double prix, Date datedeb, Date datefin) {
		
		 double prix1;
	        final long MILLISECONDS_PER_DAY = 1000 * 60 * 60 * 24; 

	        return prix1= ((prix/31)*(datefin.getTime()-datedeb.getTime()))/ (MILLISECONDS_PER_DAY);
	           
	}

}
