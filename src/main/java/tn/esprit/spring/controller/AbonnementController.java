package tn.esprit.spring.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.entity.Abonnement;
import tn.esprit.spring.entity.Aonnement;
import tn.esprit.spring.entity.Reclamations;
import tn.esprit.spring.helper.GeneratePdfRec;
import tn.esprit.spring.repository.AbonnementRepo;
import tn.esprit.spring.service.AbonnementService;



@Scope (value = "session")
@Component (value = "subscription")
@ELBeanName(value = "subscription")
//@Join(path = "/Abonnement", to = "/abonnement.jsf")
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
				public long addAbonnement(@RequestBody Abonnement ab) {
					long abonnement = abservice.addAbonnement(ab);
					return abonnement;
				}

				// http://localhost:8081/DariTn/Pi/Delete-abonnement/{abonnement-id}
				@DeleteMapping("/Delete-abonnement/{abonnement-id}")
				@ResponseBody
				public void removeAbonnement(@PathVariable("abonnement-id") int id_ab) {
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
				// http://localhost:8081/DariTn/Pi/retrieve-all-abonnement-asc
				@GetMapping("/retrieve-all-abonnement-asc")
				@ResponseBody
				public List<Abonnement> orderByAscendingQantity() {
					List<Abonnement> list = abservice.orderByAscendingId();
					return list;
				} 

				// trie abonnement par id desc
				// http://localhost:8081/DariTn/Pi/retrieve-all-abonnement-desc
				@GetMapping("/retrieve-all-abonnement-desc")
				@ResponseBody
				public List<Abonnement> orderByDescendingId() {
					List<Abonnement> list = abservice.orderByDescendingId();
					return list;
				}
				
				//PDF
				// http://localhost:8081/DariTn/orders/export/pdf
				@RequestMapping("/export/pdf")
				public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException, com.itextpdf.text.DocumentException {
					response.setContentType("application/pdf");
					DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
					String currentDateTime = dateFormatter.format(new Date());

					String headerKey = "Content-Disposition";
					String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
					response.setHeader(headerKey, headerValue);

					List<Abonnement> listorders = abservice.retrieveAllAbonnement();

					GeneratePdfRec exporter = new GeneratePdfRec(listorders);
					exporter.export(response);
				}
				private Date datedeb;
				private Date datefin;
				private List<Abonnement> abonnements;
				private Long id;
				private Abonnement selectedabonnement;
				
				public Abonnement getSelectedabonnement() {
					return selectedabonnement;
				}
				public void setSelectedabonnement(Abonnement selectedabonnement) {
					this.selectedabonnement = selectedabonnement;
				}
				public void openNew() {
			        this.selectedabonnement = new Abonnement();
			    }
				public Long getId() {
					return id;
				}
				public void setId(Long id) {
					this.id = id;
				}
				public List<Abonnement> getAbonnements() {
					abonnements = abservice.retrieveAllAbonnement();
					return abonnements;
				}
				public void setAbonnements(List<Abonnement> abonnements) {
					this.abonnements = abonnements;
				}
				public Date getDatedeb() {
					return datedeb;
				}
				public void setDatedeb(Date datedeb) {
					this.datedeb = datedeb;
				}
				public Date getDatefin() {
					return datefin;
				}
				public void setDatefin(Date datefin) {
					this.datefin = datefin;
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
				
				
				public AbonnementRepo getAbrepo() {
					return abrepo;
				}
				public void setAbrepo(AbonnementRepo abrepo) {
					this.abrepo = abrepo;
				}
				public void addSubscription() {

					
					abservice.addAbonnement(new Abonnement(datedeb, datefin, type));
					
					
					}
				
				public void removeSubscription(int id_b) { 
					abservice.deleteAbonnement(id_b);
					getAbonnements();
				}
				
				public void updateSubscription() { 
					abservice.updateAbonnement(new Abonnement(id, type, datedeb, datefin));
				}
				
				
				public void displayAbonnement(Abonnement abon){
					this.setDatedeb(abon.getDate_debut());
					this.setDatefin(abon.getDate_fin());
					this.setType(abon.getType());
					this.setId(abon.getId());
					
					
				}
				}
				

