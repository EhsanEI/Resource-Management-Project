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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class JobDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final CollectionExpression permission;
	
	public JobDetachedCriteria() {
		super(businesslogic.accounting.job.Job.class, businesslogic.accounting.job.JobCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		permission = new CollectionExpression("ORM_Permission", this.getDetachedCriteria());
	}
	
	public JobDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, businesslogic.accounting.job.JobCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		permission = new CollectionExpression("ORM_Permission", this.getDetachedCriteria());
	}
	
	public businesslogic.accounting.PermissionDetachedCriteria createPermissionCriteria() {
		return new businesslogic.accounting.PermissionDetachedCriteria(createCriteria("ORM_Permission"));
	}
	
	public Job uniqueJob(PersistentSession session) {
		return (Job) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Job[] listJob(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Job[]) list.toArray(new Job[list.size()]);
	}
}

