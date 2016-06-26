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
import businesslogic.accounting.user.User;
import businesslogic.distribution.resource.InformationResource;
import businesslogic.utility.Quantity;

public class Requirement {
	public Requirement() {
	}
	
//	private void this_setOwner(Object owner, int key) {
//		if (key == businesslogic.accounting.user.ORMConstants.KEY_REQUIREMENT_REQUIREMENTPRIORITY) {
//			this.requirementPriority = (businesslogic.distribution.requirement.RequirementPriority) owner;
//		}
//	}
	
//	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
//		public void setOwner(Object owner, int key) {
//			this_setOwner(owner, key);
//		}
//
//	};
	
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

	public Requirement(String resourceName, String resourceType, Quantity quantity, businesslogic.utility.Date startDate, businesslogic.utility.Date endDate, businesslogic.distribution.requirement.RequirementPriority priority) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setQuantity(Quantity quantity) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
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

	public businesslogic.distribution.requirement.RequirementPriority getPriority() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setPriority(businesslogic.distribution.requirement.RequirementPriority priority) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setProjectManager(ProjectManagement pm) {
		pm.addRequirement(this);
	}

	public void setInformationResource(InformationResource informationResource) {
		informationResource.addRequirement(this);
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
