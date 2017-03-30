package org.formation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompteCourant extends CompteBancaire {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
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

	public Long getId() {
		return id;
	}
	
	
}
