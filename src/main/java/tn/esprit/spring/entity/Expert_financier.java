package tn.esprit.spring.entity;

import java.util.Set;

import javax.persistence.*;
@Entity
@Table(name="Expert_financier")
public class Expert_financier extends User {
	private static final long serialVersionUID = 1L;
//	@Id
//	@GeneratedValue (strategy = GenerationType.IDENTITY)
//    @Column(name="id_expert")
//	private int id_expert ;
	@OneToMany
//	@JoinTable(name="T_Expert_Banque", joinColumns={@JoinColumn(name="id_expert")},
//	inverseJoinColumns={@JoinColumn(name="id_banque")})
	private Set<Banque> banque;
//	public int getId_expert() {
//		return id_expert;
//	}
//	public void setId_expert(int id_expert) {
//		this.id_expert = id_expert;
//	}
	public Set<Banque> getBanque() {
		return banque;
	}
	public void setBanque(Set<Banque> banque) {
		this.banque = banque;
	}
	public Expert_financier(int id_expert, Set<Banque> banque) {
		super();
		//this.id_expert = id_expert;
		this.banque = banque;
	}
	public Expert_financier() {
		super();
	}
	
}
