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

public class PhysicalResourceDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression uniqueIdentifier;
	public final StringExpression name;
	
	public PhysicalResourceDetachedCriteria() {
		super(businesslogic.distribution.resource.PhysicalResource.class, businesslogic.distribution.resource.PhysicalResourceCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		uniqueIdentifier = new StringExpression("uniqueIdentifier", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public PhysicalResourceDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, businesslogic.distribution.resource.PhysicalResourceCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		uniqueIdentifier = new StringExpression("uniqueIdentifier", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public PhysicalResource uniquePhysicalResource(PersistentSession session) {
		return (PhysicalResource) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public PhysicalResource[] listPhysicalResource(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (PhysicalResource[]) list.toArray(new PhysicalResource[list.size()]);
	}
}

