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

public class HumanResourceDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression uniqueIdentifier;
	public final StringExpression name;
	
	public HumanResourceDetachedCriteria() {
		super(businesslogic.distribution.resource.HumanResource.class, businesslogic.distribution.resource.HumanResourceCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		uniqueIdentifier = new StringExpression("uniqueIdentifier", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public HumanResourceDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, businesslogic.distribution.resource.HumanResourceCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		uniqueIdentifier = new StringExpression("uniqueIdentifier", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public HumanResource uniqueHumanResource(PersistentSession session) {
		return (HumanResource) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public HumanResource[] listHumanResource(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (HumanResource[]) list.toArray(new HumanResource[list.size()]);
	}
}

