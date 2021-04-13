package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.*;
@Entity
@Table(name="Notifications")
public class Notifications implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ref")
	public int idNotif ;
	@Column(name = "dateNotif")
	public String dateNotif;
	@Column(name = "titre")
	public String titre;
	@Column(name = "description")
	public String description_notif;
	@ManyToOne(cascade = CascadeType.ALL)
	Annonce annonce;
	@ManyToOne(cascade = CascadeType.ALL)
	User user;
	@OneToOne
//	@JoinColumn(name="Notif_annonces")
	private Annonce annonces;
	
	public Annonce getAnnonces() {
		return annonces;
	}

	public void setAnnonces(Annonce annonces) {
		this.annonces = annonces;
	}

	public int getIdNotif() {
		return idNotif;
	}

	public void setIdNotif(int idNotif) {
		this.idNotif = idNotif;
	}

	public String getDateNotif() {
		return dateNotif;
	}

	public void setDateNotif(String dateNotif) {
		this.dateNotif = dateNotif;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription_notif() {
		return description_notif;
	}

	public void setDescription_notif(String description_notif) {
		this.description_notif = description_notif;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Notifications() {
		super();
	}

	public Notifications(int idNotif, String dateNotif, String titre, String description_notif, Annonce annonce,
			User user, Annonce annonces) {
		super();
		this.idNotif = idNotif;
		this.dateNotif = dateNotif;
		this.titre = titre;
		this.description_notif = description_notif;
		this.annonce = annonce;
		this.user = user;
		this.annonces = annonces;
	}

	



	
	

}
