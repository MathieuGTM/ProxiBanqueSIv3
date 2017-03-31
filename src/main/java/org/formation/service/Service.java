package org.formation.service;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import org.formation.dao.IDao;
import org.formation.model.Client;


/**
 * La classe Service implemente l'interface IService et detaille les methodes signees dans l'interface
 * @author Mathieu et Aurelie
 */


@Named
public class Service<T> implements IService<T> {

	@Inject
	IDao<T> dao;


	public void create(T t) {
		dao.create(t);
	}


	public void delete(Class<T> t, Long id) {
		dao.delete(t, id);
	}

	
	public void update(Class<T> t) {
		dao.update(t);
	}
	
	public T select(Class<T> t, Long id) {

		return dao.select(t, id);
	}


//	public List<T> selectAll(Class<T> t, String table) {
//
//		return dao.selectAll(t,table);
//	}


	@Override
	public List<Client> selectAll() {
		return dao.getClients();
	}

	

}
