package tn.esprit.spring.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Reclamations;
import tn.esprit.spring.entity.Type_Rec;
import tn.esprit.spring.repository.RecRepo;
import tn.esprit.spring.service.RecService;

@Scope(value = "session")
@Controller(value = "RecController") // Name of the bean in Spring IoC
@ELBeanName(value = "RecController") // Name of the bean used by JSF
@Join(path = "/", to = "/ReclamationClient.jsf")
@RestController

public class RecController {
	
	public Reclamations rec = new Reclamations();
	
	public RecRepo RecDAO;
		
	public String titreReclam;
	public String descriptionReclam;
	public Type_Rec type;
	Client client;
	@Autowired
	private RecService RecService;
	
	
	public void addRec() {
		RecService.addOrUpdateRec(new Reclamations(titreReclam, descriptionReclam, type, client));
		}
	public Type_Rec[] getTypes() { return Type_Rec.values(); } 

	// http://localhost:8081/DariTn/retrieve-all-reclamations
	@GetMapping("/retrieve-all-reclamations")
	@ResponseBody
	public List<Reclamations> getRecs() {
		return RecService.retrieveAllRecs();
	}
	// http://localhost:8081/DariTn/retrieve-reclamation/{rec-id}
	@GetMapping("/retrieve-reclamation/{rec-id}")
	@ResponseBody
	public Reclamations retrieveRec(@PathVariable("rec-id") String id_r) {
		return RecService.retrieveRec(id_r);
	}

	// http://localhost:8081/DariTn/add-reclamation
	//@PostMapping("/add-reclamation")
	//@ResponseBody
	//public Reclamations addProduct(@RequestBody Reclamations r) {
	//	 Reclamations rec = RecService.addRec(r);
	//	return rec;
	//}

	// http://localhost:8081/DariTn/Delete-rec/{rec-id}
	@DeleteMapping("/Delete-rec/{rec-id}")
	@ResponseBody
	public void removeProduct(@PathVariable("rec-id") String id_r) {
		RecService.deleteRec(id_r);

	}

	// http://localhost:8081/DariTn/modify-reclamation
	@PutMapping("/modify-rec")
	@ResponseBody
	public Reclamations modifyProduct(@RequestBody Reclamations r) {
		return RecService.updateRec(r);
	}

	// http://localhost:8081/DariTn/findByType/{rec-type}
	@GetMapping("/findByType/{rec-type}")
	@ResponseBody
	public List<Reclamations> SearchRecByType(@PathVariable("rec-type") Type_Rec type) {
		return RecService.RechercheRec(type);
	}

	// http://localhost:8081/DariTn/reclamations/client/get/{client}			
	@GetMapping("/reclamations/client/get/{client}")
	@ResponseBody
	public List<Reclamations> findClientById(@PathVariable("client") int id_client)
	{
		List<Reclamations> liste=RecService.findByClientId(id_client);
		return liste;
	}

	// http://localhost:8081/DariTn/add-reclamation/{client}
	@PutMapping("/add-reclamation/{client}")
	@ResponseBody
	public ResponseEntity<String> ajouterRec(@PathVariable("client")int client, @RequestBody Reclamations r)
	{
		RecService.ajouterRec(client,r);
		return new ResponseEntity<>("Ajout réussi.", HttpStatus.CREATED);


	}

	// http://localhost:8081/DariTn/modify-reclamation/{rec}/{client}
	@PutMapping("/modify-reclamation/{rec}/{client}")
	@ResponseBody
	public ResponseEntity<String> modifierCredit(@PathVariable("rec")int rec,@PathVariable("client")int client)
	{
		RecService.modifierRec(rec);		
		return new ResponseEntity<>("modification résussie.", HttpStatus.ACCEPTED);
	}

	// http://localhost:8081/DariTn/reclamations/panier/{panier}			
	@GetMapping("/reclamations/panier/{panier}")
	@ResponseBody
	public List<Reclamations> findRecWithPID(@PathVariable("panier") long id_panier)
	{
		return RecService.findRecWithPID(id_panier);

	}

	// http://localhost:8081/DariTn/reclamations/panier/{panier}			
	//@GetMapping("/reclamations/panier1/{panier}")
	//@ResponseBody
	//public List<Long> findRecWithPID1(@PathVariable("panier") long id_panier)
	//{
	//	return RecService.findRecWithPID1(id_panier);

	//}

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Reclamations> rec = RecService.retrieveAllRecs();
		model.addAttribute("listReclamations", rec);

		return "index";
	}

	public String save() {
		System.err.println("*********"+rec.id_reclam);
		//System.err.println("*********"+rdv.title);
		//System.err.println("*********"+rdv.dateRDV);
		//System.err.println("*********"+rdv.dateDeb);
		System.err.println("*********"+rec.getClient());
    	RecDAO.save(rec);
        rec = new Reclamations();
        return "/DariTn/Reclamations.xhtml";
    }
	
	public Reclamations getRec() {
		return rec;
	}

	public void setRec(Reclamations rec) {
		this.rec = rec;
	}

	public String getTitreReclam() {
		return titreReclam;
	}
	public void setTitreReclam(String titreReclam) {
		this.titreReclam = titreReclam;
	}
	public String getDescriptionReclam() {
		return descriptionReclam;
	}
	public void setDescriptionReclam(String descriptionReclam) {
		this.descriptionReclam = descriptionReclam;
	}
	public Type_Rec getType() {
		return type;
	}
	public void setType(Type_Rec type) {
		this.type = type;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}

}
