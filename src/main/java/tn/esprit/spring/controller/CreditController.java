package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entity.Credit;
import tn.esprit.spring.entity.CreditFormula;
import tn.esprit.spring.repository.BanqueRepo;
import tn.esprit.spring.repository.ClientRepo;
import tn.esprit.spring.service.CreditService;

@RestController
public class CreditController {
	
	@Autowired
	CreditService cs;
	
	@Autowired
	BanqueRepo bankrep;
	
	@Autowired
	ClientRepo rp;
	
	
	// http://localhost:8081/DariTn/Pi/retrieve-all-credit
			@GetMapping("/retrieve-all-credit")
			@ResponseBody
			public List<Credit> getBanque() {
				List<Credit> list = cs.retrieveAllCredit();
				return list;
			}
			
			// http://localhost:8081/DariTn/Pi/retrieve-all-formule
						@GetMapping("/retrieve-all-formule")
						@ResponseBody
						public List<CreditFormula> getFormule() {
							List<CreditFormula> list = cs.retrieveAllFormule();
							return list;
						}
	
	
     //  http://localhost:8081/DariTn/Pi/affect/{id}/addformule
	@PutMapping("/affect/{id}/addformule")
	@ResponseBody
	public ResponseEntity<String> ajouterFormule(@PathVariable("id")int id, @RequestBody CreditFormula F  )
	{
		cs.ajouterCreditFormula(F, id);
		return new ResponseEntity<>("Ajout reussie.", HttpStatus.CREATED);
		
	}
	
    //  http://localhost:8081/DariTn/Pi/client/{client}/credit/creditformulas/{id}/addcredit
	@PutMapping("/client/{client}/credit/creditformulas/{id}/addcredit")
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
	
//  http://localhost:8081/DariTn/Pi/creditformula/{id}/get
	@GetMapping("creditformula/{id}/get")
	public CreditFormula affichercreditformula(@PathVariable("id") int id)
	{
		return cs.affichercreditformula(id);
	}
	
//  http://localhost:8081/DariTn/Pi/client/{client}/credit/{credit}/creditformula/{id}/modify
	@PutMapping("/client/{client}/credit/{credit}/creditformula/{id}/modify")
	public ResponseEntity<String> modifierCredit(@PathVariable("client")int client, @PathVariable("credit")int credit, @PathVariable("id")int id)
	{
		cs.modifiercredit(credit, id);		
		return new ResponseEntity<>("success.", HttpStatus.ACCEPTED);
	}
	

	

	

	

	

}
