package tn.esprit.spring.service;

import java.util.Date;

import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.Location;
import tn.esprit.spring.entity.Vente;

public interface VenteService {
	
	
	public Double calculPrix (Double prix, Double surface);
	Long addVente(Vente v);

}
