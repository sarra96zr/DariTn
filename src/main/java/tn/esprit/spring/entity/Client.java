package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "client")
public class Client extends User implements Serializable {
	private static final long serialVersionUID = 1L;
	//private int id_client ;
	@OneToOne
	@JoinColumn(name="T_Panier_client")
	private Panier panier;
	@OneToMany(mappedBy="client")
	private Set<Abonnement> abonnement;
	@OneToMany(mappedBy="client")
	private Set<Credit> credit;
	@OneToMany(mappedBy="client")
	@JsonIgnore
	private Set<Reclamations> reclam;
	@OneToOne
	@JoinColumn(name="T_RDV_client")
	private RDV rdv;
	@OneToMany(cascade= CascadeType.ALL , mappedBy="client")
	private Set<Meubles> meuble;
	
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	public Set<Abonnement> getAbonnement() {
		return abonnement;
	}
	public void setAbonnement(Set<Abonnement> abonnement) {
		this.abonnement = abonnement;
	}
	public Set<Credit> getCredit() {
		return credit;
	}
	public void setCredit(Set<Credit> credit) {
		this.credit = credit;
	}
	public Set<Reclamations> getReclam() {
		return reclam;
	}
	public void setReclam(Set<Reclamations> reclam) {
		this.reclam = reclam;
	}
	
	
	public RDV getRdv() {
		return rdv;
	}
	public void setRdv(RDV rdv) {
		this.rdv = rdv;
	}
	public Set<Meubles> getMeuble() {
		return meuble;
	}
	public void setMeuble(Set<Meubles> meuble) {
		this.meuble = meuble;
	}
	public Client(Panier panier, Set<Abonnement> abonnement, Set<Credit> credit,
			Set<Reclamations> reclam, RDV rdv, Set<Meubles> meuble) {
		super();
		//this.id_client = id_client;
		this.panier = panier;
		this.abonnement = abonnement;
		this.credit = credit;
		this.reclam = reclam;
		this.rdv = rdv;
		this.meuble = meuble;
	}
	public Client() {
		super();
	}
	
	public void addReclam(Reclamations R)
	{
		this.reclam.add(R);
		R.setClient(this);
	}
	@Override
	public String toString() {
		return "Client [toString()=" + super.toString() + "]";
	}
	
	
 
	
}
