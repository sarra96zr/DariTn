package tn.esprit.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name="Reclamations")
public class Reclamations {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public long id_reclam;
	@Column(name="titre_Reclam")
	public String titreReclam;
	@Column(name="description_Reclam")
	public String descriptionReclam;
	@Enumerated(EnumType.STRING)
    private Type_Rec type;
	@ManyToOne(cascade = CascadeType.ALL)
	Client client;
	
	@JsonBackReference(value="reclamations-client")
	public User getClient() {
		return client;
	}
	
	public long getId_reclam() {
		return id_reclam;
	}
	public void setId_reclam(long id_reclam) {
		this.id_reclam = id_reclam;
	}
	public String getTitreReclam() {
		return titreReclam;
	}
	public void setTitreReclam(String titreReclam) {
		this.titreReclam = titreReclam;
	}
	public String getDescriptionReclam() {
		return descriptionReclam;
	}
	public void setDescriptionReclam(String descriptionReclam) {
		this.descriptionReclam = descriptionReclam;
	}
	
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Type_Rec getType() {
		return type;
	}
	public void setType(Type_Rec type) {
		this.type = type;
	}
	
	public Reclamations(long id_reclam, String titreReclam, String descriptionReclam, Type_Rec type, Client client) {
		super();
		this.id_reclam = id_reclam;
		this.titreReclam = titreReclam;
		this.descriptionReclam = descriptionReclam;
		this.type = type;
		this.client = client;
	}
	
	public Reclamations(String titreReclam, String descriptionReclam, Type_Rec type, Client client) {
		super();
		this.titreReclam = titreReclam;
		this.descriptionReclam = descriptionReclam;
		this.type = type;
		this.client = client;
	}
	
	public Reclamations() {
		super();
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
