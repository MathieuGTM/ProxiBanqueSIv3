package org.formation.model;

public class CB {
	
	private TypeCB typeCB;

	public TypeCB getTypeCB() {
		return typeCB;
	}

	public void setTypeCB(TypeCB typeCB) {
		this.typeCB = typeCB;
	}

	public CB(TypeCB typeCB) {
		super();
		this.typeCB = typeCB;
	}

	public CB() {
		super();
	}

	@Override
	public String toString() {
		return "CB [typeCB=" + typeCB + "]";
	}

	
	
}
