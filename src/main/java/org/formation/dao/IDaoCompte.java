package org.formation.dao;

import java.util.List;

import org.formation.model.CompteBancaire;
import org.formation.model.CompteCourant;
import org.formation.model.CompteEpargne;

public interface IDaoCompte {

	/**
	 * methode qui cree un compte dans la base de donnees 
	 *
	 */
	public void create(CompteBancaire compte);

	/**
	 * methode qui supprime un compte dans la base de donnees 
	 *
	 */	
	public void delete(Long id);

	/**
	 * methode qui modifie un compte dans la base de donnees 
	 *
	 */
	public void update(CompteBancaire compte);

	/**
	 * methode qui recupere un compte courant  dans la base de donnees
	 *
	 */
	public CompteBancaire getCC(Long id);
	/**
	 * methode qui recupere un compte epargne  dans la base de donnees
	 *
	 */
	public CompteBancaire getCE(Long id);

	
	/**
	 * methode qui recupere les comptes courant  dans la base de donnees
	 *
	 */
	public List<CompteCourant> getCCs();
	/**
	 * methode qui les comptes epargne  dans la base de donnees
	 *
	 */
	public List<CompteEpargne> getCEs();

	
	
	/**
	 * methode qui recuerent tous les comptes de la base de donnees
	 *
	 */
	public List<CompteBancaire> getComptes();
}
	
	

