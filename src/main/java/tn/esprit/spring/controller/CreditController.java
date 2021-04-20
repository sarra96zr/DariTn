package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entity.Credit;
import tn.esprit.spring.entity.CreditFormula;
import tn.esprit.spring.repository.BanqueRepo;
import tn.esprit.spring.repository.UserRepo;
import tn.esprit.spring.service.CreditService;

@RestController
public class CreditController {
	
	@Autowired
	CreditService cs;
	
	@Autowired
	BanqueRepo bankrep;
	
	@Autowired
	UserRepo rp;
	
	
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
	
    //  http://localhost:8081/DariTn/Pi/affectclientacredit/{client}/{id}/addcredit
	@PutMapping("/affectclientacredit/{client}/{id}/addcredit")
	@ResponseBody
	public ResponseEntity<String> ajouterCredit(@PathVariable("client")int client, @PathVariable("id")int id, @RequestBody Credit C)
	{
		cs.ajouterCredit(client, id , C);
		return new ResponseEntity<>("Ajout reussie.", HttpStatus.CREATED);
	
		
	}
	

	

	

	

	

	

}
