package org.formation.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.formation.model.Client;
import org.formation.model.CompteBancaire;
import org.formation.service.IService;


/**
 * La classe CompteController est un controleur (pattern MVC). Il permet a  la couche presentation de recuperer des informations 
 * sur des clients, de communiquer avec la bdd et permet la navigation et la redirection a certaines pages. Elle permet le log des 
 * messages d'erreur, warning etc.
 * @author Mathieu et Aurelie
 */


@Named
public class CompteController implements Serializable {


	private static final long serialVersionUID = 1L;

	private Logger logger = Logger.getLogger(getClass().getName());

	private List<CompteBancaire> comptes;
	
	
	@Inject
	IService<CompteBancaire> service;
	
	public CompteController() throws Exception {
		comptes = new ArrayList<>();
	
	}
	
	
	public String addCompte(CompteBancaire compte) {

		logger.info("Ajout du compte : " + compte);

		try {

			service.create(compte);

		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error adding compte", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);

			return "";
		}

		return "list-clients?faces-redirect=true";
	}
	
	public List<CompteBancaire> getComptes() {
		loadComptes();
		return comptes;
	}
	
	public void loadComptes() {

		logger.info("Loading comptes");

		comptes.clear();

		try {

			comptes = service.selectAll();

		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading students", exc);

			// add error message for JSF page
			addErrorMessage(exc);
		}
	}
	


	
	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
}
