package tn.esprit.spring.entity;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name="credit")
public class Credit implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Credit()
	{
		super();
	}
	
	public Credit(Client client, CreditFormula creditformula, float initialamount, float monthly) 
	{
		super();
		this.client=client;
		this.creditformula=creditformula;
		this.initialamount = initialamount;
		this.monthly=monthly;
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id; 
	
	@Column(name="initialamount")
	private float initialamount;
	
	@Column(name="finalamount")
	private float finalamount;
	
	@Column
	private float monthly;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Client client;
	
	@OneToOne
	private CreditFormula creditformula;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	@JsonBackReference(value="credits-client")
	public User getClient() {
		return client;
	}

	public void setClient(Client C) {
		this.client=C;
	}

	public CreditFormula getCreditformula() {
		return creditformula;
	}

	public void setCreditformula(CreditFormula creditformula) {
		this.creditformula = creditformula;
	}

	public float getMonthly() {
		return monthly;
	}

	public void setMonthly(float monthly) {
		this.monthly = monthly;
	}
	
	public float getInitialamount() {
		return initialamount;
	}

	public void setInitialamount(float initialamount) {
		this.initialamount = initialamount;
	}

	public float getFinalamount() {
		return finalamount;
	}

	public void setFinalamount(float finalamount) {
		this.finalamount = finalamount;
	}

	@Override
	public String toString() {
		return "Credit [id=" + id + ", initialamount=" + initialamount + ", finalamount=" + finalamount + ", monthly="
				+ monthly + ", client=" + client + ", creditformula=" + creditformula.getId() + "]";
	}
}