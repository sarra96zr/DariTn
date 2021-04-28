package tn.esprit.spring.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

import tn.esprit.spring.entity.Meubles;
import tn.esprit.spring.helper.GeneratePdfReport;
import tn.esprit.spring.service.MeubleService;

@Controller
public class MeubleController {
	@Autowired
	MeubleService meubleService;

	// http://localhost:8081/DariTn/Pi/retrieve-all-furnitures
	@GetMapping("/retrieve-all-furnitures")
	@ResponseBody
	public List<Meubles> getMeubles() {
		List<Meubles> list = meubleService.retrieveAllMeubles();
		return list;
	}

	// http://localhost:8081/DariTn/Pi/retrieve-furniture/{meuble-id}
	@GetMapping("/retrieve-furniture/{meuble-id}")
	@ResponseBody
	public Meubles retrieveMeuble(@PathVariable("meuble-id") String id_m) {
		return meubleService.retrieveMeubles(id_m);
	}

	// Ajouter : http://localhost:8081/DariTn/Pi/add-meuble
	@PostMapping("/add-meuble")
	@ResponseBody
	public Meubles addProduct(@RequestBody Meubles m) {
		Meubles meuble = meubleService.addMeuble(m);
		return meuble;
	}

	// http://localhost:8081/DariTn/Pi/Delete-meuble/{meuble-id}
	@DeleteMapping("/Delete-meuble/{meuble-id}")
	@ResponseBody
	public void removeProduct(@PathVariable("meuble-id") String id_m) {
		meubleService.deleteMeubles(id_m);

	}

	// http://localhost:8081/DariTn/Pi/modify-meuble
	@PutMapping("/modify-meuble")
	@ResponseBody
	public Meubles modifyProduct(@RequestBody Meubles m) {
		return meubleService.updateMeuble(m);
	}

	// recherche par nom
	// http://localhost:8081/DariTn/Pi/search-meuble/{meuble-name}
	@GetMapping("/search-meuble/{meuble-name}")
	@ResponseBody
	public List<Meubles> SearchProductByName(@PathVariable("meuble-name") String name_meuble) {
		return meubleService.SearchMeublesByName(name_meuble);
	}

	// range of price
	// http://localhost:8081/DariTn/Pi/range/{min}/{max}
	@GetMapping("/range/{min}/{max}")
	@ResponseBody
	public List<Meubles> RangeProducts(@PathVariable("min") float min, @PathVariable("max") float max) {
		return meubleService.Range(min, max);
	}

	// importer la liste des meubles en vente dans un fichier PDF
	// http://localhost:8081/Daritn/Pi/pdfreport
	@RequestMapping(value = "/pdfreport", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> MeubleReport() {

		List<Meubles> mb = (List<Meubles>) meubleService.findAll();

		ByteArrayInputStream bis = GeneratePdfReport.MeublesReport(mb);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=meublesreport.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}

	// JSF
	// http://localhost:8081/Daritn/
	@RequestMapping("/")
	public String getMeubles(Model model) {
		List<Meubles> list = meubleService.retrieveAllMeubles();
		model.addAttribute("m", list);

		return "index";
	}

	// http://localhost:8081/Daritn/new
	@RequestMapping("/new")
	public String addMeubles(Model model) {
		Meubles product = new Meubles();
		model.addAttribute("m", product);
		return "add_product";

	}

	@RequestMapping(value = "/add_meuble", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("m") Meubles product) {
		meubleService.addMeuble(product);

		return "redirect:/";
	}
}
