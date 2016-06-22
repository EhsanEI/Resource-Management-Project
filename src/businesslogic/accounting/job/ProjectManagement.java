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
		if (key == businesslogic.distribution.resource.ORMConstants.KEY_PROJECTMANAGEMENT_NOTIFICATION) {
			return ORM_notification;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private java.util.Set ORM_notification = new java.util.HashSet();
	
	private void setORM_Notification(java.util.Set value) {
		this.ORM_notification = value;
	}
	
	private java.util.Set getORM_Notification() {
		return ORM_notification;
	}
	
	public final businesslogic.utility.NotificationSetCollection notification = new businesslogic.utility.NotificationSetCollection(this, _ormAdapter, businesslogic.distribution.resource.ORMConstants.KEY_PROJECTMANAGEMENT_NOTIFICATION, businesslogic.distribution.resource.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
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
