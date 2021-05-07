package tn.esprit.spring.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import tn.esprit.spring.entity.Banque;
import tn.esprit.spring.repository.BanqueRepo;

@Scope(value = "session")
@Component(value = "bankController")
@ELBeanName(value = "bankController")
@Join(path = "/DariTn", to = "/banque-form.jsf")
public class BanqueControllerJsf {
    @Autowired
    private BanqueRepo banqueRepository;

    private Banque banque = new Banque();

    public String save() {
    	banqueRepository.save(banque);
        banque = new Banque();
        return "/DariTn/banque-list.xhtml";
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