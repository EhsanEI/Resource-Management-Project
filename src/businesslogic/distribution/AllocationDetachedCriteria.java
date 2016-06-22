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

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMDetachedCriteria;
import org.orm.criteria.BooleanExpression;
import org.orm.criteria.IntegerExpression;

public class AllocationDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final BooleanExpression allocated;
	
	public AllocationDetachedCriteria() {
		super(businesslogic.distribution.Allocation.class, businesslogic.distribution.AllocationCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		allocated = new BooleanExpression("allocated", this.getDetachedCriteria());
	}
	
	public AllocationDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, businesslogic.distribution.AllocationCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		allocated = new BooleanExpression("allocated", this.getDetachedCriteria());
	}
	
	public Allocation uniqueAllocation(PersistentSession session) {
		return (Allocation) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Allocation[] listAllocation(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Allocation[]) list.toArray(new Allocation[list.size()]);
	}
}

