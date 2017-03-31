package org.formation.dao;

import java.util.List;

import org.formation.model.Client;
import org.formation.model.CompteCourant;


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
	public void delete(Long id);

	/**
	 * m�thode qui modifie un objet de type T dans la base de donn�es 
	 *
	 */
	public void update(Client t);

	/**
	 * m�thode qui recupere un objet de type T dans la base de donn�es 
	 *
	 */
	public Client select(Long id);
	public List<T> selectAll(Class<T> t, String table);

	/**
	 * m�thode qui r�cupère tous les clients dans la base de donn�es 
	 *
	 */
	public List<Client> getClients();
	
	public List<CompteCourant> getComCou() throws Exception;
	
}
