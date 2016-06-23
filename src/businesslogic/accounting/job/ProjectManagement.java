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
package businesslogic.accounting.job;

public class ProjectManagement extends businesslogic.accounting.job.Job {
	public ProjectManagement() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == businesslogic.accounting.user.ORMConstants.KEY_PROJECTMANAGEMENT_INFORMATIONRESOURCES) {
			return ORM_informationResources;
		}
		else if (key == businesslogic.accounting.user.ORMConstants.KEY_PROJECTMANAGEMENT_SPECIALTIES) {
			return ORM_specialties;
		}
		else if (key == businesslogic.accounting.user.ORMConstants.KEY_PROJECTMANAGEMENT_REQUIREMENTS) {
			return ORM_requirements;
		}
		else if (key == businesslogic.accounting.user.ORMConstants.KEY_PROJECTMANAGEMENT_NOTIFICATION) {
			return ORM_notification;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private java.util.Set ORM_informationResources = new java.util.HashSet();
	
	private java.util.Set ORM_specialties = new java.util.HashSet();
	
	private java.util.Set ORM_requirements = new java.util.HashSet();
	
	private java.util.Set ORM_notification = new java.util.HashSet();
	
	private void setORM_InformationResources(java.util.Set value) {
		this.ORM_informationResources = value;
	}
	
	private java.util.Set getORM_InformationResources() {
		return ORM_informationResources;
	}
	
	public final businesslogic.distribution.resource.InformationResourceSetCollection informationResources = new businesslogic.distribution.resource.InformationResourceSetCollection(this, _ormAdapter, businesslogic.accounting.user.ORMConstants.KEY_PROJECTMANAGEMENT_INFORMATIONRESOURCES, businesslogic.accounting.user.ORMConstants.KEY_INFORMATIONRESOURCE_PROJECTMANAGEMENT, businesslogic.accounting.user.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Specialties(java.util.Set value) {
		this.ORM_specialties = value;
	}
	
	private java.util.Set getORM_Specialties() {
		return ORM_specialties;
	}
	
	public final businesslogic.accounting.job.SpecialtySetCollection specialties = new businesslogic.accounting.job.SpecialtySetCollection(this, _ormAdapter, businesslogic.accounting.user.ORMConstants.KEY_PROJECTMANAGEMENT_SPECIALTIES, businesslogic.accounting.user.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Requirements(java.util.Set value) {
		this.ORM_requirements = value;
	}
	
	private java.util.Set getORM_Requirements() {
		return ORM_requirements;
	}
	
	public final businesslogic.distribution.requirement.RequirementSetCollection requirements = new businesslogic.distribution.requirement.RequirementSetCollection(this, _ormAdapter, businesslogic.accounting.user.ORMConstants.KEY_PROJECTMANAGEMENT_REQUIREMENTS, businesslogic.accounting.user.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Notification(java.util.Set value) {
		this.ORM_notification = value;
	}
	
	private java.util.Set getORM_Notification() {
		return ORM_notification;
	}
	
	public final businesslogic.utility.NotificationSetCollection notification = new businesslogic.utility.NotificationSetCollection(this, _ormAdapter, businesslogic.accounting.user.ORMConstants.KEY_PROJECTMANAGEMENT_NOTIFICATION, businesslogic.accounting.user.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public businesslogic.distribution.resource.InformationResource[] getInformationResources() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void addInformationResource(businesslogic.distribution.resource.InformationResource informationResource) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public businesslogic.utility.Notification[] getNotifications() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void addNotification(businesslogic.utility.Notification notification) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return super.toString();
	}
	
}
