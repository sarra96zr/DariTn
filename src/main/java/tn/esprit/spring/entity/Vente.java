package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="Vente")
public class Vente implements Serializable{

	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
	public long id;

	
	@Column(name="prixVente")
	public Double prixVente;
	

	
	@OneToOne
	private User user;
	@OneToOne
	private Annonce annonce;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Double getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(Double prixVente) {
		this.prixVente = prixVente;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Annonce getAnnonce() {
		return annonce;
	}
	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
	public Vente(long id, Double prixVente, User user, Annonce annonce) {
		super();
		this.id = id;
		this.prixVente = prixVente;
		this.user = user;
		this.annonce = annonce;
	}
	public Vente(Double prixVente, User user, Annonce annonce) {
		super();
		this.prixVente = prixVente;
		this.user = user;
		this.annonce = annonce;
	}
	public Vente() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
}
