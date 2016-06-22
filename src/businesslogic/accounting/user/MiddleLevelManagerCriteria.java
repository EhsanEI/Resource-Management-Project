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
package businesslogic.accounting.user;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class MiddleLevelManagerCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression username;
	public final StringExpression password;
	public final StringExpression email;
	public final BooleanExpression approved;
	public final CollectionExpression permission;
	
	public MiddleLevelManagerCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		username = new StringExpression("username", this);
		password = new StringExpression("password", this);
		email = new StringExpression("email", this);
		approved = new BooleanExpression("approved", this);
		permission = new CollectionExpression("ORM_Permission", this);
	}
	
	public MiddleLevelManagerCriteria(PersistentSession session) {
		this(session.createCriteria(MiddleLevelManager.class));
	}
	
	public MiddleLevelManagerCriteria() throws PersistentException {
		this(businesslogic.distribution.resource.OODPersistentManager.instance().getSession());
	}
	
	public businesslogic.accounting.PermissionCriteria createPermissionCriteria() {
		return new businesslogic.accounting.PermissionCriteria(createCriteria("ORM_Permission"));
	}
	
	public MiddleLevelManager uniqueMiddleLevelManager() {
		return (MiddleLevelManager) super.uniqueResult();
	}
	
	public MiddleLevelManager[] listMiddleLevelManager() {
		java.util.List list = super.list();
		return (MiddleLevelManager[]) list.toArray(new MiddleLevelManager[list.size()]);
	}
}

