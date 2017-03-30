package org.formation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompteEpargne extends CompteBancaire {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private double taux = 0.03;

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

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "CompteEpargne [taux=" + taux + "]";
	}
	
	
	
}
