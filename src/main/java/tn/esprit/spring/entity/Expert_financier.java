package tn.esprit.spring.entity;



import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.*;
@Entity
public class Expert_financier extends User implements Serializable {



		private static final long serialVersionUID = 1L;
		
		@OneToOne
		private Banque bank;

		private String refBA;

		public String getRefBA() {
			return refBA;
		}

		public void setRefBA(String refBA) {
			this.refBA = refBA;
		}

		public Banque getBank() {
			return bank;
		}

		public void setBank(Banque bank) {
			this.bank = bank;
		}	
	}
