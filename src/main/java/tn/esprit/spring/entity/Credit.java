package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="credit")
public class Credit implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_credit")
	public long id_credit;
	
	@Column(name="montant")
	public float montant;
	
	@Column(name="salaire")
	public float salaire;
	
	@Column(name="TMM")
	public float TMM;
	
	@Column(name="apport_personnel")
	public float apport_personnel;
	
	@Column(name="D_de_remboursement")
	public String D_remboursement;
	@ManyToOne
	
	Banque Banque;
	@ManyToOne
	
	Client client;
	public long getId_credit() {
		return id_credit;
	}
	public void setId_credit(long id_credit) {
		this.id_credit = id_credit;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public float getSalaire() {
		return salaire;
	}
	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}
	public float getTMM() {
		return TMM;
	}
	public void setTMM(float tMM) {
		TMM = tMM;
	}
	public float getApport_personnel() {
		return apport_personnel;
	}
	public void setApport_personnel(float apport_personnel) {
		this.apport_personnel = apport_personnel;
	}
	public String getD_remboursement() {
		return D_remboursement;
	}
	public void setD_remboursement(String d_remboursement) {
		D_remboursement = d_remboursement;
	}
	public Banque getBanque() {
		return Banque;
	}
	public void setBanque(Banque banque) {
		Banque = banque;
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

	public Credit(long id_credit, float montant, float salaire, float tMM, float apport_personnel,
			String d_remboursement, tn.esprit.spring.entity.Banque banque, Client client) {
		super();
		this.id_credit = id_credit;
		this.montant = montant;
		this.salaire = salaire;
		TMM = tMM;
		this.apport_personnel = apport_personnel;
		D_remboursement = d_remboursement;
		Banque = banque;
		this.client = client;
	}
	public Credit() {
		super();
	}
	

	

	


	

}
