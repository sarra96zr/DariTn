package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="banque")
public class Banque implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_banque")
	public long id_banque;
	
	@Column(name="nombanque")
	public String nombanque;
	@OneToMany(mappedBy="Banque")
	private Set<Credit> credit;
	@OneToOne
    private Expert_financier exp;
	public long getId_banque() {
		return id_banque;
	}
	public void setId_banque(long id_banque) {
		this.id_banque = id_banque;
	}
	public String getNombanque() {
		return nombanque;
	}
	public void setNombanque(String nombanque) {
		this.nombanque = nombanque;
	}
	public Set<Credit> getCredit() {
		return credit;
	}
	public void setCredit(Set<Credit> credit) {
		this.credit = credit;
	}
	public Expert_financier getExp() {
		return exp;
	}
	public void setExp(Expert_financier exp) {
		this.exp = exp;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Banque() {
		super();
	}
	public Banque(long id_banque, String nombanque, Set<Credit> credit, Expert_financier exp) {
		super();
		this.id_banque = id_banque;
		this.nombanque = nombanque;
		this.credit = credit;
		this.exp = exp;
	}

}
