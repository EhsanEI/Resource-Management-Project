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

public class ResourceDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression uniqueIdentifier;
	public final StringExpression name;
	
	public ResourceDetachedCriteria() {
		super(businesslogic.distribution.resource.Resource.class, businesslogic.distribution.resource.ResourceCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		uniqueIdentifier = new StringExpression("uniqueIdentifier", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public ResourceDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, businesslogic.distribution.resource.ResourceCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		uniqueIdentifier = new StringExpression("uniqueIdentifier", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public Resource uniqueResource(PersistentSession session) {
		return (Resource) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Resource[] listResource(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Resource[]) list.toArray(new Resource[list.size()]);
	}
}

