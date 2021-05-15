package tn.esprit.spring.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entity.Abonnement;
import tn.esprit.spring.entity.Banque;
import tn.esprit.spring.repository.BanqueRepo;
import tn.esprit.spring.service.BanqueService;

@Scope(value = "session")
@Component(value = "bankController")
@ELBeanName(value = "bankController")
//@Join(path = "/banque", to = "/banque-form.jsf")
public class BanqueControllerJsf {
	@Autowired
	BanqueService bs;
    @Autowired
    private BanqueRepo banqueRepository;
    private String nombank;
    private Integer idbanque;
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

	private Banque banque = new Banque();

    
    
    public void update() { 
		bs.updateBanque(new Banque(idbanque,nombank));
	}
    
    public void add() { 
		bs.addBanque(new Banque(nombank));
	}
    
    public void displayBanque(Banque bank){
    	this.setNombank(bank.getNombanque());
    	this.setIdbanque(bank.getId());

    	
    	
    }
    

    public Banque getBanque() {
    	
        return banque;
    }

	public BanqueRepo getBanqueRepository() {
		return banqueRepository;
	}

	public void setBanqueRepository(BanqueRepo banqueRepository) {
		this.banqueRepository = banqueRepository;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}
	
	
	
	
	
	
	
}