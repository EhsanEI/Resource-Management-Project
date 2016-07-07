/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package businesslogic.distribution.requirement;

import businesslogic.accounting.job.ProjectManagement;
import businesslogic.accounting.job.ProjectManagementDAO;
import businesslogic.distribution.resource.InformationResource;
import businesslogic.distribution.resource.InformationResourceDAO;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import orm.OODPersistentManager;

import java.io.Serializable;

public class Requirement implements Serializable {
	public Requirement() {
	}
	
	private int ID;
	
	private int requirementPriority;
	
	private String resourceName;
	
	private String resourceType;
	
	private int quantity;

	private String startDate;

	private String endDate;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setResourceName(String value) {
		this.resourceName = value;
	}
	
	public String getResourceName() {
		return resourceName;
	}
	
	public void setResourceType(String value) {
		this.resourceType = value;
	}
	
	public String getResourceType() {
		return resourceType;
	}
	
	public void setQuantity(int value) {
		this.quantity = value;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public int getRequirementPriority() {
		return requirementPriority;
	}

	public void setRequirementPriority(int requirementPriority) {
		this.requirementPriority = requirementPriority;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public void setProjectManager(ProjectManagement pm) {
		pm.addRequirement(this);
	}

	public ProjectManagement getProjectManagement() {
		try {
			PersistentSession session = OODPersistentManager.instance().getSession();
			Integer jobID = (Integer) session.createSQLQuery("SELECT JobID FROM Requirement WHERE ID = " + getID()).list().get(0);
			return ProjectManagementDAO.getProjectManagementByORMID(jobID);
		}
		catch (PersistentException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void setInformationResource(InformationResource informationResource) {
		informationResource.addRequirement(this);
	}

	public InformationResource getInformationResource() {
		try{
			PersistentSession session = OODPersistentManager.instance().getSession();
			Integer irID = (Integer) session.createSQLQuery("SELECT ResourceID2 FROM Requirement WHERE ID = "+ getID()).uniqueResult();
			return InformationResourceDAO.getInformationResourceByORMID(irID);
		}
		catch (PersistentException ex){
		}
		return null;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
