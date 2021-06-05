package tn.esprit.spring.controller;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.primefaces.*;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.Categorie_Annonce;
import tn.esprit.spring.entity.Disponible;
import tn.esprit.spring.entity.Location;
import tn.esprit.spring.entity.Type_Annonce;
import tn.esprit.spring.repository.AnnonceRepository;
import tn.esprit.spring.repository.LocationRepository;
import tn.esprit.spring.service.AnnonceService;
import tn.esprit.spring.service.LocationService;

@Scope(value="session")
@ELBeanName(value = "annonceController") // Name of the bean used by JSF
@Join(path = "/", to = "/listeAnnonceVente.jsf")
@Controller(value = "annController")
public class TAnnonceController {

	@Autowired
	AnnonceService annonceService;
	@Autowired
	LocationService locationService;
	@Autowired
	AnnonceRepository ann;
	@Autowired
	LocationRepository locationRepository;
	private List<Annonce> annonces;
	private Date dateDebut;
	private Date dateFin;
	public Type_Annonce[] getTypea() { return Type_Annonce.values(); }
	public Categorie_Annonce[] getTypec() { return Categorie_Annonce.values(); }
	private Integer annonceIdToBeUpdated; 
	Annonce a = new Annonce();
	public Location location = new Location();
	static Double prixLocation;
	private String titre , adresse, video,description, photo;
	private Double prix;
	private boolean disponible; 
	private Type_Annonce type_annonce;
	private Categorie_Annonce categorie_annonce;
	private Long update;
	private int rating;
	
	// aff liste
	public List<Annonce> getAnnonceVente() {
		annonces = ann.ListeVente(Type_Annonce.Vente);
		return annonces;
		}
	//add
	public List<Annonce> getAnnonceLocation() {
		annonces = ann.ListeVente(Type_Annonce.Location);
		return annonces;
		}
	
	
	
	
		// methode 1
	public void addAnnonce() {
		System.err.println("dafefa");

		System.out.println("hello");
		if (titre.equals("") || adresse.equals("") || description.equals("") || prix==0 || prix<0 || type_annonce==null || categorie_annonce==null)
			
		{
			System.out.println("not added");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Vérifier "));
        //PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        //PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
			
		
		}
		
		else
			
			{annonceService.addOrUpdateAnnonce(new Annonce(titre, adresse, null, description, null,prix,3, Disponible.Disponible,type_annonce, categorie_annonce, null));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Annonce bien ajoutée "));
			System.out.println("added");}
        
		
	}
	   // methode 2
	
	/*public String save() {
		System.out.println("*********"+a.id);
		//System.err.println("*********"+rdv.title);
		//System.err.println("*********"+rdv.dateRDV);
		//System.err.println("*********"+rdv.dateDeb);
		System.out.println("*********"+a.getAdresse());
		ann.save(a);
		a = new Annonce();
		return "/DariTn/welcome.xhtml";
	}*/
	
	//delete
	public void removeAnnonce(@PathVariable("annonce-id") String id_a) {
		Long id = Long.valueOf(id_a);
		System.out.print(id_a);
		System.out.println("hello");
		Annonce a = ann.findById(id).get();
		System.out.print(a.getPrix());
		annonceService.deleteAnnonce(id_a);}
	
	// update
	

	public void displayEmploye(Annonce a) 
	{
	this.setTitre(a.getTitre());
	this.setDescription(a.getDescription());
	this.setAdresse(a.getAdresse()); 
	this.setPrix(a.getPrix());
	this.setType_annonce(a.getType_annonce());
	this.setCategorie_annonce(a.getCategorie_annonce());
	this.setUpdate(a.getId());
	}
	
	public void updateAnnonce()
	{ annonceService.updateAnnonce(new Annonce(update, titre, adresse, video, description, photo, prix, rating, Disponible.Disponible, type_annonce, categorie_annonce, null));
		 }
	public void openNew() {
        this.a = new Annonce();
    }
	//louer
	
	public String save() {

 		
 		locationRepository.save(location);
 		location = new Location();
 		location.dateDebut = GregorianCalendar.getInstance().getTime();
 		// = GregorianCalendar.getInstance().getTime();
 		location.dateFin = GregorianCalendar.getInstance().getTime();
 		//System.err.println("*********"+rdv.RD);
 		return "/DariTn/welcome.xhtml";
 	}
	
	public void louer(@PathVariable("annonce-id") String id_a) {
		Long id = Long.valueOf(id_a);
		
		System.out.println("hello");
		System.out.println(dateDebut);
		System.out.println(dateFin);

		Annonce a = ann.findById(id).get();
		System.out.println(a.getPrix());
 		
 		System.out.println(dateDebut);
		System.out.println(dateFin);
 		
 		
		locationService.calculPrix(a.getPrix(), dateDebut, dateFin);
		System.out.println(locationService.calculPrix(a.getPrix(), dateDebut, dateFin));
		Double prix = locationService.calculPrix(a.getPrix(), dateDebut, dateFin);
		locationService.addOrUpdateLocation(new Location(dateDebut, dateFin, prix, null, null) );
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Prix de votre location ",""+locationService.calculPrix(a.getPrix(), dateDebut, dateFin)));

			System.out.println("added");
			prixLocation = locationService.calculPrix(a.getPrix(), dateDebut, dateFin);
			a.setDisponible(Disponible.En_cours);
	} 
	
	public void validerLocation(@PathVariable("annonce-id") String id_a){
		Long id = Long.valueOf(id_a);
		Annonce a = ann.findById(id).get();
		a.setDisponible(Disponible.Réservé);
		
		
	}
	public void annulerLocation(@PathVariable("annonce-id") String id_a){
		Long id = Long.valueOf(id_a);
		Annonce a = ann.findById(id).get();
		a.setDisponible(Disponible.Disponible);
		
		
	}
	/*public void afficherDemande()
	{
		annonces = ann.ListeVente(Type_Annonce.Location);
		for (int i=0;i<annonces.size();i++){
			if annonces.
		}
		
	}*/
	
	
	public void showInfo() {

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Prix de votre location ",""+prixLocation));

	}
	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
	public void showInfo1() {
		System.out.println("hi");
		addMessage(FacesMessage.SEVERITY_INFO, "Info Message", "Message Content");

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public LocationService getLocationService() {
		return locationService;
	}
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Long getUpdate() {
		return update;
	}
	public void setUpdate(Long update) {
		this.update = update;
	}
	public Integer getAnnonceIdToBeUpdated() {
		return annonceIdToBeUpdated;
	}
	public List<Annonce> getAnnonces() {
		return annonces;
	}
	public void setAnnonceIdToBeUpdated(Integer annonceIdToBeUpdated) {
		this.annonceIdToBeUpdated = annonceIdToBeUpdated;
	}
	public AnnonceService getAnnonceService() {
		return annonceService;
	}
	public void setAnnonceService(AnnonceService annonceService) {
		this.annonceService = annonceService;
	}
	public AnnonceRepository getAnn() {
		return ann;
	}
	
	public void setAnn(AnnonceRepository ann) {
		this.ann = ann;
	}
	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}
	public Annonce getA() {
		return a;
	}
	public void setA(Annonce a) {
		this.a = a;
	}
	

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public Type_Annonce getType_annonce() {
		return type_annonce;
	}

	public void setType_annonce(Type_Annonce type_annonce) {
		this.type_annonce = type_annonce;
	}

	public Categorie_Annonce getCategorie_annonce() {
		return categorie_annonce;
	}

	public void setCategorie_annonce(Categorie_Annonce categorie_annonce) {
		this.categorie_annonce = categorie_annonce;
	}

	
}
