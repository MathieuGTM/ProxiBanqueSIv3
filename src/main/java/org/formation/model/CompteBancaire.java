package org.formation.model;

import java.util.Date;

public abstract class CompteBancaire {

	private Long id;
	private Date dateCreation;
	private double solde = 0.0;
	private CB cb;
	
	
	
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
		this.cb = cb;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public CB getCb() {
		return cb;
	}
	public void setCb(CB cb) {
		this.cb = cb;
	}
	public Long getId() {
		return id;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	
	
	
	
}
