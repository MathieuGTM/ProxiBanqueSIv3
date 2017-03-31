package org.formation.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.formation.dao.IDaoCompte;
import org.formation.model.CompteBancaire;
import org.formation.model.CompteCourant;
import org.formation.model.CompteEpargne;

@Named
@SessionScoped
public class ServiceCompte implements IServiceCompte, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	IDaoCompte dao;
	
	@Override
	public void create(CompteBancaire compte) {
		dao.create(compte);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public void update(CompteBancaire compte) {
		dao.update(compte);
	}

	@Override
	public CompteBancaire getCC(Long id) {
		return dao.getCC(id);
	}
	
	@Override
	public CompteBancaire getCE(Long id) {
		return dao.getCE(id);
	}
	
	@Override
	public List<CompteCourant> getCCs() {
		return dao.getCCs();
	}
	
	@Override
	public List<CompteEpargne> getCEs() {
		return dao.getCEs();
	}

	@Override
	public List<CompteBancaire> getComptes() {
		return dao.getComptes();
	}



}
