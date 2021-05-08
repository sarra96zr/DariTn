package tn.esprit.spring.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.Categorie_Annonce;
import tn.esprit.spring.entity.Type_Annonce;
import tn.esprit.spring.repository.AnnonceRepository;
import tn.esprit.spring.service.AnnonceService;

@Scope(value="session")
@ELBeanName(value = "annonceController") // Name of the bean used by JSF
@Join(path = "/", to = "/welcome.jsf")
@Controller(value = "annController")
public class TAnnonceController {

	@Autowired
	AnnonceService annonceService;
	
	AnnonceRepository ann;
	private List<Annonce> annonces;

	public Type_Annonce[] getTypea() { return Type_Annonce.values(); }
	public Categorie_Annonce[] getTypec() { return Categorie_Annonce.values(); }
	private Integer annonceIdToBeUpdated; 
	Annonce a = new Annonce();
	
	private String titre , adresse, video,description, photo;
	private float prix;
	private boolean disponible; 
	private Type_Annonce type_annonce;
	private Categorie_Annonce categorie_annonce;
	
	
	// aff liste
	public List<Annonce> getAnnonce() {
		annonces = annonceService.getAllAnnonces();
		/*FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Your message",
                "Message details");*/
		return annonces;
		}
	//add
	
		// methode 1
	public void addAnnonce() {
		System.out.println("hello");
		annonceService.addOrUpdateAnnonce(new Annonce(titre, adresse, null, description, null, prix, true,type_annonce, categorie_annonce, null));
		System.out.println("hello2");
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
		annonceService.deleteAnnonce(id_a);}
	
	// update
	/*public void updateAnnonce()
	{ annonceService.updateAnnonce(a)(new Annonce(update, nom_meuble, description_meuble, price, typem));
		 }
	public void openNew() {
        this.m = new Meubles();
    }

	public void displayEmploye(Employe empl) 
	{
	this.setPrenom(empl.getPrenom());
	this.setNom(empl.getNom());
	this.setActif(empl.isActif()); 
	this.setEmail(empl.getEmail());
	this.setRole(empl.getRole());
	this.setPassword(empl.getPassword());
	this.setEmployeIdToBeUpdated(empl.getId());
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Integer getAnnonceIdToBeUpdated() {
		return annonceIdToBeUpdated;
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

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
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
