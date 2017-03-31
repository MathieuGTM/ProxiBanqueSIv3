package org.formation.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author adminl
 * La classe conseiller etend la classe Personne et ajoute les attributs : nombre de clients, une collection de clients et une Agence
 */


@Entity
public class Conseiller extends Personne {
	

	private int nbClients;
	
	@OneToMany(mappedBy="conseiller", cascade= {CascadeType.PERSIST}) //,fetch=FetchType.EAGER)
	private Collection<Client> clients;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name="agence_id")
	private Agence agence;
	
	
	public Conseiller() {
		super();
	}
	public Conseiller(int nbClients, Collection<Client> clients) {
		super();
		this.nbClients = nbClients;
		this.clients = clients;
	}
	public int getNbClients() {
		return nbClients;
	}
	public void setNbClients(int nbClients) {
		this.nbClients = nbClients;
	}
	public Collection<Client> getClients() {
		return clients;
	}
	public void setClients(Collection<Client> clients) {
		this.clients = clients;
		nbClients += 1;
	}
	public Agence getAgence() {
		return agence;
	}
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	
	

	@Override
	public String toString() {
		return "Conseiller [nbClients=" + nbClients + ", clients=" + clients + "]";
	}
	
	
	
}
