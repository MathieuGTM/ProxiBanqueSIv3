package org.formation.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;


/**
 * @author adminl
 * La classe CompteCourant étend la classe compteBancaire et lui ajoute l'attribut : decouvert (1000 par défaut) et un client
 */

@Entity
public class CompteCourant extends CompteBancaire {


	private double decouvert = 1000.0;

	@OneToOne(mappedBy="compteCourant")
	private Client client;
	 
	


	@Override
	public String toString() {
		return "CompteCourant [decouvert=" + decouvert + ", client=" + client + "]";
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


}
