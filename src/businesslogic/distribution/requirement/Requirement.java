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

public class Requirement {
	public Requirement() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == businesslogic.distribution.resource.ORMConstants.KEY_REQUIREMENT_DATE) {
			return ORM_date;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int ID;
	
	private String resourceName;
	
	private String resourceType;
	
	private int quantity;
	
	private java.util.Set ORM_date = new java.util.HashSet();
	
	public int getORMID() {
		return getID();
	}
	
	public void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
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
	
	private void setORM_Date(java.util.Set value) {
		this.ORM_date = value;
	}
	
	private java.util.Set getORM_Date() {
		return ORM_date;
	}
	
	public final businesslogic.utility.DateSetCollection date = new businesslogic.utility.DateSetCollection(this, _ormAdapter, businesslogic.distribution.resource.ORMConstants.KEY_REQUIREMENT_DATE, businesslogic.distribution.resource.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public Requirement(String resourceName, String resourceType, int quantity, businesslogic.utility.Date startDate, businesslogic.utility.Date endDate, businesslogic.distribution.requirement.RequirementPriority priority) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public businesslogic.utility.Date getStartDate() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setStartDate(businesslogic.utility.Date startDate) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public businesslogic.utility.Date getEndDate() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setEndDate(businesslogic.utility.Date endDate) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public businesslogic.distribution.requirement.RequirementPriority getPriority() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setPriority(businesslogic.distribution.requirement.RequirementPriority priority) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public ProjectManagement getProjectManager() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setProjectManager(ProjectManagement projectManager) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
