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
package businesslogic.distribution.requirement;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class RequirementPriorityCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public RequirementPriorityCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public RequirementPriorityCriteria(PersistentSession session) {
		this(session.createCriteria(RequirementPriority.class));
	}
	
	public RequirementPriorityCriteria() throws PersistentException {
		this(businesslogic.accounting.user.OODPersistentManager.instance().getSession());
	}
	
	public RequirementPriority uniqueRequirementPriority() {
		return (RequirementPriority) super.uniqueResult();
	}
	
	public RequirementPriority[] listRequirementPriority() {
		java.util.List list = super.list();
		return (RequirementPriority[]) list.toArray(new RequirementPriority[list.size()]);
	}
}

