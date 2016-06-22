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

public class ResourceManagementDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final CollectionExpression permission;
	
	public ResourceManagementDetachedCriteria() {
		super(businesslogic.accounting.ResourceManagement.class, businesslogic.accounting.ResourceManagementCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		permission = new CollectionExpression("ORM_Permission", this.getDetachedCriteria());
	}
	
	public ResourceManagementDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, businesslogic.accounting.ResourceManagementCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		permission = new CollectionExpression("ORM_Permission", this.getDetachedCriteria());
	}
	
	public businesslogic.accounting.PermissionDetachedCriteria createPermissionCriteria() {
		return new businesslogic.accounting.PermissionDetachedCriteria(createCriteria("ORM_Permission"));
	}
	
	public ResourceManagement uniqueResourceManagement(PersistentSession session) {
		return (ResourceManagement) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public ResourceManagement[] listResourceManagement(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (ResourceManagement[]) list.toArray(new ResourceManagement[list.size()]);
	}
}

