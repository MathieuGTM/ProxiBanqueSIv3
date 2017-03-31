package org.formation.dao;

import java.util.List;

import org.formation.model.Client;
import org.formation.model.CompteCourant;


/**
 * @author Mathieu et Aurélie
 * L'interface IDao<T> est une interface générique. Elle permet a l'application et notamment au  
 *  conseiller de : ajouter un client dans la bdd, en supprimer un, le mettre a  jour
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
	public void delete(Class<T> t, Long id);

	/**
	 * méthode qui modifie un objet de type T dans la base de données 
	 *
	 */
	public void update(Class<T> t);

	/**
	 * méthode qui recupere un objet de type T dans la base de données 
	 *
	 */
	public T select(Class<T> t, Long id);
	public List<T> selectAll(Class<T> t, String table);

	/**
	 * méthode qui récupÃ¨re tous les clients dans la base de données 
	 *
	 */
	public List<Client> getClients();
	
	public List<CompteCourant> getComCou() throws Exception;
	
}
