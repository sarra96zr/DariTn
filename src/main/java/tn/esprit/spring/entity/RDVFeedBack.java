package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="RDVFeedBack")
public class RDVFeedBack implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_rdv_feedback")
	public long id;
	
	@Column(name="descRDV")
	public String descRDV;
	
	@OneToOne(mappedBy="RDVF")
	private RDV rdv;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescRDV() {
		return descRDV;
	}

	public void setDescRDV(String descRDV) {
		this.descRDV = descRDV;
	}

	public RDV getRdv() {
		return rdv;
	}

	public void setRdv(RDV rdv) {
		this.rdv = rdv;
	}

	public RDVFeedBack(long id, String descRDV, RDV rdv) {
		super();
		this.id = id;
		this.descRDV = descRDV;
		this.rdv = rdv;
	}

	public RDVFeedBack() {
		super();
	}
	
}
