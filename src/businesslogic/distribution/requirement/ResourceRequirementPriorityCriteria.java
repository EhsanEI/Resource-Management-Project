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

public class ResourceRequirementPriorityCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public ResourceRequirementPriorityCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public ResourceRequirementPriorityCriteria(PersistentSession session) {
		this(session.createCriteria(ResourceRequirementPriority.class));
	}
	
	public ResourceRequirementPriorityCriteria() throws PersistentException {
		this(businesslogic.distribution.resource.OODPersistentManager.instance().getSession());
	}
	
	public ResourceRequirementPriority uniqueResourceRequirementPriority() {
		return (ResourceRequirementPriority) super.uniqueResult();
	}
	
	public ResourceRequirementPriority[] listResourceRequirementPriority() {
		java.util.List list = super.list();
		return (ResourceRequirementPriority[]) list.toArray(new ResourceRequirementPriority[list.size()]);
	}
}

