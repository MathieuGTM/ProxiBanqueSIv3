package org.formation.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.formation.dao.IDao;


@Named
public class Service implements IService {

	
	@Inject
	IDao dao;
	
	@Override
	public void delete(Class t, long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Object t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object select(Class t, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectAll(Class t, String table) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Class t) {
		// TODO Auto-generated method stub
		
	}

}
