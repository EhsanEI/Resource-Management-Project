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
package businesslogic.distribution.resource;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ResourceStateDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public ResourceStateDetachedCriteria() {
		super(businesslogic.distribution.resource.ResourceState.class, businesslogic.distribution.resource.ResourceStateCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public ResourceStateDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, businesslogic.distribution.resource.ResourceStateCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public ResourceState uniqueResourceState(PersistentSession session) {
		return (ResourceState) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public ResourceState[] listResourceState(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (ResourceState[]) list.toArray(new ResourceState[list.size()]);
	}
}

