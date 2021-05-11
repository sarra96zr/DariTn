package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;


@Entity
@Table(name="Annonce")
public class Annonce implements Serializable {
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
	    @Column(name="id")
		public long id;
		
		@Column(name="title")
		public String title;
		
		@Column(name="adresse")
		public String adresse;
		
		@Column(name="video")
		public String video;
		
		@Column(name="description")
		public String description;
		
		@Column(name="photo")
		public String photo;
		
		@Column(name="price")
		public float price;
		
		@Enumerated (EnumType.STRING)
		@Column(name="type_annonce")
		public Type_Annonce type_annonce;
		
		/*@OneToMany(mappedBy="Annonce")
	    private Set<RDV> rdv;*/
		
		
		@ManyToOne
		
		public User user;
	

		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
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


		public float getPrice() {
			return price;
		}


		public void setPrice(float price) {
			this.price = price;
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


		public Annonce(long id, String title, String adresse, String video, String description, String photo,
				float price, Type_Annonce type_annonce, User user) {
			super();
			this.id = id;
			this.title = title;
			this.adresse = adresse;
			this.video = video;
			this.description = description;
			this.photo = photo;
			this.price = price;
			this.type_annonce = type_annonce;
			this.user = user;
		}


		
		
	


}
