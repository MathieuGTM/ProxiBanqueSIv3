package org.formation.service;

import java.util.List;

import org.formation.model.Client;
import org.formation.model.CompteCourant;

/**
 * @author Mathieu et Aurelie
 * L'interface IService est une interface generique et signe les methodes relatives a† la bdd de la banque : 
 * ainsi le conseiller peut : ajouter un client dans la bdd, en supprimer un, le mettre a† jour
 * et afficher les infos d'un client ou de tous les clients.
 * Ces methodes passent par la couche dao.
 */


public interface IService<T> {

	/**
	 * methode qui cree un objet de type T dans la base de donnees en passant par la dao
	 *
	 */
	public void create(T t);

	/**
	 * methode qui supprime un objet de type T dans la base de donnees en passant par la dao
	 *
	 */	
	public void delete(Class<T> t, Long id);

	/**
	 * methode qui modifie un objet de type T dans la base de donnees en passant par la dao
	 *
	 */
	public void update(Class<T> t);

	/**
	 * methode qui recup√®re un objet de type T dans la base de donnees en passant par la dao
	 *
	 */
	public T select(Class<T> t, Long id);

	/**
	 * methode qui recup√®rent tous les clients de la base de donnees en passant par la dao
	 *
	 */
	public List<Client> selectAll();
	
	public List<T> selectAllT(Class<T> t, String table);
	
	public List<CompteCourant> getComCour() throws Exception;
	
}
