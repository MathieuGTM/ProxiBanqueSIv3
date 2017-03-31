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
import org.formation.service.IService;


/**
 * La classe ClientController est un controleur (pattern MVC). Il permet à la couche présentation de récupérer des informations 
 * sur des clients, de communiquer avec la bdd et permet la navigation et la redirection a certaines pages. Elle permet le log des 
 * messages d'erreur, warning etc.
 * @author Mathieu et Aurélie
 */


@Named
public class ClientController implements Serializable {

	private static final long serialVersionUID = 8475399265911125474L;
	private Logger logger = Logger.getLogger(getClass().getName());

	private List<Client> clients;
	
	
	@Inject
	IService<Client> service;
	
	public ClientController() throws Exception {
		clients = new ArrayList<>();
	
	}
	
	
	public String addClient(Client client) {

		logger.info("Adding client : " + client);

		try {

			service.create(client);

		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error adding client", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);

			return "";
		}

		return "list-clients?faces-redirect=true";
	}
	
	public List<Client> getClients() {
		return clients;
	}
	
	public void loadClients() {

		logger.info("Loading clients");

		clients.clear();

		try {

			clients = service.selectAll();

		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading students", exc);

			// add error message for JSF page
			addErrorMessage(exc);
		}
	}
	
	



//	public String loadClient(Long id) {
//
//		logger.info("loading client: " + id);
//
//		try {
//			// TODO : probleme!!!!!!!!!
//			Client client = service.selectClient( , id);
//
//			// put in the request attribute ... so we can use it on the form
//			// page
//			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
//
//			Map<String, Object> requestMap = externalContext.getRequestMap();
//			requestMap.put("student", theStudent);
//
//		} catch (Exception exc) {
//			// send this to server logs
//			logger.log(Level.SEVERE, "Error loading student id:" + studentId, exc);
//
//			// add error message for JSF page
//			addErrorMessage(exc);
//
//			return null;
//		}
//
//		return "update-student-form.xhtml";
//	}

	
	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
}
