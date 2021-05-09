package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "abonnement")
public class Abonnement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_abonnement")
	public long id;
	@Enumerated
	private Aonnement type;

	public Aonnement getType() {
		return type;
	}

	public void setType(Aonnement type) {
		this.type = type;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_debut")
	@JsonFormat(pattern = "dd-MM-yyyy")
	public Date date_debut;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_fin")
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date date_fin;


	@ManyToOne
	@JsonIgnore
	 public Client client;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	public Abonnement(long id, Aonnement type, Date date_debut, Date date_fin, Client client) {
		super();
		this.id = id;
		this.type = type;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.client = client;
	}

	public Abonnement() {
		super();
	}

	public Abonnement(Date date_debut, Date date_fin, Aonnement type) {
		// TODO Auto-generated constructor stub
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.type = type;
	}

}
