package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Abonnement;
import tn.esprit.spring.entity.Aonnement;
import tn.esprit.spring.entity.Banque;
import tn.esprit.spring.repository.AbonnementRepo;
import tn.esprit.spring.service.AbonnementService;



@Scope (value = "session")
@Component (value = "abonnement")
@ELBeanName(value = "abonnement")
//@Join(path = "/", to = "/bank-lists.jsf")
@Controller
public class AbonnementController {
	@Autowired
	AbonnementService abservice;
	AbonnementRepo abrepo;
	
	
	
	// http://localhost:8081/DariTn/Pi/retrieve-all-abonnement
		@GetMapping("/retrieve-all-abonnement")
		@ResponseBody
		public List<Abonnement> getAbonnement() {
			List<Abonnement> list = abservice.retrieveAllAbonnement();
			return list;
		}
		// http://localhost:8081/DariTn/Pi/retrieve-abonnement/{abonnement-id}
				@GetMapping("/retrieve-abonnement/{abonnement-id}")
				@ResponseBody
				public Abonnement retrieveAbonnement(@PathVariable("abonnement-id") String id_ab) {
					return abservice.retrieveAbonnement(id_ab);
				}

				// Ajouter : http://localhost:8081/DariTn/Pi/add-abonnement
				@PostMapping("/add-abonnement")
				@ResponseBody
				public Abonnement addAbonnement(@RequestBody Abonnement ab) {
					Abonnement abonnement = abservice.addAbonnement(ab);
					return abonnement;
				}

				// http://localhost:8081/DariTn/Pi/Delete-abonnement/{abonnement-id}
				@DeleteMapping("/Delete-abonnement/{abonnement-id}")
				@ResponseBody
				public void removeAbonnement(@PathVariable("abonnement-id") String id_ab) {
					abservice.deleteAbonnement(id_ab);
					
				}

				// http://localhost:8081/DariTn/Pi/modify-abonnement
				@PutMapping("/modify-abonnement")
				@ResponseBody
				public Abonnement modifyAbonnementt(@RequestBody Abonnement ab) {
					return abservice.updateAbonnement(ab);
				}
				
				// recherche par type
				// http://localhost:8081/DariTn/Pi/search-abonnement/{abonnement-type}
				@GetMapping("/search-abonnement/{abonnement-type}")
				@ResponseBody
				public List<Abonnement> SearchAbonnementByType(@PathVariable("abonnement-type") String type_abonnement) {
					return abservice.SearchAbonnementByType(type_abonnement);
				}
				// range of date
				// http://localhost:8081/DariTn/Pi/range/{db}/{df}
				@GetMapping("/range/{db}/{df}")
				@ResponseBody
				public List<Abonnement> RangeDate(@PathVariable("db") Date db, @PathVariable("df") Date df) {
					return abservice.Range(db, df);
				}
				
				// trie abonnement par id asc
				// http://localhost:8081/DariTn/Pi/retrieve-all-products-asc
				@GetMapping("/retrieve-all-products-asc")
				@ResponseBody
				public List<Abonnement> orderByAscendingQantity() {
					List<Abonnement> list = abservice.orderByAscendingId();
					return list;
				}

				// trie abonnement par id desc
				// http://localhost:8081/DariTn/Pi/retrieve-all-products-desc
				@GetMapping("/retrieve-all-products-desc")
				@ResponseBody
				public List<Abonnement> orderByDescendingId() {
					List<Abonnement> list = abservice.orderByDescendingId();
					return list;
				}
				
				
				private Aonnement type;
				
				public Aonnement[] getAb() {
					return  Aonnement.values();
				}
				public Aonnement getType() {
					return type;
				}
				public void setType(Aonnement type) {
					this.type = type;
				}
				
				private Abonnement abonn = new Abonnement();



				public Abonnement getAbonn() {
					return abonn;
				}
				public void setAbonn(Abonnement abonn) {
					this.abonn = abonn;
				}
				
				
				public String save() {
				    	abrepo.save(abonn);
				        abonn = new Abonnement();
				        return "/DariTn/banque-list.xhtml";
				    }
				
				
}
