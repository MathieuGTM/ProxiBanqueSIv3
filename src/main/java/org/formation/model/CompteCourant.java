package org.formation.model;

public class CompteCourant extends CompteBancaire {

	private double decouvert = 1000.0;

	 
	
	@Override
	public String toString() {
		return "CompteCourant [decouvert=" + decouvert + "]";
	}

	public CompteCourant(double decouvert) {
		super();
		this.decouvert = decouvert;
	}

	public CompteCourant() {
		super();
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
	
}
