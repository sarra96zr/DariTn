package tn.esprit.spring.service;

import org.springframework.stereotype.Service;

@Service
public class VenteServiceImpl implements VenteService {

	@Override
	public Double calculPrix(Double prix, Float surface) {
		
		return prix*surface;
	}

	
}