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

public class ProgrammingCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final CollectionExpression permission;
	
	public ProgrammingCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		permission = new CollectionExpression("ORM_Permission", this);
	}
	
	public ProgrammingCriteria(PersistentSession session) {
		this(session.createCriteria(Programming.class));
	}
	
	public ProgrammingCriteria() throws PersistentException {
		this(businesslogic.distribution.resource.OODPersistentManager.instance().getSession());
	}
	
	public businesslogic.accounting.PermissionCriteria createPermissionCriteria() {
		return new businesslogic.accounting.PermissionCriteria(createCriteria("ORM_Permission"));
	}
	
	public Programming uniqueProgramming() {
		return (Programming) super.uniqueResult();
	}
	
	public Programming[] listProgramming() {
		java.util.List list = super.list();
		return (Programming[]) list.toArray(new Programming[list.size()]);
	}
}

