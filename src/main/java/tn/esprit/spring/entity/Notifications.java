package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="Notifications")
public class Notifications implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_notif")
	private Long idNotif ;
	@Column(name = "titre")
	private String titre;
	@Column(name = "description")
	private String description_notif;
	@Column(name = "etat")
	private String etat;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private  Annonce annonce;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private User user;
//	@OneToOne
//	@JoinColumn(name="Notif_annonces")
//	private Annonce annonces;
	
	public Long getIdNotif() {
		return idNotif;
	}

	public void setIdNotif(Long idNotif) {
		this.idNotif = idNotif;
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

	public Notifications(Long idNotif, String titre, String description_notif, Annonce annonce,
			User user, Annonce annonces) {
		super();
		this.idNotif = idNotif;
		this.titre = titre;
		this.description_notif = description_notif;
		this.annonce = annonce;
		this.user = user;
	}

	



	
	

}
