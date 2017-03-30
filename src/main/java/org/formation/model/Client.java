package org.formation.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author adminl
 *
 */
@Entity
@ManagedBean(name="client")
public class Client extends Personne implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nom2;
	
	public String getNom2() {
		return nom2;
	}

	public void setNom2(String nom2) {
		this.nom2 = nom2;
	}



	@Embedded
	private Adresse adresse;
	private boolean clientFortune;
	private TypeClient typeClient;
	
	@OneToOne
	@JoinColumn(name="comptecourant_id", unique=true)
	private CompteCourant compteCourant;
	
	@OneToOne
	@JoinColumn(name="compteepargne_id", unique=true)
	private CompteEpargne compteEpargne;
	
	@ManyToOne
	@JoinColumn(name="conseiller_id")
	private Conseiller conseiller;
	
	@OneToOne
	@JoinColumn(name="cb_id", unique=true)
	private CB cb;
	
	
	
	
	
	public Conseiller getConseiller() {
		return conseiller;
	}



	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}



	public Client() {
		super();
	}
	

	
	public Client(String nom, String prenom, String telephone) {
		super(nom, prenom, telephone);
	}



	public Client(Adresse adresse, boolean clientFortune, TypeClient typeClient, CompteCourant compteCourant,
			CompteEpargne compteEpargne, Conseiller conseiller, CB cb) {
		super();
		this.adresse = adresse;
		this.clientFortune = clientFortune;
		this.typeClient = typeClient;
		this.compteCourant = compteCourant;
		this.compteEpargne = compteEpargne;
		this.conseiller = conseiller;
		this.cb = cb;
	}



	public CB getCb() {
		return cb;
	}
	public void setCb(CB cb) {
		this.cb = cb;
	}
	
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
	public CompteCourant getCompteCourant() {
		return compteCourant;
	}
	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}
	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}
	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}



	@Override
	public String toString() {
		return "Client [adresse=" + adresse + ", clientFortune=" + clientFortune + ", typeClient=" + typeClient
				+ ", compteCourant=" + compteCourant + ", compteEpargne=" + compteEpargne + ", conseiller=" + conseiller
				+ ", cb=" + cb + "]";
	}

	
	
	
	
}
