package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;



import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name="Annonce")
public class Annonce implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
	public long id;
	
	@Column(name="titre")
	public String titre;
	
	@Column(name="adresse")
	public String adresse;
	
	@Column(name="video")
	public String video;
	
	@Column(name="description")
	public String description;
	
	@Column(name="photo")
	public String photo;
	
	@Column(name="prix")
	public Double prix;
	
	@Column(name="rating")
	public int rating;
	
	@Column(name="surface")
	public Double surface;
	
	
	@Enumerated (EnumType.STRING)
	@Column(name="disponible")
	public Disponible disponible;
	
	@Enumerated (EnumType.STRING)
	@Column(name="type_annonce")
	public Type_Annonce type_annonce;
	
	
	@Enumerated (EnumType.STRING)
	@Column(name="categorie_annonce")
	public Categorie_Annonce categorie_annonce;
	
	@ManyToOne
	
	public User user;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public Double getPrix() {
		return prix;
	}


	public void setPrix(Double prix) {
		this.prix = prix;
	}





	public Disponible getDisponible() {
		return disponible;
	}


	public void setDisponible(Disponible disponible) {
		this.disponible = disponible;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getVideo() {
		return video;
	}


	public void setVideo(String video) {
		this.video = video;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	


	


	public Double getSurface() {
		return surface;
	}


	public void setSurface(Double surface) {
		this.surface = surface;
	}


	public Type_Annonce getType_annonce() {
		return type_annonce;
	}


	public void setType_annonce(Type_Annonce type_annonce) {
		this.type_annonce = type_annonce;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Annonce() {
		super();
	}


	public Categorie_Annonce getCategorie_annonce() {
		return categorie_annonce;
	}


	public void setCategorie_annonce(Categorie_Annonce categorie_annonce) {
		this.categorie_annonce = categorie_annonce;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public Annonce(long id, String titre, String adresse, String video, String description, String photo, Double prix,
			int rating, Double surface, Disponible disponible, Type_Annonce type_annonce,
			Categorie_Annonce categorie_annonce, User user) {
		super();
		this.id = id;
		this.titre = titre;
		this.adresse = adresse;
		this.video = video;
		this.description = description;
		this.photo = photo;
		this.prix = prix;
		this.rating = rating;
		this.surface = surface;
		this.disponible = disponible;
		this.type_annonce = type_annonce;
		this.categorie_annonce = categorie_annonce;
		this.user = user;
	}


	public Annonce(String titre, String adresse, String video, String description, String photo, Double prix,
			int rating, Double surface, Disponible disponible, Type_Annonce type_annonce,
			Categorie_Annonce categorie_annonce, User user) {
		super();
		this.titre = titre;
		this.adresse = adresse;
		this.video = video;
		this.description = description;
		this.photo = photo;
		this.prix = prix;
		this.rating = rating;
		this.surface = surface;
		this.disponible = disponible;
		this.type_annonce = type_annonce;
		this.categorie_annonce = categorie_annonce;
		this.user = user;
	}


	

	
	
		
	


}
