package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.esprit.spring.entity.Meubles;
import tn.esprit.spring.entity.Panier;

@Entity
@Table(name="Orders")
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_order")
	
	private long id_order;
	
	private String  Statut;
	
	private float price_order;
	
	@Temporal (TemporalType.DATE)
	private Date date_order;
	
	@ManyToOne
	private Meubles m;
	
	@ManyToMany( cascade = CascadeType.ALL)
	private Set<Meubles> meuble;
	
	@ManyToOne
	private Panier Panier;
	public long getId_order() {
		return id_order;
	}
	
	public void setId_order(long id_order) {
		this.id_order = id_order;
	}
	public String getStatut() {
		return Statut;
	}
	public void setStatut(String statut) {
		Statut = statut;
	}
	public float getPrice_order() {
		return price_order;
	}
	public void setPrice_order(float price_order) {
		this.price_order = price_order;
	}
	public Date getDate_order() {
		return date_order;
	}
	public void setDate_order(Date date_order) {
		this.date_order = date_order;
	}
	public Set<Meubles> getMeuble() {
		return meuble;
	}
	public void setMeuble(Set<Meubles> meuble) {
		this.meuble = meuble;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Panier getPanier() {
		return Panier;
	}

	public void setPanier(Panier panier) {
		Panier = panier;
	}

	public Meubles getM() {
		return m;
	}

	public void setM(Meubles m) {
		this.m = m;
	}

	public Commande(long id_order, String statut, float price_order, Date date_order, Meubles m,
			tn.esprit.spring.entity.Panier panier) {
		super();
		this.id_order = id_order;
		Statut = statut;
		this.price_order = price_order;
		this.date_order = date_order;
		this.m = m;
		Panier = panier;
	}

	public Commande() {
		super();
	}
	
	

	
}
