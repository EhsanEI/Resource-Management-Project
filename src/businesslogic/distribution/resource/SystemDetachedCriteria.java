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

public class SystemDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression uniqueIdentifier;
	public final StringExpression name;
	public final StringExpression technologies;
	
	public SystemDetachedCriteria() {
		super(businesslogic.distribution.resource.System.class, businesslogic.distribution.resource.SystemCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		uniqueIdentifier = new StringExpression("uniqueIdentifier", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		technologies = new StringExpression("technologies", this.getDetachedCriteria());
	}
	
	public SystemDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, businesslogic.distribution.resource.SystemCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		uniqueIdentifier = new StringExpression("uniqueIdentifier", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		technologies = new StringExpression("technologies", this.getDetachedCriteria());
	}
	
	public System uniqueSystem(PersistentSession session) {
		return (System) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public System[] listSystem(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (System[]) list.toArray(new System[list.size()]);
	}
}

