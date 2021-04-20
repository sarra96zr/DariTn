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
@Table(name="Location")
public class Location implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
	public long id;

	@Column(name="dateDebut")
	public Date dateDebut;
	@Column(name="dateFin")
	public Date dateFin;
	@Column(name="prixLocation")
	public Double prixLocation;
	
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
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Double getPrixLocation() {
		return prixLocation;
	}
	public void setPrixLocation(Double prixLocation) {
		this.prixLocation = prixLocation;
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
	public Location(Date dateDebut, Date dateFin, Double prixLocation, User user, Annonce annonce) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prixLocation = prixLocation;
		this.user = user;
		this.annonce = annonce;
	}
	
	
	
}
