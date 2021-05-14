package tn.esprit.spring.controller;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;


import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.PrimeFaces;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import net.bytebuddy.asm.Advice.This;
import tn.esprit.spring.service.MeubleService;
import tn.esprit.spring.service.MeubleServiceImpl;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.entity.Meubles;
import tn.esprit.spring.entity.Type_Meuble;
import tn.esprit.spring.repository.MeubleRepo;
@ManagedBean
@Scope
@Controller(value = "JsfMeubleController")
@ELBeanName(value = "JsfMeubleController")
//@Join(path = "/DariTn/meuble", to = "/Meuble.jsf")
public class JsfMeubleController {
	@Autowired
	MeubleService MeubleService;
	@Autowired
	MeubleRepo mr;
	@Autowired
	MeubleServiceImpl ms;
	@Autowired
	MeubleController mc;
	private String nom_meuble;
	private Type_Meuble typem;
    private UploadedFile file;
	//private String picture;
	private String description_meuble;
	private float price;
	private List<Meubles> meuble;
	private long ref_meuble;
	private long update;
	private int qte;
	private Commande cmd;
	private Meubles m=new Meubles();
	private Client client;
	
	public UploadedFile getFile() {
		return file;
	}
	public void setFile(UploadedFile file) {
		this.file = file;
	}
	public MeubleRepo getMr() {
		return mr;
	}
	public void setMr(MeubleRepo mr) {
		this.mr = mr;
	}
	public MeubleService getMeubleService() {
		return MeubleService;
	}
	public void setMeubleService(MeubleService meubleService) {
		MeubleService = meubleService;
	}
	public MeubleServiceImpl getMs() {
		return ms;
	}
	public void setMs(MeubleServiceImpl ms) {
		this.ms = ms;
	}
	public MeubleController getMc() {
		return mc;
	}
	public void setMc(MeubleController mc) {
		this.mc = mc;
	}
	public String getNom_meuble() {
		return nom_meuble;
	}
	public void setNom_meuble(String nom_meuble) {
		this.nom_meuble = nom_meuble;
	}
	public String getDescription_meuble() {
		return description_meuble;
	}
	public void setDescription_meuble(String description_meuble) {
		description_meuble = description_meuble;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public List<Meubles> getMeuble() {
		meuble = MeubleService.retrieveAllMeubles();
		return meuble;
	}
	public void setMeuble(List<Meubles> meuble) {
		this.meuble = meuble;
	}
	public long getIdProduct() {
		return ref_meuble;
	}
	public void setIdProduct(long idProduct) {
		this.ref_meuble = idProduct;
	}
	
	public Type_Meuble[] getType() {
		return  Type_Meuble.values();
	}
	public void setType_meuble(Type_Meuble typem) {
		this.typem = typem;
	}
	
	public Type_Meuble getTypem() {
		return typem;
	}
	public void setTypem(Type_Meuble typem) {
		this.typem = typem;
	}
	public long getRef_meuble() {
		return ref_meuble;
	}
	public void setRef_meuble(long ref_meuble) {
		this.ref_meuble = ref_meuble;
	}
	public long getUpdate() {
		return update;
	}
	public void setUpdate(long update) {
		this.update = update;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public Commande getCmd() {
		return cmd;
	}
	public void setCmd(Commande cmd) {
		this.cmd = cmd;
	}
	public Meubles getM() {
		return m;
	}
public void setM(Meubles m) {
		this.m = m;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void save()

		{ mr.save(m);
        m = new Meubles();
        this.meuble.add(this.m);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Added"));
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
//        return "/DariTn/Meuble.xhtml";
        
       	}
	 public void remove(String ref_meuble) {
		 mc.removeProduct(ref_meuble);
			getM();
	
	    }
	 
		
	public void displayMeuble(Meubles meuble)
	{
	this.setNom_meuble(meuble.getNom_meuble());
	this.setDescription_meuble(meuble.getDescription_meuble());
	this.setTypem(meuble.getType_meuble());
	this.setPrice(meuble.getPrix());
	this.setUpdate(meuble.getRef_meuble());
	}
	public void updateMeuble()
	
	{ ms.updateMeuble(new Meubles(update, nom_meuble, description_meuble, price, typem));
		 }
	public void openNew() {
        this.m = new Meubles();
    }
	
    public void onRowEdit(RowEditEvent<Meubles> event) {
        FacesMessage msg = new FacesMessage("Product Edited", String.valueOf(event.getObject().getRef_meuble()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<Meubles> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", String.valueOf(event.getObject().getRef_meuble()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        
    }
    boolean skip;
    public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}
    public String onFlowProcess(FlowEvent event) {
		
		if(skip) {
			skip = false;	//reset in case user goes back
			return "confirm";
		}
		else {
			return event.getNewStep();
		}
	}
    public void upload() {
    	try{
    		if(file != null){
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/DariTn?user=root&password=");
    		PreparedStatement st= cn.prepareStatement("INSERT INTO Meubles(img) VALUES (?)");
    		st.setBinaryStream(1,file.getInputStream());
    		st.executeUpdate();
    		cn.close();
    		}
    		}
    		catch (Exception e){}
    }
    
    
}
