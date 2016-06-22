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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class RequirementPriorityDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public RequirementPriorityDetachedCriteria() {
		super(businesslogic.distribution.requirement.RequirementPriority.class, businesslogic.distribution.requirement.RequirementPriorityCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public RequirementPriorityDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, businesslogic.distribution.requirement.RequirementPriorityCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public RequirementPriority uniqueRequirementPriority(PersistentSession session) {
		return (RequirementPriority) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public RequirementPriority[] listRequirementPriority(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (RequirementPriority[]) list.toArray(new RequirementPriority[list.size()]);
	}
}

