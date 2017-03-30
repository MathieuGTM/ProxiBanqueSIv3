package org.formation.dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.formation.model.Client;

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


	
	public void delete(Class<T> t, long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction etxn = em.getTransaction();
		try {
			etxn.begin();
			T remove = em.find(t, id);
			
			em.remove(remove);
			System.out.println("delete "+remove.toString());
			etxn.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (etxn != null)
				etxn.rollback();
		} finally {
			if (em != null)
				em.close();
		}
		
	}



	public void update(Class<T> t) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction etxn = em.getTransaction();

		try {
			etxn.begin();
			em.merge(t);
			etxn.commit();
		} catch (Exception e) {
			if (etxn != null)
				etxn.rollback();
			System.out.println(e.getMessage());
			
		}finally {
			if (em != null)
				em.close();
		}
		
	}
	
	public T select(Class<T> t, long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction etxn = em.getTransaction();
		T recup = null;

		try {
			etxn.begin();
			
			recup = em.find(t, id);
			etxn.commit();
		} catch (Exception e) {
			if (etxn != null)
				etxn.rollback();
			System.out.println(e.getMessage());
			
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
			System.out.println(e.getMessage());
			
		} finally {
			if (em != null)
				em.close();
		}
		return list;
	}



	@Override
	public List<Client> selectAll() {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction etxn = em.getTransaction();
		List<Client> list = null ;
		String sql = "SELECT c FROM Client c ";
        
		try {
			etxn.begin();
			TypedQuery<Client> query = em.createQuery(sql, Client.class);
			list = query.getResultList();
			etxn.commit();
		} catch (Exception e) {
			if (etxn != null)
				etxn.rollback();
			System.out.println(e.getMessage());
			
		} finally {
			if (em != null)
				em.close();
		}
		return list;
		
	}

}
