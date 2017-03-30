package org.formation.dao;

import java.util.List;

import org.formation.model.Client;

public interface IDao<T> {

	public void create(T t);
	public void delete(Class<T> t, long id);
	public void update(Class<T> t);
	public T select(Class<T> t, long id);
	public List<T> selectAll(Class<T> t, String table);
	public List<Client> selectAll();
	
}
