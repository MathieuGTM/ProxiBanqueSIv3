package org.formation.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.formation.model.Client;
import org.formation.model.CompteBancaire;
import org.formation.model.CompteCourant;
import org.formation.model.CompteEpargne;
import org.formation.service.IService;
import org.formation.service.IServiceCompte;

/**
 * La classe CompteController est un controleur (pattern MVC). Il permet a  la
 * couche presentation de recuperer des informations sur des clients, de
 * communiquer avec la bdd et permet la navigation et la redirection a certaines
 * pages. Elle permet le log des messages d'erreur, warning etc.
 * 
 * @author Mathieu et Aurelie
 */

@Named
public class CompteController implements Serializable {

	private static final long serialVersionUID = 1L;


	@Inject
	IService<CompteCourant> serviceCC;
	
	private Logger logger = Logger.getLogger(getClass().getName());

	private List<CompteCourant> comptesCourant;

	private List<CompteEpargne> comptesEpargne;

	private UIData dataTable;

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}


	public CompteController() throws Exception {
		comptesCourant = new ArrayList<>();
		comptesCourant.add(new CompteCourant(10000, null, 1000, new Client("Paul", "Roger", "0102030405")));
		comptesEpargne = new ArrayList<>();
	}

	 public String addCompte(CompteCourant compte) {
	
	 logger.info("Ajout du compte : " + compte);
	
	 try {
	
	 serviceCC.create(compte);
	
	 } catch (Exception exc) {
	 // send this to server logs
	 logger.log(Level.SEVERE, "Error adding compte", exc);
	
	 // add error message for JSF page
	 addErrorMessage(exc);
	
	 return "";
	 }
	
	 return "list-clients?faces-redirect=true";
	 }
	 
	 

	public List<CompteCourant> getComptesCourant() {
		loadComptesCourant();
		return comptesCourant;
	}

	public void loadComptesCourant() {

		logger.info("Loading comptes courants");

		comptesCourant.clear();

		try {

			comptesCourant = serviceCC.getComCour();

		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error ", exc);

			// add error message for JSF page
			addErrorMessage(exc);
		}
	}

//	public List<CompteEpargne> getComptesEpargne() {
//		loadComptesEpargne();
//		return comptesEpargne;
//	}
//
//	public void loadComptesEpargne() {
//
//		logger.info("Loading comptes epargne");
//
//		comptesEpargne.clear();
//
//		try {
//
//			comptesEpargne = serviceCC.getCEs();
//
//		} catch (Exception exc) {
//			// send this to server logs
//			logger.log(Level.SEVERE, "Error ", exc);
//
//			// add error message for JSF page
//			addErrorMessage(exc);
//		}
//	}

	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
