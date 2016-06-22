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
package businesslogic.distribution;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AllocationCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final BooleanExpression allocated;
	
	public AllocationCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		allocated = new BooleanExpression("allocated", this);
	}
	
	public AllocationCriteria(PersistentSession session) {
		this(session.createCriteria(Allocation.class));
	}
	
	public AllocationCriteria() throws PersistentException {
		this(businesslogic.distribution.resource.OODPersistentManager.instance().getSession());
	}
	
	public Allocation uniqueAllocation() {
		return (Allocation) super.uniqueResult();
	}
	
	public Allocation[] listAllocation() {
		java.util.List list = super.list();
		return (Allocation[]) list.toArray(new Allocation[list.size()]);
	}
}

