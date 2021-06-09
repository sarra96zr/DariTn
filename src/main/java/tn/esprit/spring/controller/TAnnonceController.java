package tn.esprit.spring.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.primefaces.*;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.Categorie_Annonce;
import tn.esprit.spring.entity.Disponible;
import tn.esprit.spring.entity.Location;
import tn.esprit.spring.entity.Type_Annonce;
import tn.esprit.spring.entity.Vente;
import tn.esprit.spring.helper.GenerPDFDemande;
import tn.esprit.spring.repository.AnnonceRepository;
import tn.esprit.spring.repository.LocationRepository;
import tn.esprit.spring.service.AnnonceService;
import tn.esprit.spring.service.LocationService;
import tn.esprit.spring.service.VenteService;

@Scope(value="session")
@ELBeanName(value = "annController") // Name of the bean used by JSF
@Join(path = "/", to = "/login.jsf")
@Controller(value = "annController")
@RestController
public class TAnnonceController {

	@Autowired
	AnnonceService annonceService;
	@Autowired
	VenteService venteService;
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
	private Annonce a = new Annonce();
	
	public Location location = new Location();
	static Double prixLoc;
	static Double prixVente;
	private String titre , adresse, video,description, photo;
	private Double prix;
	final Disponible disponible=Disponible.Dispo; 
	private Type_Annonce type_annonce;
	private Categorie_Annonce categorie_annonce;
	private Long update;
	private int rating;
	private Double surface;
	
	
	//mail
	@PostMapping(value="/textemail",consumes = "application/json", produces = "application/json")
	public String sendEmail(@RequestBody Location emailTemplate) {
		try {
			//log.info("Sending Simple Text Email....");
			locationService.sendTextEmail(emailTemplate);
			return "Email Sent!";
		} catch (Exception ex) {
			return "Error in sending email: " + ex;
		}
	}
	



	// affichage des listes
	//affichage liste vente
	public List<Annonce> getAnnonceVente() {

		annonces = ann.ListeVente(Type_Annonce.Vente,Disponible.Dispo);
		return annonces;
	}
	//affichage liste location
	public List<Annonce> getAnnonceLocation() {
		annonces = ann.ListeLocation(Type_Annonce.Location,Disponible.Dispo);
		//ListeVente(Type_Annonce.Location);
		return annonces;
	}
	public void clear(){
		a.setTitre("");
		a.setAdresse("");
		a.setDescription("");
		a.setPrix(0d);
		a.setSurface(0d);

	}
	//ajout de l'annonce
	public void addAnnonce() {
		System.err.println("dafefa");

		System.out.println("hello");

		if (titre.equals("") || adresse.equals("") || description.equals("") || prix==0 || prix<0 || type_annonce==null || categorie_annonce==null || surface==0 || surface<0)

		{
			System.out.println("not added");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Vérifier "));
			//PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
			//PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
		}

		else

		{annonceService.addOrUpdateAnnonce(new Annonce(titre, adresse, null, description, null, prix, 3,surface,disponible, type_annonce, categorie_annonce, null));
		//annonceService.addOrUpdateAnnonce(new Annonce(titre, adresse, null, description, null,prix,3, disponible.Disponible,type_annonce, categorie_annonce, null));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Annonce bien ajoutée "));
		System.out.println("added");
		clear();
		}
	}


	// ajout 2

	public void save1() {
		System.out.println("*********"+a.id);
		//System.err.println("*********"+rdv.title);
		//System.err.println("*********"+rdv.dateRDV);
		//System.err.println("*********"+rdv.dateDeb);
		System.out.println("*********"+a.getAdresse());
		ann.save(a);
		//a = new Annonce();
	}

