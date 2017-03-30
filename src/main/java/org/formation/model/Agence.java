package org.formation.model;

import java.util.Collection;
import java.util.Date;

public class Agence {

	private Long id;
	private String numAgence;
	private Date dateCreation;
	private Gerant gerant;
	private Adresse adresse;
	private Collection<Conseiller> conseillers;
	
	
	
	
	public Agence() {
		super();
	}
	public Agence(Date dateCreation, Gerant gerant, Adresse adresse, Collection<Conseiller> conseillers) {
		super();
		this.dateCreation = new Date();
		this.gerant = gerant;
		this.adresse = adresse;
		this.conseillers = conseillers;
	}
	public Gerant getGerant() {
		return gerant;
	}
	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Collection<Conseiller> getConseillers() {
		return conseillers;
	}
	public void setConseillers(Collection<Conseiller> conseillers) {
		this.conseillers = conseillers;
	}
	public Long getId() {
		return id;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	
	
	public String getNumAgence() {
		return numAgence;
	}
	public void setNumAgence(String numAgence) {
		this.numAgence = numAgence;
	}
	@Override
	public String toString() {
		return "Agence [dateCreation=" + dateCreation + ", gerant=" + gerant + ", adresse=" + adresse + ", conseillers="
				+ conseillers + "]";
	}
	
	
	
}
