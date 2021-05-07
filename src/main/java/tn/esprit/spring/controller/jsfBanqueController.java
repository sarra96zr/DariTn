package tn.esprit.spring.controller;

import java.util.List;

//import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import tn.esprit.spring.service.BanqueService;
import tn.esprit.spring.service.BanqueServiceImpl;
import tn.esprit.spring.entity.Banque;
@Controller(value = "jsfBanqueController")
@ELBeanName(value = "jsfBanqueController")
//@Join(path = "/", to = "/banque.jsf")

public class jsfBanqueController {
	@Autowired
	BanqueService banqueservice;
	@Autowired
	BanqueServiceImpl bs;
	@Autowired
	BanqueController bc;
	private String nombanque;
	private List<Banque> banque;
	public BanqueService getBanqueservice() {
		return banqueservice;
	}
	public void setBanqueservice(BanqueService banqueservice) {
		this.banqueservice = banqueservice;
	}
	public BanqueServiceImpl getBs() {
		return bs;
	}
	public void setBs(BanqueServiceImpl bs) {
		this.bs = bs;
	}
	public BanqueController getBc() {
		return bc;
	}
	public void setBc(BanqueController bc) {
		this.bc = bc;
	}
	public String getNombanque() {
		return nombanque;
	}
	public void setNombanque(String nombanque) {
		this.nombanque = nombanque;
	}
	public List<Banque> getBanque() {
		return banque;
	}
	public void setBanque(List<Banque> banque) {
		this.banque = banque;
	}
	
}