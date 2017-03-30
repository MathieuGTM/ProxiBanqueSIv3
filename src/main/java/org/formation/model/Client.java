package org.formation.model;

/**
 * @author adminl
 *
 */
public class Client extends Personne {

	private Long id;
	private Adresse adresse;
	private boolean clientFortune;
	private TypeClient typeClient;
	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;
	
	
	
	
	public Client() {
		super();
	}
	public Client(Adresse adresse, boolean clientFortune, TypeClient typeClient, CompteCourant compteCourant,
			CompteEpargne compteEpargne) {
		super();
		this.adresse = adresse;
		this.clientFortune = clientFortune;
		this.typeClient = typeClient;
		this.compteCourant = compteCourant;
		this.compteEpargne = compteEpargne;
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
	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Client [adresse=" + adresse + ", clientFortune=" + clientFortune + ", typeClient=" + typeClient
				+ ", compteCourant=" + compteCourant + ", compteEpargne=" + compteEpargne + "]";
	}
	
	
	
}
