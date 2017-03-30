package org.formation.view;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.formation.service.IService;

@Named
@SessionScoped
public class Controller<T> implements Serializable {

	private static final long serialVersionUID = 8475399265911125474L;
	private Logger logger = Logger.getLogger(getClass().getName());

	@Inject
	IService<T> service;
	
	public String addClient(T client) {

		logger.info("Adding client : " + client);

		try {

			// add student to the database
			service.create(client);

		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error adding client", exc);

			// add error message for JSF page
			//addErrorMessage(exc);

			return null;
		}

		return "list-clients?faces-redirect=true";
	}
}
