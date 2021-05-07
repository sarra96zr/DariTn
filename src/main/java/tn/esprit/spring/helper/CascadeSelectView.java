package tn.esprit.spring.helper;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;


@Named
@RequestScoped
public class CascadeSelectView {
	private List<SelectItem> panier;
    private String selection;
    private String selection2;
    @PostConstruct
    public void init() {
        panier = new ArrayList<>();
        SelectItemGroup group = new SelectItemGroup("Commander");
        group.setValue("Commander");
        SelectItemGroup group11 = new SelectItemGroup("Livraison");
        group11.setValue("Livraison");
        SelectItemGroup group12 = new SelectItemGroup("Carte Bancaire");
        group12.setValue("Carte");
        group.setSelectItems(new SelectItem[]{group11, group12});
        panier.add(group);
             
    }
    public void onItemSelect(SelectEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Commander", (String) event.getObject());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public List<SelectItem> getPanier() {
        return panier;
    }
    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }
    public String getSelection2() {
        return selection2;
    }

    public void setSelection2(String selection2) {
        this.selection2 = selection2;
    }
}