	// modifier annonce
	public void updateAnnonce()
	{ 
		System.err.println("hello from update");
		annonceService.updateAnnonce(new Annonce(update, titre, adresse, null, description, null, prix, 3, surface,Disponible.Dispo, type_annonce, categorie_annonce, null));
	}
	public Annonce modif(String id_a){
		
		Long id = Long.valueOf(id_a);
		Annonce a = ann.findById(id).get();
		System.err.println(a.getId());
		return annonceService.retrieveAnnonce(id_a);
	}
	// display
	public void displayAnnonce(String id_a) 
	{Long id = Long.valueOf(id_a);
	Annonce a = ann.findById(id).get();
	System.err.println(a.getId());
	System.err.println(a.getTitre());
		this.setTitre(a.getTitre());
		this.setDescription(a.getDescription());
		this.setAdresse(a.getAdresse()); 
		this.setSurface(a.getSurface());
		this.setPrix(a.getPrix());
		this.setType_annonce(a.getType_annonce());
		this.setCategorie_annonce(a.getCategorie_annonce());
		this.setUpdate(a.getId());
		updateAnnonce();
	}

	public String getTitreID(String id_a){
		Long id = Long.parseLong(id_a);
		Annonce a = ann.findById(id).get();
		System.err.println(a.getId());
		System.err.println(a.getTitre());
		return a.getTitre();
		
		
	}
	
	public String getDescID(String id_a){
		Long id = Long.valueOf(id_a);
		Annonce a = ann.findById(id).get();
		System.err.println(a.getId());
		System.err.println(a.getTitre());
		return a.getDescription();
	}
	public String getAddID(String id_a){
		Long id = Long.parseLong(id_a);
		Annonce a = ann.findById(id).get();
		System.err.println(a.getId());
		System.err.println(a.getTitre());
		return a.getAdresse();
	}
	public Double getPrixID(String id_a){
		Long id = Long.valueOf(id_a);
		Annonce a = ann.findById(id).get();
		System.err.println(a.getId());
		System.err.println(a.getTitre());
		return a.getPrix();
	}
	public Double getSurfID(String id_a){
		Long id = Long.valueOf(id_a);
		Annonce a = ann.findById(id).get();
		System.err.println(a.getId());
		System.err.println(a.getTitre());
		return a.getSurface();
	}
	
	public Type_Annonce getTypeaa(String id_a){
		Long id = Long.valueOf(id_a);
		Annonce a = ann.findById(id).get();
		System.err.println(a.getId());
		System.err.println(a.getTitre());
		return a.getType_annonce();
	}
	public Categorie_Annonce getTypecc(String id_a){
		Long id = Long.valueOf(id_a);
		Annonce a = ann.findById(id).get();
		System.err.println(a.getId());
		System.err.println(a.getTitre());
		return a.getCategorie_annonce();
	}
	
	
	public List<Annonce> saveById(long id){
		List<Annonce> mm = new ArrayList<>();
		a = new Annonce();
		String ref=Long.toString(id);
		a=annonceService.retrieveAnnonce(ref);
		System.err.println("m="+a.getTitre());
		mm.add(a);
		return mm ;  
	}

	//delete
	public void removeAnnonce(String id_a) {

		System.out.print(id_a);
		System.out.println("hello");
		annonceService.deleteAnnonce(id_a);

	}
	//methode 2
	public void delete(String id_a) {
		
		Long id = Long.valueOf(id_a);
		System.out.print(id_a);
		System.out.println("hello");

		annonceService.deleteAnnonce(id_a);
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void removeAnnoncee(String a)
	{
		annonceService.deleteAnnonce(a);}

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

	public Double calcul(@PathVariable("annonce-id") String id_a) {
		System.err.println("calcul");
		Long id = Long.valueOf(id_a);
		Annonce a = ann.findById(id).get();
		String datedeb = String.valueOf(dateDebut);
		System.err.println(datedeb);
		String date1=datedeb.substring(4,7);
		System.err.println(date1);

		if (date1.equals("Jan") || date1.equals("Feb") || date1.equals("Mar") ){
			return prixLoc = locationService.calculPrix(a.getPrix(), dateDebut, dateFin);
		}else if (date1.equals("May") || date1.equals("Apr") || date1.equals("Jun")){
			return prixLoc = locationService.calculPrix(a.getPrix(), dateDebut, dateFin)+20;
		}else if (date1.equals("Aug") || date1.equals("Jul")|| date1.equals("Sep")){
			return prixLoc = locationService.calculPrix(a.getPrix(), dateDebut, dateFin)+40;
		} 
		else{
			return prixLoc = locationService.calculPrix(a.getPrix(), dateDebut, dateFin)+30;
		}
	}



	@RequestMapping("/export/pdf")
	public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException, com.itextpdf.text.DocumentException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<Location> listorders = locationService.retrieveAllLocation();

		GenerPDFDemande exporter = new GenerPDFDemande(listorders);
		exporter.export(response);
	}


