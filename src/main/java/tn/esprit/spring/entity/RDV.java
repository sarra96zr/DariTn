package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="RDV")
public class RDV implements Serializable{
private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
	public long id_rdv;
	
	
	
	@Column(name="dateRDV")
	public Date dateRDV;
	

	@OneToOne(mappedBy="rdv")
	private Client client;
	
	/*@ManyToOne
	@JoinColumn(name="Annonce_id")
	private Annonce annonce;*/
	
	@OneToOne
	private RDVFeedBack RDVF;

	public long getId_rdv() {
		return id_rdv;
	}

	public void setId_rdv(long id_rdv) {
		this.id_rdv = id_rdv;
	}

	

	public Date getDateRDV() {
		return dateRDV;
	}

	public void setDateRDV(Date dateRDV) {
		this.dateRDV = dateRDV;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public RDVFeedBack getRDVF() {
		return RDVF;
	}

	public void setRDVF(RDVFeedBack rDVF) {
		RDVF = rDVF;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public RDV(long id_rdv,  Date dateRDV, Client client, RDVFeedBack rDVF ) {
		super();
		this.id_rdv = id_rdv;	
		this.dateRDV = dateRDV;
		this.client = client;
		RDVF = rDVF;
	}

	public RDV( Date dateRDV) {
		super();
		
		this.dateRDV = dateRDV;
	}
	
	public RDV() {
		super();
	}
	
}
