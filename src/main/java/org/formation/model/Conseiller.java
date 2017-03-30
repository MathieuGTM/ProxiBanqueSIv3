package org.formation.model;

import java.util.Collection;

public class Conseiller extends Personne {

	private Long id;
	private int nbClients;
	private Collection<Client> clients;
	
	
	
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
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Conseiller [nbClients=" + nbClients + ", clients=" + clients + "]";
	}
	
	
	
}
