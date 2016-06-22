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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ResourceManagementCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final CollectionExpression permission;
	
	public ResourceManagementCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		permission = new CollectionExpression("ORM_Permission", this);
	}
	
	public ResourceManagementCriteria(PersistentSession session) {
		this(session.createCriteria(ResourceManagement.class));
	}
	
	public ResourceManagementCriteria() throws PersistentException {
		this(businesslogic.distribution.resource.OODPersistentManager.instance().getSession());
	}
	
	public businesslogic.accounting.PermissionCriteria createPermissionCriteria() {
		return new businesslogic.accounting.PermissionCriteria(createCriteria("ORM_Permission"));
	}
	
	public ResourceManagement uniqueResourceManagement() {
		return (ResourceManagement) super.uniqueResult();
	}
	
	public ResourceManagement[] listResourceManagement() {
		java.util.List list = super.list();
		return (ResourceManagement[]) list.toArray(new ResourceManagement[list.size()]);
	}
}

