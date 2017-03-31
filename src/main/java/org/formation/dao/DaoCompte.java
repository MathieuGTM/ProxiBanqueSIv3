package org.formation.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.formation.model.CompteBancaire;
import org.formation.model.CompteCourant;
import org.formation.model.CompteEpargne;

@Named
public class DaoCompte implements IDaoCompte {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");

	
	
	@Override
	public void create(CompteBancaire compte) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();

			em.persist(compte);

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
	}
	

	@Override
	public void delete(Long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();

			em.remove(id);

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
	}

	@Override
	public void update(CompteBancaire compte) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			em.merge(compte);
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
	}

	@Override
	public CompteBancaire getCC(Long id) {
		CompteBancaire compte = new CompteCourant();
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			compte = em.find(CompteCourant.class, id);

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
		return compte;
	}

	@Override
	public CompteBancaire getCE(Long id) {
		CompteBancaire compte = new CompteEpargne();
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			compte = em.find(CompteEpargne.class, id);

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
		return compte;
	}

	
	@Override
	public List<CompteBancaire> getComptes() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		List<CompteBancaire> retList = new ArrayList<>();
		try {
			txn.begin();

			TypedQuery<CompteBancaire> query = em.createQuery("select c from CompteBancaire c", CompteBancaire.class);
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


	@Override
	public List<CompteCourant> getCCs() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		List<CompteCourant> retList = new ArrayList<>();
		try {
			txn.begin();

			TypedQuery<CompteCourant> query = em.createQuery("select c from CompteCourant c", CompteCourant.class);
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


	@Override
	public List<CompteEpargne> getCEs() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		List<CompteEpargne> retList = new ArrayList<>();
		try {
			txn.begin();

			TypedQuery<CompteEpargne> query = em.createQuery("select c from CompteEpargne c", CompteEpargne.class);
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
