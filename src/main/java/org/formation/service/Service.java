package org.formation.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.formation.dao.IDao;
import org.formation.model.Client;
import org.formation.model.CompteCourant;


/**
 * La classe Service implemente l'interface IService et detaille les methodes signees dans l'interface
 * @author Mathieu et Aurelie
 */


@Named
public class Service<T> implements IService<T> {

	@Inject
	IDao<T> dao;

	@Override
	public void create(T t) {
		dao.create(t);
	}

	@Override
	public void delete(Class<T> t, Long id) {
		dao.delete(t, id);
	}

	@Override
	public void update(T t) {
		dao.update(t);
	}
	@Override
	public T select(Class<T> t, Long id) {

		return dao.select(t, id);
	}

	@Override
	public List<T> selectAllT(Class<T> t, String table) {
		System.out.println("service : "+ dao.selectAll(t,table));
		return dao.selectAll(t,table);
	}
	
	@Override
	public List<CompteCourant> getComCour() throws Exception {
		List<CompteCourant> ccs = dao.getComCou();
		return ccs;
	}

	@Override
	public List<Client> selectAll() {
		System.out.println("From service : "+ dao.getClients().get(0).getNom());
		return dao.getClients();
	}



	

}
