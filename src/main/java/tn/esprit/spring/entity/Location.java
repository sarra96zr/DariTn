package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="Location")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;
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
	
	public static Double calculPrix(Double prix, SimpleDateFormat datedeb, SimpleDateFormat datefin) {
		
		 double prix1;
		 //LocalDate datedebut = datedeb.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		 //LocalDate datefi = datefin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	        final long MILLISECONDS_PER_DAY = 1000 * 60 * 60 * 24; 

	        return prix1= ((prix/31)*(datefin.getCalendar().compareTo(datedeb.getCalendar())))/ (MILLISECONDS_PER_DAY);
	           
	}
	public Location(Date dateDebut, Date dateFin, Double prixLocation, User user, Annonce annonce) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prixLocation = prixLocation;
		this.user = user;
		this.annonce = annonce;
	}
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Location(long id, Date dateDebut, Date dateFin, Double prixLocation, User user, Annonce annonce) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prixLocation = prixLocation;
		this.user = user;
		this.annonce = annonce;
	}

	
}