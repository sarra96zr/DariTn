package tn.esprit.spring.controller;



import java.util.List;

import javax.annotation.ManagedBean;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

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
@Join(path = "/DariTn/meuble", to = "/Meuble.jsf")

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

	//private String picture;
	private String description_meuble;
	private float price;
	private List<Meubles> meuble;
	private long ref_meuble;
	private int idlc;
	private int qte;
	private Commande cmd;
	private Meubles m=new Meubles();
	private Client client;
	
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
	public int getIdlc() {
		return idlc;
	}
	public void setIdlc(int idlc) {
		this.idlc = idlc;
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
	public void removeProduct( String id_m) {
		MeubleService.deleteMeubles(id_m);

	}
	public String save()

		{ mr.save(m);
        m = new Meubles();
        return "/DariTn/Ajout_meuble.xhtml";
    
	
		}}
