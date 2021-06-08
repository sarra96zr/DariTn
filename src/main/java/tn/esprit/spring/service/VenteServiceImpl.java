package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.Location;
import tn.esprit.spring.entity.Vente;
import tn.esprit.spring.repository.VenteRepository;

@Service
public class VenteServiceImpl implements VenteService {
	@Autowired
	VenteRepository vente;

	@Override
	public Double calculPrix(Double prix, Double surface) {
		
		return prix*surface;
	}

	@Override
	public Long addVente(Vente v) {
		vente.save(v);
		return v.id;
	}

	
}
