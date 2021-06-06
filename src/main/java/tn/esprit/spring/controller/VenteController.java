package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.Disponible;
import tn.esprit.spring.entity.Location;
import tn.esprit.spring.entity.Type_Annonce;
import tn.esprit.spring.entity.Vente;
import tn.esprit.spring.repository.AnnonceRepository;
import tn.esprit.spring.repository.VenteRepository;

@RestController
public class VenteController {

	@Autowired
	VenteRepository vente;
	
	@Autowired
	AnnonceRepository ann;
	
	List <Annonce> annonces;
	List <Vente> ventes;
	
	
	public List<Vente> getVente() {
		ventes = vente.ListeVente(Disponible.En_cours);
		return ventes;
		}
	
	public void validerVente(@PathVariable("annonce-id") String id_a){
		Long id = Long.valueOf(id_a);
		Annonce a = ann.findById(id).get();
		a.setDisponible(Disponible.Reserve);
		
		
	}
	public void annulerVente(@PathVariable("annonce-id") String id_a){
		Long id = Long.valueOf(id_a);
		Annonce a = ann.findById(id).get();
		a.setDisponible(Disponible.Dispo);
		
		
	}
	
	
}
