package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;
@Entity
public class Panier implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_panier ;
	@Temporal (TemporalType.DATE)
	private Date date_basket ;
	private float prix_total ;
	@Enumerated(EnumType.STRING)
	private Paiement type_paiement;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Panier")
    private Set<Commande> commande;
	
	
	public Panier() {
		super();
	}


	public long getId_panier() {
		return id_panier;
	}


	public void setId_panier(long id_panier) {
		this.id_panier = id_panier;
	}


	public Date getDate_basket() {
		return date_basket;
	}


	public void setDate_basket(Date date_basket) {
		this.date_basket = date_basket;
	}


	public float getPrix_total() {
		return prix_total;
	}


	public void setPrix_total(float prix_total) {
		this.prix_total = prix_total;
	}


	public Paiement getType_paiement() {
		return type_paiement;
	}


	public void setType_paiement(Paiement type_paiement) {
		this.type_paiement = type_paiement;
	}


	public Set<Commande> getCommande() {
		return commande;
	}


	public void setCommande(Set<Commande> commande) {
		this.commande = commande;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Panier(long id_panier, Date date_basket, float prix_total, Paiement type_paiement, Set<Commande> commande) {
		super();
		this.id_panier = id_panier;
		this.date_basket = date_basket;
		this.prix_total = prix_total;
		this.type_paiement = type_paiement;
		this.commande = commande;
	}
	
	
	
	

}
