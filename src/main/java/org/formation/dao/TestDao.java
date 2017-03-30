package org.formation.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.formation.model.Adresse;
import org.formation.model.Agence;
import org.formation.model.Client;
import org.formation.model.Gerant;

public class TestDao {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");

	
	public static void main(String[] args) {
		

		
		EntityManager em = emf.createEntityManager();
		EntityTransaction etxn = em.getTransaction();
		
		Adresse a1 = new Adresse("456", "55454", "24121");
		Client c1 = new Client("Paul", "Dupont", "0102030405");
		Agence agence1 = new Agence();
		Gerant gerant1 = new Gerant();
		agence1.setGerant(gerant1);
		
		try {
			etxn.begin();
			em.persist(c1);
			em.persist(agence1);
			etxn.commit();
		} catch (Exception e) {
			if (etxn != null)
				etxn.rollback();
		} finally {
			if (em != null)
				em.close();
		}
		
		
		
		
	}

}
