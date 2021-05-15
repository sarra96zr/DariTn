package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
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
import org.springframework.web.servlet.ModelAndView;
import tn.esprit.spring.entity.Abonnement;
import tn.esprit.spring.entity.Banque;
import tn.esprit.spring.service.BanqueService;

@Scope (value = "session")
@Component (value = "bankLists")
@ELBeanName(value = "bankLists")
//@Join(path = "/banque", to = "/banque-form.jsf")
@Controller
public class BanqueController {
	@Autowired
	BanqueService banqueService;
	private List<Banque> ban;	
		public List<Banque> getBan() {
			if (ban == null) {
				ban = new ArrayList<>();
			}
		return ban;
	}
	public void setBan(List<Banque> ban) {
		this.ban = ban;
	}
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
				


private List<Banque> banques; // ajouter le getter et le setter
private String nombank;
private Integer idbanque;
private List<Banque> search;






public List<Banque> getSearch() {
	return search;
}
public void setSearch(List<Banque> search) {
	this.search = search;
}
public String getNombank() {
	return nombank;
}
public void setNombank(String nombank) {
	this.nombank = nombank;
}
public Integer getIdbanque() {
	return idbanque;
}
public void setIdbanque(Integer idbanque) {
	this.idbanque = idbanque;
}
public List<Banque> getBanques() {
	banques = banqueService.retrieveAllBanque();
	return banques;
}
public void setBanques(List<Banque> banques) {
	this.banques = banques;
}

public void removeBank(int id) { 
	banqueService.deleteBanque(id);
	getBanques();
}

private Banque b = new Banque();

public Banque getB() {
	return b;
}
public void setB(Banque b) {
	this.b = b;
}
public String searchByName(String nombanque)
{
    this.search = banqueService.SearchBanqueByName(nombanque);
    return null;
}






}
				
				
