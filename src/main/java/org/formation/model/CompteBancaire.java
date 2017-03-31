package org.formation.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;


/**
 * @author adminl
 * La classe abstraite compteBancaire definit les attributs : idCompte, solde et date de creation
 */


@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class CompteBancaire {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;
	private Date dateCreation;
	private double solde = 0.0;
	

	
	
	
	@Override
	public String toString() {
		return "CompteBancaire [dateCreation=" + dateCreation + ", solde=" + solde + "]";
	}
	public CompteBancaire() {
		super();
	}
	public CompteBancaire(Date dateCreation, double solde, CB cb) {
		super();
		this.dateCreation =  new Date();
		this.solde = solde;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Long getId() {
		return id;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	
	
	
	
}
