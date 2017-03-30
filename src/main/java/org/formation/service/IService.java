package org.formation.service;

import java.util.List;

public interface IService<T> {

	public void delete(Class<T> t, long id);
	public void create(T t);
	public T select(Class<T> t, long id);
	public List<T> selectAll(Class<T> t, String table);
	public void update(Class<T> t);
	
	
}
