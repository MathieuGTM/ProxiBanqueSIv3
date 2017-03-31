package org.formation.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.formation.model.Client;
import org.formation.service.IService;

/**
 * La classe ClientController est un controleur (pattern MVC). Il permet a� la
 * couche presentation de recuperer des informations sur des clients, de
 * communiquer avec le service et permet la navigation et la redirection a
 * certaines pages. Elle permet le log des messages d'erreur, warning etc.
 * 
 * @author Mathieu et Aurelie
 */

@Named
public class ClientController implements Serializable {

	private static final long serialVersionUID = 8475399265911125474L;
	private Logger logger = Logger.getLogger(getClass().getName());

	private List<Client> clients;

	@Inject
	IService<Client> service;

	private UIData dataTable;

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public ClientController() throws Exception {
		clients = new ArrayList<>();

	}

	public String addClient(Client client) {

		logger.info("Adding client : " + client);

		try {
			loadClients();
			if (clients.size() < 10) {
				service.create(client);
			}

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

		loadClients();
		return clients;
	}

	public void loadClients() {

		logger.info("Loading clients");

		clients.clear();
		try {

			// clients = service.selectAllT(Client.class, "Client");
			clients = service.selectAll();

		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading clients", exc);

			// add error message for JSF page
			addErrorMessage(exc);
		}
	}

	 public String deleteClient(Long id) {
	
	 logger.info("Deleting client id: " + id);
	
	 try {
	
	 service.delete(id);
	
	 } catch (Exception exc) {
	 // send this to server logs
	 logger.log(Level.SEVERE, "Error deleting client id: " + id, exc);
	
	 // add error message for JSF page
	 addErrorMessage(exc);
	
	 return null;
	 }
	
	 return "list-clients";
	 }

	public String loadClient(Long id) {

		logger.info("loading client: " + id);

		try {
			Client client = service.select(id);

			// put in the request attribute ... so we can use it on the form
			// page
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("client", client);

		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading client id:" + id, exc);

			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}

		return "update-client?faces-redirect=true";
	}

	public String updateClient(Client client) {

		logger.info("updating client: " + client);

		try {
			// update client in the database
			service.update(client);

		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error updating client: " + client, exc);

			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}

		return "list-clients?faces-redirect=true";
	}

	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
