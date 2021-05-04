package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.service.AnnonceService;
import tn.esprit.spring.service.MeubleService;

@Controller
public class AnnonceController {

	@Autowired
	AnnonceService annonceService;
	
	private List<Annonce> annonces;
	
	
	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}

	// http://localhost:8081/DariTn/Pi/retrieve-all-annonces
	@GetMapping("/retrieve-all-annonces")
		@ResponseBody
		public List<Annonce> getAnnonces() {
			List<Annonce> list = annonceService.retrieveAllAnnonces();
			return list;
		}
	
		// http://localhost:8081/DariTn/Pi/retrieve-annonces/{annonce-id}
				@GetMapping("/retrieve-annonce/{annonce-id}")
				@ResponseBody
				public Annonce retrieveAnnoce(@PathVariable("annonce-id") String id_m) {
					return annonceService.retrieveAnnonce(id_m);
				}

				// http://localhost:8081/DariTn/Pi/add-annonce
				@PostMapping("/add-annonce")
				@ResponseBody
				public Annonce addProduct(@RequestBody Annonce a) {
					 Annonce annonce = annonceService.addAnnonce(a);
					return annonce;
				}

				// http://localhost:8081/DariTn/Pi/Delete-annonce/{annonce-id}
				@DeleteMapping("/Delete-annonce/{annonce-id}")
				@ResponseBody
				public void removeAnnonce(@PathVariable("annonce-id") String id_a) {
					annonceService.deleteAnnonce(id_a);
					
				}

				// http://localhost:8081/DariTn/Pi/modify-annoce
				@PutMapping("/modify-annonce")
				@ResponseBody
				public Annonce modifyAnnoce(@RequestBody Annonce a) {
					return annonceService.updateAnnonce(a);
				}
				
				
				// http://localhost:8081/DariTn/Pi/search-annonce/{annonce-title}
				@GetMapping("/search-annonce/{annonce-title}")
				@ResponseBody
				public List<Annonce> SearchProductByName(@PathVariable("annonce-title") String annonce_title) {
					return annonceService.RechercheAnnonce(annonce_title);
				}
				
				@RequestMapping("/")
				public String viewHomePage(Model model) {
				    List<Annonce> listAnnonces = annonceService.retrieveAllAnnonces();
				    model.addAttribute("listAnnonces", listAnnonces);
				     
				    return "index";

}
				@RequestMapping("/new")
				public String addAnnonce(Model model) {
					Annonce annonce = new Annonce();
					model.addAttribute("a", annonce);
					return "newAnn";

				}				
				@RequestMapping(value = "/add_annonce", method = RequestMethod.POST)
				public String saveProduct(@ModelAttribute("a") Annonce annonce) {
					annonceService.addAnnonce(annonce);

					return "redirect:/";
				}

}
