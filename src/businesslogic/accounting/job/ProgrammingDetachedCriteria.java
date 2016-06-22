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

public class ProgrammingDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final CollectionExpression permission;
	
	public ProgrammingDetachedCriteria() {
		super(businesslogic.accounting.job.Programming.class, businesslogic.accounting.job.ProgrammingCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		permission = new CollectionExpression("ORM_Permission", this.getDetachedCriteria());
	}
	
	public ProgrammingDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, businesslogic.accounting.job.ProgrammingCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		permission = new CollectionExpression("ORM_Permission", this.getDetachedCriteria());
	}
	
	public businesslogic.accounting.PermissionDetachedCriteria createPermissionCriteria() {
		return new businesslogic.accounting.PermissionDetachedCriteria(createCriteria("ORM_Permission"));
	}
	
	public Programming uniqueProgramming(PersistentSession session) {
		return (Programming) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Programming[] listProgramming(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Programming[]) list.toArray(new Programming[list.size()]);
	}
}

