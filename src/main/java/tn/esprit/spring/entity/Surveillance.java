package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name= "Abonnement_de_surveillance")
public class Surveillance {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Temporal(TemporalType.DATE)
	@Column(name="Date_début")
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	@Column(name="Date_fin")
	private Date dateFin;
	@Column(name="Prix")
	private Float prix;
	@Column(name="nombre_de_cameras")
	private Long camera;
	@ManyToOne
	User client;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public Float getPrix() {
		return prix;
	}
	public void setPrix(Float prix) {
		this.prix = prix;
	}
	public Long getCamera() {
		return camera;
	}
	public void setCamera(Long camera) {
		this.camera = camera;
	}
	
	@Override
	public String toString() {
		return "Surveillance [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", prix=" + prix + ", camera=" + camera + "]";
	}
	
	public Surveillance(Date dateDebut, Date dateFin, String code, Float prix, Long camera, Client client) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prix = prix;
		this.camera = camera;
		this.client = client;
	}
	public Surveillance( Date dateDebut, Date dateFin, String code,  Long camera, Client client) {
		super();
		
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.camera = camera;
		this.client = client;
	}
	public Surveillance() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
