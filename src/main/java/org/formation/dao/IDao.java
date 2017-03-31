package org.formation.dao;

import java.util.List;

import org.formation.model.Client;


/**
 * @author Mathieu et Aur�lie
 * L'interface IDao<T> est une interface g�n�rique. Elle permet a l'application et notamment au  
 *  conseiller de : ajouter un client dans la bdd, en supprimer un, le mettre a� jour
 * et afficher les infos d'un client ou de plusieurs.
 */


public interface IDao<T> {

	/**
	 * m�thode qui persiste un objet de type T dans la base de donn�es 
	 *
	 */
	public void create(T t);

	/**
	 * m�thode qui supprime un objet de type T dans la base de donn�es 
	 *
	 */
	public void delete(Class<T> t, Long id);

	/**
	 * m�thode qui modifie un objet de type T dans la base de donn�es 
	 *
	 */
	public void update(Class<T> t);

	/**
	 * m�thode qui recupere un objet de type T dans la base de donn�es 
	 *
	 */
	public T select(Class<T> t, Long id);
//	public List<T> selectAll(Class<T> t, String table);

	/**
	 * m�thode qui r�cupère tous les clients dans la base de donn�es 
	 *
	 */
	public List<Client> getClients();
	
}
