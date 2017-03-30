package org.formation.model;

public class Gerant extends Personne {
	private Long id;
	private Agence agence;
	
	
	
	public Gerant() {
		super();
	}
	public Gerant(Agence agence) {
		super();
		this.agence = agence;
	}
	public Agence getAgence() {
		return agence;
	}
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Gerant [agence=" + agence + "]";
	}
	
	
	
	
}
