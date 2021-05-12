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
	

	@OneToMany(mappedBy="bank", cascade = CascadeType.ALL, orphanRemoval = true)
	List<CreditFormula> creditformulas=new ArrayList<CreditFormula>();
	
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



	public void addFormula(CreditFormula F) {
        creditformulas.add(F);
        F.setBank(this);
    }

	public Banque(int id, String nombanque) {
		super();
		this.id = id;
		this.nombanque = nombanque;
	}



 

	
	
}
