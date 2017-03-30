package org.formation.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class CompteEpargne extends CompteBancaire {


	private double taux = 0.03;
	
	@OneToOne(mappedBy="compteEpargne")
	private Client client;

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public CompteEpargne(double taux) {
		super();
		this.taux = taux;
	}

	public CompteEpargne() {
		super();
	}



	@Override
	public String toString() {
		return "CompteEpargne [taux=" + taux + "]";
	}
	
	
	
}
