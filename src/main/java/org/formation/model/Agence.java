package org.formation.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 * La classe Agence lui définit les attributs : id, numéro d'agence, date de creation, gerant, adresse et liste de conseillers
 * @author Mathieu et Aurelie
 */

@Entity
public class Agence {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String numAgence;
	private Date dateCreation;
	
	@OneToOne(cascade={ CascadeType.REMOVE})
	@JoinColumn(name="passport_id", unique=true)
	private Gerant gerant;
	
	@Embedded
	private Adresse adresse;
	
	@OneToMany(mappedBy="agence") //,fetch=FetchType.EAGER)
	private Collection<Conseiller> conseillers;
	
	
	
	
	public Agence() {
		super();
	}

	public Agence(String numAgence,Gerant gerant, Adresse adresse,
			Collection<Conseiller> conseillers) {
		super();
		this.numAgence = numAgence;
		this.dateCreation = dateCreation;
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
