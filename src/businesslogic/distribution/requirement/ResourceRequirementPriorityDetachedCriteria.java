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

public class ResourceRequirementPriorityDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public ResourceRequirementPriorityDetachedCriteria() {
		super(businesslogic.distribution.requirement.ResourceRequirementPriority.class, businesslogic.distribution.requirement.ResourceRequirementPriorityCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public ResourceRequirementPriorityDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, businesslogic.distribution.requirement.ResourceRequirementPriorityCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public ResourceRequirementPriority uniqueResourceRequirementPriority(PersistentSession session) {
		return (ResourceRequirementPriority) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public ResourceRequirementPriority[] listResourceRequirementPriority(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (ResourceRequirementPriority[]) list.toArray(new ResourceRequirementPriority[list.size()]);
	}
}

