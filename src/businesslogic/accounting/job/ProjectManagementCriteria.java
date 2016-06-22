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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ProjectManagementCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final CollectionExpression permission;
	public final CollectionExpression notification;
	
	public ProjectManagementCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		permission = new CollectionExpression("ORM_Permission", this);
		notification = new CollectionExpression("ORM_Notification", this);
	}
	
	public ProjectManagementCriteria(PersistentSession session) {
		this(session.createCriteria(ProjectManagement.class));
	}
	
	public ProjectManagementCriteria() throws PersistentException {
		this(businesslogic.distribution.resource.OODPersistentManager.instance().getSession());
	}
	
	public businesslogic.utility.NotificationCriteria createNotificationCriteria() {
		return new businesslogic.utility.NotificationCriteria(createCriteria("ORM_Notification"));
	}
	
	public businesslogic.accounting.PermissionCriteria createPermissionCriteria() {
		return new businesslogic.accounting.PermissionCriteria(createCriteria("ORM_Permission"));
	}
	
	public ProjectManagement uniqueProjectManagement() {
		return (ProjectManagement) super.uniqueResult();
	}
	
	public ProjectManagement[] listProjectManagement() {
		java.util.List list = super.list();
		return (ProjectManagement[]) list.toArray(new ProjectManagement[list.size()]);
	}
}

