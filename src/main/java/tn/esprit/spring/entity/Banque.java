package tn.esprit.spring.entity;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="banque")
public class Banque implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Banque()
	{
		super();
	}
	
	public Banque(String nombanque) 
	{
		super();
		this.nombanque=nombanque;
	}


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id; 
	
	@Column(name="nombanque")
	private String nombanque;
	
	@Column
	private int duration;

	@Column
	private double interestRate;
	

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	public String getNombanque() {
		return nombanque;
	}

	public void setNombanque(String nombanque) {
		this.nombanque = nombanque;
	}





	public Banque(int id, String nombanque, int duration, double interestRate) {
		super();
		this.id = id;
		this.nombanque = nombanque;
		this.duration = duration;
		this.interestRate = interestRate;
	}
	
	

	public Banque(String nombanque, int duration, double interestRate) {
		super();
		this.nombanque = nombanque;
		this.duration = duration;
		this.interestRate = interestRate;
	}

	public Banque(int id, String nombanque) {
		super();
		this.id = id;
		this.nombanque = nombanque;
	}



 

	
	
}
