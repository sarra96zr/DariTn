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
	@Enumerated
	private cam camera;
	@ManyToOne
	Client client;
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
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
	
	public cam getCamera() {
		return camera;
	}
	public void setCamera(cam camera) {
		this.camera = camera;
	}
	
	@Override
	public String toString() {
		return "Surveillance [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ",  camera=" + camera + "]";
	}
	
	public Surveillance(Date dateDebut, Date dateFin, String code, Float prix, cam camera, Client client) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.camera = camera;
		this.client = client;
	}
	public Surveillance( Date dateDebut, Date dateFin,  cam camera, Client client) {
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
	public Surveillance(Long id, cam camera, Date dateDebut, Date dateFin ) {
		super();
		this.id = id;
		this.camera = camera;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		
	}
	public Surveillance(Date dateDebut, Date dateFin, cam camera) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.camera = camera;
	}
	
	
}
