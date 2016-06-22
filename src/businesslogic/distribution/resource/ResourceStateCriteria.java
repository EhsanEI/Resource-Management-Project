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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ResourceStateCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public ResourceStateCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public ResourceStateCriteria(PersistentSession session) {
		this(session.createCriteria(ResourceState.class));
	}
	
	public ResourceStateCriteria() throws PersistentException {
		this(businesslogic.distribution.resource.OODPersistentManager.instance().getSession());
	}
	
	public ResourceState uniqueResourceState() {
		return (ResourceState) super.uniqueResult();
	}
	
	public ResourceState[] listResourceState() {
		java.util.List list = super.list();
		return (ResourceState[]) list.toArray(new ResourceState[list.size()]);
	}
}

