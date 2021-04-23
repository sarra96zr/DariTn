package tn.esprit.spring.entity;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
	private List<Credit> credits;
	@OneToMany(mappedBy="client")
	private Set<Reclamations> reclam;
	@OneToOne
	@JoinColumn(name="T_RDV_client")
	private RDV rdv;
	@OneToMany(cascade= CascadeType.ALL , mappedBy="client")
	private Set<Meubles> meuble;
//	public int getId_client() {
//		return id_client;
//	}
//	public void setId_client(int id_client) {
//		this.id_client = id_client;
//	}
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

	public void setCredits(List<Credit> credits) {
		this.credits = credits;
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

	public Client(long id_user, String firstName, String lastName, String email, String password,
			Date date_de_naissance, Set<Annonce> annonces, Set<Notifications> notifications, Panier panier,
			Set<Abonnement> abonnement, List<Credit> credits, Set<Reclamations> reclam, RDV rdv, Set<Meubles> meuble) {
		super(id_user, firstName, lastName, email, password, date_de_naissance, annonces, notifications);
		this.panier = panier;
		this.abonnement = abonnement;
		this.credits = credits;
		this.reclam = reclam;
		this.rdv = rdv;
		this.meuble = meuble;
	}
	public Client() {
		super();
	}
	
	@JsonManagedReference(value="credit-client")
	public List<Credit> getCredits() {
		return credits;
	}

	public void setCredit(List<Credit> credits) {
		this.credits = credits;
	}
	public void addcredit(Credit C)
	{
		this.credits.add(C);
		C.setClient(this);
	}
	
	@JsonManagedReference(value="credit-client")
	public List<Credit> getCredit() {
		return credits;
	}

	
}
