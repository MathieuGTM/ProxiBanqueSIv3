package org.formation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


/**
 * @author Mathieu et Aurelie
 * La classe CB (carte bancaire) possède les attributs : id, et le type de CB 
 */

@Entity
public class CB {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private TypeCB typeCB;
	
	
	@OneToOne(mappedBy="cb")
	private Client client;


	public CB(TypeCB typeCB) {
		super();
		this.typeCB = typeCB;
	}

	public CB() {
		super();
	}
	
	
	public TypeCB getTypeCB() {
		return typeCB;
	}


	public Long getId() {
		return id;
	}


	public void setTypeCB(TypeCB typeCB) {
		this.typeCB = typeCB;
	}


	@Override
	public String toString() {
		return "CB [typeCB=" + typeCB + "]";
	}

	
	
}
