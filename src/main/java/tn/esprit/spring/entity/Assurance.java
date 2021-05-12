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
@Table(name= "Abonnement_assurance")
public class Assurance {
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
	@Column(name="nom_assurance")
	@Enumerated(EnumType.STRING)
	Assur assur;
	@ManyToOne
	Client client;
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
	

	
	
	public Assur getAssur() {
		return assur;
	}
	public void setAssur(Assur assur) {
		this.assur = assur;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@Override
	public String toString() {
		return "Assurance [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", entreprise=" + assur + ", user=" + client + "]";
	}
	
	public Assurance(Date dateDebut, Date dateFin, Assur assur, Client client) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.assur = assur;
		this.client = client;
	}
	public Assurance(Long id, Date dateDebut, Date dateFin, Assur assur, Client client) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.assur = assur;
		this.client = client;
	}
	public Assurance() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Assurance(Long id, Date dateDebut, Date dateFin, Assur assur) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.assur = assur;
	}
	public Assurance(Date dateDebut, Date dateFin, Assur assur) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.assur = assur;
	}
	
	
	
	
}
