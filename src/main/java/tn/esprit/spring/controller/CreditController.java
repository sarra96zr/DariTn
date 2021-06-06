package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestParam;

import tn.esprit.spring.entity.Abonnement;
import tn.esprit.spring.entity.Aonnement;
import tn.esprit.spring.entity.Banque;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Credit;
import tn.esprit.spring.repository.BanqueRepo;
import tn.esprit.spring.repository.ClientRepo;
import tn.esprit.spring.repository.CreditRepo;
import tn.esprit.spring.service.BanqueService;
import tn.esprit.spring.service.CreditService;

@Scope (value = "session")
@Component (value = "credits")
@ELBeanName(value = "credits")
//@Join(path = "/", to = "/bank-lists.jsf")
@Controller
public class CreditController {
	
	@Autowired
	CreditService cs;
	
	@Autowired
	BanqueService bs;
	
	@Autowired
	BanqueRepo bankrep;
	
	@Autowired
	ClientRepo rp;
	
	@Autowired
	CreditRepo cr;
	
	
	// http://localhost:8081/DariTn/Pi/retrieve-all-credit
			@GetMapping("/retrieve-all-credit")
			@ResponseBody
			public List<Credit> getBanque() {
				List<Credit> list = cs.retrieveAllCredit();
				return list;
			}
			
			
	
	
    
	
    //  http://localhost:8081/DariTn/Pi/client/{client}/credit/creditformulas/{id}/addcredit
	@PutMapping("/client/{client}/credit/banque/{id}/addcredit")
	@ResponseBody
	public ResponseEntity<String> ajouterCredit(@PathVariable("client")int client, @PathVariable("id")int id, @RequestBody Credit C)
	{
		cs.ajouterCredit(client, id , C);
		return new ResponseEntity<>("Ajout reussie.", HttpStatus.CREATED);
	
		
	}
	
	//  http://localhost:8081/DariTn/Pi/credit/{id}/get
	@GetMapping("credit/{id}/get")
	public Credit afficherCredit(@PathVariable("id") int id)
	{
		return cs.afficherCredit(id);
	}
	
	// http://localhost:8081/DariTn/Pi/Delete-credit/{credit-id}
	@DeleteMapping("/Delete-credit/{credit-id}")
	@ResponseBody
	public void supprimerCredit(@PathVariable("credit-id") int id) {
		cs.supprimerCredit(id);
		
	}
	
    //  http://localhost:8081/DariTn/Pi/credit/client/{client}/get
	@GetMapping("/credit/client/{client}/get")
	public List<Credit> getallcreditsofclient(@PathVariable("client") int id_client)
	{
		List<Credit> liste=cs.getallcreditsofclient(id_client);
		return liste;
	}
	

	
//  http://localhost:8081/DariTn/Pi/client/{client}/credit/{credit}/creditformula/{id}/modify
	@PutMapping("/client/{client}/credit/{credit}/creditformula/{id}/modify")
	public ResponseEntity<String> modifierCredit(@PathVariable("client")int client, @PathVariable("credit")int credit, @PathVariable("id")int id)
	{
		cs.modifiercredit(credit, id);		
		return new ResponseEntity<>("success.", HttpStatus.ACCEPTED);
	}
	
//  http://localhost:8081/Pi/client/client/{client}/credit/{id}/email
	@PostMapping("/client/{client}/credit/{id}/email")
	public ResponseEntity<String> emailagentbancaire( @PathVariable("client") int client, @PathVariable("id") int id,  @RequestParam(name="sender",required=false) String sender,  @RequestParam(name="subject",required=false) String subject, @RequestParam(name="body",required=false) String body)
	{
		cs.emailagentbancaire(id, sender, subject, body);
		return new ResponseEntity<>("success.", HttpStatus.CREATED);
	}
	
	private List<Credit> credits; // ajouter le getter et le setter
private int client;
private int id;
private Credit C;
private String bank;
private Banque type;
private List<Banque> cc ;
private Credit creto;
private float inamount;
private Client cli;












	public Client getCli() {
	return cli;
}

public void setCli(Client cli) {
	this.cli = cli;
}

	public float getInamount() {
	return inamount;
}

public void setInamount(float inamount) {
	this.inamount = inamount;
}

	public Banque getType() {
	return type;
}

public void setType(Banque type) {
	this.type = type;
}

public List<Banque> getCc() {
	return bs.retrieveAllBanque();
	
}

public void setCc(List<Banque> cc) {
	this.cc = cc;
}

	public Credit getCreto() {
		if (creto == null) {
			creto = new Credit();
		}
	return creto;
}

public void setCreto(Credit creto) {
	this.creto = creto;
}


	public String getBank() {
	return bank;
}

public void setBank(String bank) {
	this.bank = bank;
}

	public long getClient() {
	return client;
}

public void setClient(int client) {
	this.client = client;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Credit getC() {
	return C;
}

public void setC(Credit c) {
	C = c;
}


	public List<Credit> getCredits() {
		credits = cs.retrieveAllCredit();
		return credits;
	}
	public void setCredits(List<Credit> credits) {
		this.credits = credits;
	}
	
	
	private Credit cre = new Credit();

    public String save() {
    	cr.save(cre);
        cre = new Credit();
        return "/DariTn/banque-list.xhtml";
    }

	public Credit getCre() {
		return cre;
	}

	public void setCre(Credit cre) {
		this.cre = cre;
	}
	
	public void removeCredit(int id) { 
		cs.supprimerCredit(id);
		getCre();
	}
	private Banque banque = new Banque();
	public Banque getCreditformule() {
		return banque;
	}

	public void setCreditformule(Banque creditformule) {
		this.banque = creditformule;
	}
	
	

	public void add(Credit k){
	//	this.setClient(k.getClient().getId_user());
		this.setInamount(k.getInitialamount());
		// this.setId(k.getCreditformula().getId());
		cli.addcredit(k);
		
		
	}
	
	public void addcredit() { 
		cs.ajouterCredit(client, id, C);
	}


	
	

	

	

	

	

}
