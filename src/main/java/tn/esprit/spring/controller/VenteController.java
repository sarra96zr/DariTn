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
import tn.esprit.spring.service.AnnonceService;

@RestController
public class VenteController {

	@Autowired
	VenteRepository vente;
	@Autowired
	AnnonceService annonceService;
	@Autowired
	AnnonceRepository ann;
	
	List <Annonce> annonces;
	List <Vente> ventes;
	
	
	private Double prixVente;
	
	
	public List<Vente> getVente() {
		ventes = vente.ListeVente(Disponible.En_cours);
		return ventes;
		}
	
	public void validerVente(@PathVariable("annonce-id") String id_a){

		System.err.println(id_a);
		System.err.println("hello1");
		Long id = Long.valueOf(id_a);
		Annonce a = ann.findById(id).get();

		System.err.println(a.getDisponible());
		a.setDisponible(Disponible.Reserve);
		//locationRepository.setReserve("Reserve", id_a);
		annonceService.addAnnonce(a);
		System.err.println(a.getDisponible());

	}

	public void annulerVente(@PathVariable("annonce-id") String id_a){
		System.err.println(id_a);
		System.err.println("hello1");
		Long id = Long.valueOf(id_a);
		Annonce a = ann.findById(id).get();
		a.setDisponible(Disponible.Dispo);

		//locationRepository.setDispo("Dispo", id_a);
		annonceService.addOrUpdateAnnonce(a);
		System.err.println(a.getDisponible());

	}
	public Double calculPrix(@PathVariable("annonce-id") String id_a){
		Long id = Long.valueOf(id_a);
		Annonce a = ann.findById(id).get();
		
		
		return a.getPrix() * a.getSurface();
		
	}

	public AnnonceRepository getAnn() {
		return ann;
	}

	public void setAnn(AnnonceRepository ann) {
		this.ann = ann;
	}

	public List<Annonce> getAnnonces() {
		return annonces;
	}

	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}

	public List<Vente> getVentes() {
		return ventes;
	}

	public void setVentes(List<Vente> ventes) {
		this.ventes = ventes;
	}

	public Double getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(Double prixVente) {
		this.prixVente = prixVente;
	}

	public void setVente(VenteRepository vente) {
		this.vente = vente;
	}
	
	
}
