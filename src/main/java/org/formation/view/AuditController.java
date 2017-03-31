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
import org.formation.model.CompteCourant;
import org.formation.model.TypeClient;
import org.formation.service.IService;


@Named
public class AuditController implements Serializable {

	private static final long serialVersionUID = 1710066009533945205L;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	private List<CompteCourant> ccs;
	
	@Inject
	IService<CompteCourant> service;
	
	public AuditController() throws Exception {
		ccs = new ArrayList<>();
	}
	
	
	public int auditComptesCourant() {

		logger.info("Loading comptes courant");

		ccs.clear();
		int i=0;
		
		try {
			
			ccs = service.getComCour();
			for (CompteCourant cc : ccs) {
				if (cc.getClient().getTypeClient() == TypeClient.PARTICULIER) {
					if (cc.getSolde() < -5000) {
						i++;
					}
				}else if (cc.getClient().getTypeClient() == TypeClient.PROFESSIONEL) {
					if (cc.getSolde() < -50000) {
						i++;
					}
				}else{}
				
			}

		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error comptes courant", exc);

			// add error message for JSF page
		//	addErrorMessage(exc);
		}
		return i;
	}

}
