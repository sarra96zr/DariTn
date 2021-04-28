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
import org.springframework.web.servlet.ModelAndView;

import tn.esprit.spring.entity.Abonnement;
import tn.esprit.spring.entity.Banque;
import tn.esprit.spring.service.BanqueService;


@Controller
public class BanqueController {
	@Autowired
	BanqueService banqueService;
	
	
	
	// http://localhost:8081/DariTn/Pi/retrieve-all-banque
		@GetMapping("/retrieve-all-banque")
		@ResponseBody
		public List<Banque> getBanque() {
			List<Banque> list = banqueService.retrieveAllBanque();
			return list;
		}
		// http://localhost:8081/DariTn/Pi/retrieve-banque/{banque-id}
				@GetMapping("/retrieve-banque/{banque-id}")
				@ResponseBody
				public Banque retrieveBanque(@PathVariable("banque-id") String id_b) {
					return banqueService.retrieveBanque(id_b);
				}

				// Ajouter : http://localhost:8081/DariTn/Pi/add-banque
				@PostMapping("/add-banque")
				@ResponseBody
				public Banque ajouterCreditFormula(@RequestBody Banque b) {
					 Banque banque = banqueService.addBanque(b);
					return banque;
				}

				// http://localhost:8081/DariTn/Pi/Delete-banque/{banque-id}
				@DeleteMapping("/Delete-banque/{banque-id}")
				@ResponseBody
				public void removeBanque(@PathVariable("banque-id") int id_b) {
					banqueService.deleteBanque(id_b);
					
				}

				// http://localhost:8081/DariTn/Pi/modify-banque
				@PutMapping("/modify-banque")
				@ResponseBody
				public Banque modifyBanque(@RequestBody Banque b) {
					return banqueService.updateBanque(b);
				}
				
				// recherche par nom
				// http://localhost:8081/DariTn/Pi/search-banque/{banque-name}
				@GetMapping("/search-banque/{banque-name}")
				@ResponseBody
				public List<Banque> SearchBanqueByName(@PathVariable("banque-name") String name_banque) {
					return banqueService.SearchBanqueByName(name_banque);
				}
				
				@RequestMapping("/retbanque")
				public String viewHomePage(Model model) {
				    List<Banque> banque = banqueService.retrieveAllBanque();
				    model.addAttribute("banque", banque);
				     
				    return "retrivebanque";
				}
				
				@RequestMapping("/newbanque")
				public String showNewProductPage(Model model) {
				    Banque banque = new Banque();
				    model.addAttribute("banque", banque);
				     
				    return "newbanque";
				}
				
				@RequestMapping(value = "/save", method = RequestMethod.POST)
				public String saveProduct(@ModelAttribute("banque") Banque banque) {
					banqueService.addBanque(banque);
				     
				    return "redirect:/";
				}
				
				@RequestMapping("/deletebanque/{id}")
				public String deleteBanque(@PathVariable(name = "id") int id) {
				    banqueService.deleteBanque(id);
				    return "redirect:/";       
				}
				
				@RequestMapping("/editbanque/{id}")
				public ModelAndView showEditProductPage(@PathVariable(name = "id") Banque b) {
				    ModelAndView mav = new ModelAndView("edit_banque");
				    Banque banque = banqueService.updateBanque(b);
				    mav.addObject("banque", banque);
				     
				    return mav;
				}}
				
				
