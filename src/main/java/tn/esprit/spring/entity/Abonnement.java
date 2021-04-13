package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "abonnement")
public class Abonnement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_abonnement")
	public long id;

	@Column(name = "contrat")
	public String contrat;

	@Column(name = "date_debut")
	public Date date_debut;

	@Column(name = "date_fin")
	public Date date_fin;

	@ManyToOne
	
	 public Client client;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContrat() {
		return contrat;
	}

	public void setContrat(String contrat) {
		this.contrat = contrat;
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

	public Abonnement(long id, String contrat, Date date_debut, Date date_fin, Client client) {
		super();
		this.id = id;
		this.contrat = contrat;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.client = client;
	}

	public Abonnement() {
		super();
	}

}
