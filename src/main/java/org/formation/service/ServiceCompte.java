package org.formation.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.formation.model.CompteBancaire;

@Named
public class ServiceCompte implements IServiceCompte {

	@Inject
	IServiceCompte service;
	
	@Override
	public void create(CompteBancaire compte) {
		service.create(compte);
	}

	@Override
	public void delete(Long id) {
		service.delete(id);
	}

	@Override
	public void update(CompteBancaire compte) {
		service.update(compte);
	}

	@Override
	public CompteBancaire getCC(Long id) {
		return service.getCC(id);
	}
	
	@Override
	public CompteBancaire getCE(Long id) {
		return service.getCE(id);
	}
	
	@Override
	public CompteBancaire getCCs(Long id) {
		return service.getCCs(id);
	}
	
	@Override
	public CompteBancaire getCEs(Long id) {
		return service.getCEs(id);
	}

	@Override
	public List<CompteBancaire> getComptes() {
		return service.getComptes();
	}

}
