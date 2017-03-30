package org.formation.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Gerant extends Personne {
	
	@OneToOne(mappedBy="gerant" , cascade={CascadeType.PERSIST})
	private Agence agence;
	
	
	
	public Gerant() {
		super();
	}
//	public Gerant(Agence agence) {
//		super();
//		this.agence = agence;
//	}
//	public Agence getAgence() {
//		return agence;
//	}
//	public void setAgence(Agence agence) {
//		this.agence = agence;
//	}

//	@Override
//	public String toString() {
//		return "Gerant [agence=" + agence + "]";
//	}
	
	
	
	
}
