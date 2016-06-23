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

import businesslogic.accounting.user.User;
import businesslogic.utility.Date;

public class Requirement {
	public Requirement() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == businesslogic.accounting.user.ORMConstants.KEY_REQUIREMENT_REQUIREMENTPRIORITY) {
			this.requirementPriority = (businesslogic.distribution.requirement.RequirementPriority) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private businesslogic.distribution.requirement.RequirementPriority requirementPriority;
	
	private String resourceName;
	
	private String resourceType;
	
	private int quantity;

	private Date startDate;

	private Date endDate;

	private RequirementPriority priority;

	private User projectManager;


	
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
	
	public void setRequirementPriority(businesslogic.distribution.requirement.RequirementPriority value) {
		this.requirementPriority = value;
	}
	
	public businesslogic.distribution.requirement.RequirementPriority getRequirementPriority() {
		return requirementPriority;
	}
	
	public Requirement(String resourceName, String resourceType, int quantity, businesslogic.utility.Date startDate, businesslogic.utility.Date endDate, businesslogic.distribution.requirement.RequirementPriority priority) {
		this.resourceName = resourceName;
		this.resourceType = resourceType;
		this.quantity = quantity;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
	}

	
	public businesslogic.utility.Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(businesslogic.utility.Date startDate) {
		this.startDate = startDate;
	}
	
	public businesslogic.utility.Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(businesslogic.utility.Date endDate) {
		this.endDate = endDate;
	}
	
	public businesslogic.distribution.requirement.RequirementPriority getPriority() {
		return priority;
	}
	
	public void setPriority(businesslogic.distribution.requirement.RequirementPriority priority) {
		this.priority = priority;
	}
	
	public User getProjectManager() {
		return projectManager;
	}
	
	public void setProjectManager(User projectManager) {
		this.projectManager = projectManager;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
