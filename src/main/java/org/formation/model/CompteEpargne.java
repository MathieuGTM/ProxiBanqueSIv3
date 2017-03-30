package org.formation.model;

public class CompteEpargne extends CompteBancaire {

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

	@Override
	public String toString() {
		return "CompteEpargne [taux=" + taux + "]";
	}
	
	
	
}
