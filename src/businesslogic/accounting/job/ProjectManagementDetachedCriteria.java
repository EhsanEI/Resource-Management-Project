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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ProjectManagementDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final CollectionExpression permission;
	public final CollectionExpression notification;
	
	public ProjectManagementDetachedCriteria() {
		super(businesslogic.accounting.job.ProjectManagement.class, businesslogic.accounting.job.ProjectManagementCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		permission = new CollectionExpression("ORM_Permission", this.getDetachedCriteria());
		notification = new CollectionExpression("ORM_Notification", this.getDetachedCriteria());
	}
	
	public ProjectManagementDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, businesslogic.accounting.job.ProjectManagementCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		permission = new CollectionExpression("ORM_Permission", this.getDetachedCriteria());
		notification = new CollectionExpression("ORM_Notification", this.getDetachedCriteria());
	}
	
	public businesslogic.utility.NotificationDetachedCriteria createNotificationCriteria() {
		return new businesslogic.utility.NotificationDetachedCriteria(createCriteria("ORM_Notification"));
	}
	
	public businesslogic.accounting.PermissionDetachedCriteria createPermissionCriteria() {
		return new businesslogic.accounting.PermissionDetachedCriteria(createCriteria("ORM_Permission"));
	}
	
	public ProjectManagement uniqueProjectManagement(PersistentSession session) {
		return (ProjectManagement) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public ProjectManagement[] listProjectManagement(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (ProjectManagement[]) list.toArray(new ProjectManagement[list.size()]);
	}
}

