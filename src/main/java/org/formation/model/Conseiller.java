package org.formation.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conseiller extends Personne {
	

	private int nbClients;
//	private Collection<Client> clients;
	
	
	
	public Conseiller() {
		super();
	}
//	public Conseiller(int nbClients, Collection<Client> clients) {
//		super();
//		this.nbClients = nbClients;
//		this.clients = clients;
//	}
	public int getNbClients() {
		return nbClients;
	}
	public void setNbClients(int nbClients) {
		this.nbClients = nbClients;
	}
//	public Collection<Client> getClients() {
//		return clients;
//	}
//	public void setClients(Collection<Client> clients) {
//		this.clients = clients;
//	}

//	@Override
//	public String toString() {
//		return "Conseiller [nbClients=" + nbClients + ", clients=" + clients + "]";
//	}
	
	
	
}
