package org.formation.model;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Personne {

	private String nom, prenom, telephone;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;
	
	
	
	public Long getId() {
		return id;
	}

	public Personne() {
		super();
	}

	public Personne(String nom, String prenom, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + "]";
	}
	
	
	
	
	
	
}
