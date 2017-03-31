package org.formation.service;

import java.util.List;

import org.formation.model.Client;

/**
 * @author Mathieu et Aurélie
 * L'interface IService est une interface générique et signe les méthodes relatives à la bdd de la banque : 
 * ainsi le conseiller peut : ajouter un client dans la bdd, en supprimer un, le mettre à jour
 * et afficher les infos d'un client ou de tous les clients.
 * Ces méthodes passent par la couche dao.
 */


public interface IService<T> {

	/**
	 * méthode qui crée un objet de type T dans la base de données en passant par la dao
	 *
	 */
	public void create(T t);

	/**
	 * méthode qui supprime un objet de type T dans la base de données en passant par la dao
	 *
	 */	
	public void delete(Class<T> t, long id);

	/**
	 * méthode qui modifie un objet de type T dans la base de données en passant par la dao
	 *
	 */
	public void update(Class<T> t);

	/**
	 * méthode qui récupère un objet de type T dans la base de données en passant par la dao
	 *
	 */
	public T select(Class<T> t, long id);

	/**
	 * méthode qui récupèrent tous les clients de la base de données en passant par la dao
	 *
	 */
	public List<Client> selectAll();
//	public List<T> selectAll(Class<T> t, String table);
	
	
}
