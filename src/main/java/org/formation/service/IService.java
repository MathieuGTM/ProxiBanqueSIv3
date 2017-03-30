package org.formation.service;

import java.util.List;

import org.formation.model.Client;

public interface IService<T> {

	public void create(T t);
	public void delete(Class<T> t, long id);
	public void update(Class<T> t);
	public T select(Class<T> t, long id);
	public List<Client> selectAll();
	public List<T> selectAll(Class<T> t, String table);
	
	
}
