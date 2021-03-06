package org.formation.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.formation.model.Client;
import org.formation.model.CompteCourant;


/**
 * La classe Dao impl�mente l'interface IDao et d�taille les
 * m�thodes sign�es dans l'interface
 * 
 * @author Mathieu et Aur�lie
 */


@Named
public class Dao<T> implements IDao<T>{

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");



	public void create(T t) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction etxn = em.getTransaction();
		try {
			etxn.begin();
			em.persist(t);
			etxn.commit();
		} catch (Exception e) {
			if (etxn != null)
				etxn.rollback();
		} finally {
			if (em != null)
				em.close();
		}
		
	}


	
	public void delete(Long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction etxn = em.getTransaction();
		try {
			etxn.begin();
			Client remove = em.find(Client.class, id);
			
			em.remove(remove);
			etxn.commit();
		} catch (Exception e) {
			if (etxn != null)
				etxn.rollback();
		} finally {
			if (em != null)
				em.close();
		}
		
	}



	public void update(Client t) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction etxn = em.getTransaction();

		try {
			etxn.begin();
			Client c = em.find(Client.class, t.getId());
			
			em.merge(c);
			etxn.commit();
		} catch (Exception e) {
			if (etxn != null)
				etxn.rollback();
			
		}finally {
			if (em != null)
				em.close();
		}
		
	}
	
	public Client select( Long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction etxn = em.getTransaction();
		Client recup = null;

		try {
			etxn.begin();
			
			recup = em.find(Client.class, id);
			etxn.commit();
		} catch (Exception e) {
			if (etxn != null)
				etxn.rollback();
			
		}finally {
			if (em != null)
				em.close();
		}
		return recup;
	}


	public List<T> selectAll(Class<T> t,String table) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction etxn = em.getTransaction();
		List<T> list = null ;
		String sql = "SELECT c FROM "+ table+" c ";
        
		try {
			etxn.begin();
			TypedQuery<T> query = em.createQuery(sql, t);
			list = query.getResultList();
			etxn.commit();
		} catch (Exception e) {
			if (etxn != null)
				etxn.rollback();
			
		} finally {
			if (em != null)
				em.close();
		}
		return list;
	}



	@Override
	public List<Client> getClients()  {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction etxn = em.getTransaction();
		List<Client> list = new ArrayList<>() ;
		// String sql = "SELECT c FROM Client c ";
        
		try {
			etxn.begin();
			TypedQuery<Client> query = em.createQuery("from Client", Client.class);
			list = query.getResultList();
			etxn.commit();
		} catch (Exception e) {
			if (etxn != null)
				etxn.rollback();
			
		} finally {
			if (em != null)
				em.close();
		}
		return list;
		
	}
	
	@Override
	public List<CompteCourant> getComCou() throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		List<CompteCourant> retList = new ArrayList<>();
		try {
			txn.begin();

			TypedQuery<CompteCourant> query = em.createQuery("from CompteCourant", CompteCourant.class);
			retList = query.getResultList();

			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return retList;
	}
	

}
