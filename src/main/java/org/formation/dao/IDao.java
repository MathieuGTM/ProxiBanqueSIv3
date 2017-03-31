package org.formation.dao;

import java.util.List;

import org.formation.model.Client;


/**
 * @author Mathieu et Aurélie
 * L'interface IDao<T> est une interface générique. Elle permet a l'application et notamment au  
 *  conseiller de : ajouter un client dans la bdd, en supprimer un, le mettre à jour
 * et afficher les infos d'un client ou de plusieurs.
 */


public interface IDao<T> {

	/**
	 * méthode qui persiste un objet de type T dans la base de données 
	 *
	 */
	public void create(T t);

	/**
	 * méthode qui supprime un objet de type T dans la base de données 
	 *
	 */
	public void delete(Class<T> t, long id);

	/**
	 * méthode qui modifie un objet de type T dans la base de données 
	 *
	 */
	public void update(Class<T> t);

	/**
	 * méthode qui recupere un objet de type T dans la base de données 
	 *
	 */
	public T select(Class<T> t, long id);
//	public List<T> selectAll(Class<T> t, String table);

	/**
	 * méthode qui récupère tous les clients dans la base de données 
	 *
	 */
	public List<Client> getClients();
	
}
