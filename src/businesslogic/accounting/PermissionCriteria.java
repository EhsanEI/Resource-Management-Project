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

public class PermissionCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression title;
	
	public PermissionCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		title = new StringExpression("title", this);
	}
	
	public PermissionCriteria(PersistentSession session) {
		this(session.createCriteria(Permission.class));
	}
	
	public PermissionCriteria() throws PersistentException {
		this(businesslogic.accounting.user.OODPersistentManager.instance().getSession());
	}
	
	public Permission uniquePermission() {
		return (Permission) super.uniqueResult();
	}
	
	public Permission[] listPermission() {
		java.util.List list = super.list();
		return (Permission[]) list.toArray(new Permission[list.size()]);
	}
}

