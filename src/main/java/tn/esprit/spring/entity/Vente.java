package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="Vente")
public class Vente implements Serializable{

	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
	public long id;

	
	@Column(name="prixLocation")
	public float prixLocation;
	@Column(name="surface_m2")
	public float surface;
	
	@OneToOne
	private User user;
	@OneToOne
	private Annonce annonce;
}
