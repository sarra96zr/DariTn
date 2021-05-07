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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Meuble")
public class Meubles implements Serializable {
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ref_meuble")
	public Long ref_meuble;
	@JsonIgnore
	@Column(name = "nom_meuble")
	public String Nom_meuble;
	@JsonIgnore
	@Column(name = "des_meuble")
	public String Description_meuble;
	@Column(name = "prix")
	public float prix;
	@JsonIgnore
	@Enumerated(EnumType.STRING)
	private Type_Meuble type_meuble;
	@JsonIgnore
	@ManyToOne
	Client client;
	@JsonIgnore
	@ManyToMany(mappedBy="meuble", cascade = CascadeType.ALL)
	private Set<Commande> commande;
	
	public Meubles(String nom_meuble, String description_meuble, float prix, Type_Meuble type_meuble) {
		super();
		Nom_meuble = nom_meuble;
		Description_meuble = description_meuble;
		this.prix = prix;
		this.type_meuble = type_meuble;
	}

	public Meubles() {
		super();
	}

	public Meubles(Long ref_meuble, String nom_meuble, String description_meuble, float prix, Type_Meuble type_meuble,
			Client client, Set<Commande> commande) {
		super();
		this.ref_meuble = ref_meuble;
		Nom_meuble = nom_meuble;
		Description_meuble = description_meuble;
		this.prix = prix;
		this.type_meuble = type_meuble;
		this.client = client;
		this.commande = commande;
	}

	public Long getRef_meuble() {
		return ref_meuble;
	}

	public void setRef_meuble(long ref_meuble) {
		this.ref_meuble = ref_meuble;
	}

	public String getNom_meuble() {
		return Nom_meuble;
	}

	public void setNom_meuble(String nom_meuble) {
		Nom_meuble = nom_meuble;
	}

	public String getDescription_meuble() {
		return Description_meuble;
	}

	public void setDescription_meuble(String description_meuble) {
		Description_meuble = description_meuble;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Type_Meuble getType_meuble() {
		return type_meuble;
	}

	public void setType_meuble(Type_Meuble type_meuble) {
		this.type_meuble = type_meuble;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Commande> getCommande() {
		return commande;
	}

	public void setCommande(Set<Commande> commande) {
		this.commande = commande;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Meubles(Long ref_meuble, String nom_meuble, String description_meuble, float prix, Type_Meuble type_meuble) {
		super();
		this.ref_meuble = ref_meuble;
		Nom_meuble = nom_meuble;
		Description_meuble = description_meuble;
		this.prix = prix;
		this.type_meuble = type_meuble;
	}

}