	public void louer(@PathVariable("annonce-id") String id_a) {


		if (dateDebut.before(dateFin)){


			System.err.println("hello1");

			Long id = Long.valueOf(id_a);
			Annonce a = ann.findById(id).get();

			locationService.calculPrix(a.getPrix(), dateDebut, dateFin);
			Double prix = locationService.calculPrix(a.getPrix(), dateDebut, dateFin);
			System.out.println(prixLoc);

			locationService.addOrUpdateLocation(new Location(dateDebut, dateFin, TAnnonceController.getPrixLoc() ,null, a) );
			System.out.println(getPrixLoc());
			System.err.println("hello2");
			prixLoc = locationService.calculPrix(a.getPrix(), dateDebut, dateFin);
			a.setDisponible(Disponible.En_cours);
			annonceService.addOrUpdateAnnonce(a);
			System.out.println("ad");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Location ajoutée"));
			PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
		} else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Vérifier les dates"));
			// PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
			//PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
			// clear();    
		}
	} 

	public void validerLocation(@PathVariable("annonce-id") String id_a){
		Long id = Long.valueOf(id_a);
		Annonce a = ann.findById(id).get();
		a.setDisponible(Disponible.Reserve);
	}
	public void annulerLocation(@PathVariable("annonce-id") String id_a){
		Long id = Long.valueOf(id_a);
		Annonce a = ann.findById(id).get();
		a.setDisponible(Disponible.Dispo);
	}
	/*public void afficherDemande()
	{
		annonces = ann.ListeVente(Type_Annonce.Location);
		for (int i=0;i<annonces.size();i++){
			if annonces.
		}

	}*/


	public void showInfo() {

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Prix de votre location ",""+prixLoc));

	}
	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().
		addMessage(null, new FacesMessage(severity, summary, detail));
	}
	public void showInfo1() {
		System.out.println("hi");
		addMessage(FacesMessage.SEVERITY_INFO, "Info Message", "Message Content");

	}

	//acheter
	public Double calculV(@PathVariable("annonce-id") String id_a)
	{
		System.err.println("hello");
		Long id = Long.valueOf(id_a);
		Annonce a = ann.findById(id).get();
		System.err.println(prixVente);
		return prixVente=a.getSurface()*a.getPrix();		
	}

	public void acheter(@PathVariable("annonce-id") String id_a){
		System.err.println("hello");
		Long id = Long.valueOf(id_a);
		Annonce a = ann.findById(id).get();

		venteService.addVente(new Vente(TAnnonceController.prixVente, null, a));
		a.setDisponible(Disponible.En_cours);
		annonceService.addOrUpdateAnnonce(a);	

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
	public LocationRepository getLocationRepository() {
		return locationRepository;
	}
	public void setLocationRepository(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public static Double getPrixLoc() {
		return prixLoc;
	}
	public static void setPrixLoc(Double prixLocation) {
		TAnnonceController.prixLoc = prixLocation;
	}
	public Double getSurface() {
		return surface;
	}
	public void setSurface(Double surface) {
		this.surface = surface;
	}
	public Disponible getDisponible() {
		return disponible;
	}
	public static Double getPrixVente() {
		return prixVente;
	}
	public static void setPrixVente(Double prixVente) {
		TAnnonceController.prixVente = prixVente;
	}


}
