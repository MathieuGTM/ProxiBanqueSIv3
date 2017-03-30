package org.formation.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

/**
 * @author adminl
 *
 */
@Entity
@DiscriminatorValue(value = "Client")
public class Client extends Personne implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Embedded
	private Adresse adresse;
	private boolean clientFortune;
	private TypeClient typeClient;
//	private CompteCourant compteCourant;
//	private CompteEpargne compteEpargne;
	
	
	
	
	public Client() {
		super();
	}
	

	
	public Client(String nom, String prenom, String telephone) {
		super(nom, prenom, telephone);
	}



//	public Client(Adresse adresse, boolean clientFortune, TypeClient typeClient, CompteCourant compteCourant,
//			CompteEpargne compteEpargne) {
//		super();
//		this.adresse = adresse;
//		this.clientFortune = clientFortune;
//		this.typeClient = typeClient;
//		this.compteCourant = compteCourant;
//		this.compteEpargne = compteEpargne;
//	}
	
	
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public boolean isClientFortune() {
		return clientFortune;
	}
	public void setClientFortune(boolean clientFortune) {
		this.clientFortune = clientFortune;
	}
	public TypeClient getTypeClient() {
		return typeClient;
	}
	public void setTypeClient(TypeClient typeClient) {
		this.typeClient = typeClient;
	}
//	public CompteCourant getCompteCourant() {
//		return compteCourant;
//	}
//	public void setCompteCourant(CompteCourant compteCourant) {
//		this.compteCourant = compteCourant;
//	}
//	public CompteEpargne getCompteEpargne() {
//		return compteEpargne;
//	}
//	public void setCompteEpargne(CompteEpargne compteEpargne) {
//		this.compteEpargne = compteEpargne;
//	}
//	public Long getId() {
//		return id;
//	}
	
//	@Override
//	public String toString() {
//		return "Client [adresse=" + adresse + ", clientFortune=" + clientFortune + ", typeClient=" + typeClient
//				+ ", compteCourant=" + compteCourant + ", compteEpargne=" + compteEpargne + "]";
//	}
	
	
	
}
