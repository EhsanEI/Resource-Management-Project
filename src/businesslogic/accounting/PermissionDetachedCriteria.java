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
package businesslogic.accounting;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class PermissionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression title;
	public final CollectionExpression userPermissions;
	
	public PermissionDetachedCriteria() {
		super(businesslogic.accounting.Permission.class, businesslogic.accounting.PermissionCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		title = new StringExpression("title", this.getDetachedCriteria());
		userPermissions = new CollectionExpression("ORM_UserPermissions", this.getDetachedCriteria());
	}
	
	public PermissionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, businesslogic.accounting.PermissionCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		title = new StringExpression("title", this.getDetachedCriteria());
		userPermissions = new CollectionExpression("ORM_UserPermissions", this.getDetachedCriteria());
	}
	
	public Permission uniquePermission(PersistentSession session) {
		return (Permission) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Permission[] listPermission(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Permission[]) list.toArray(new Permission[list.size()]);
	}
}

