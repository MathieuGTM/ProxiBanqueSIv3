package org.formation.service;

import java.util.List;

import org.formation.model.CompteBancaire;
import org.formation.model.CompteCourant;
import org.formation.model.CompteEpargne;

public interface IServiceCompte {
	/**
	 * methode qui cree un compte dans la base de donnees en passant par la dao
	 *
	 */
	public void create(CompteBancaire compte);

	/**
	 * methode qui supprime un compte dans la base de donnees en passant par la dao
	 *
	 */	
	public void delete(Long id);

	/**
	 * methode qui modifie un compte dans la base de donnees en passant par la dao
	 *
	 */
	public void update(CompteBancaire compte);

	/**
	 * methode qui recupere un compte courant  dans la base de donnees en passant par la dao
	 *
	 */
	public CompteBancaire getCC(Long id);
	/**
	 * methode qui recupere un compte epargne  dans la base de donnees en passant par la dao
	 *
	 */
	public CompteBancaire getCE(Long id);

	
	/**
	 * methode qui recuerent tous les comptes de la base de donnees en passant par la dao
	 *
	 */
	public List<CompteBancaire> getComptes();
	
	
	/**
	 * methode qui recuerent tous les comptes courants de la base de donnees en passant par la dao
	 *
	 */
	public List<CompteCourant> getCCs();
	
	
	/**
	 * methode qui recuerent tous les comptes epargne de la base de donnees en passant par la dao
	 *
	 */
	public List<CompteEpargne> getCEs();
	
	
	
	
}
