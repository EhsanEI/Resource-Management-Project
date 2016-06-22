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

public class InformationResourceDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression uniqueIdentifier;
	public final StringExpression name;
	
	public InformationResourceDetachedCriteria() {
		super(businesslogic.distribution.resource.InformationResource.class, businesslogic.distribution.resource.InformationResourceCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		uniqueIdentifier = new StringExpression("uniqueIdentifier", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public InformationResourceDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, businesslogic.distribution.resource.InformationResourceCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		uniqueIdentifier = new StringExpression("uniqueIdentifier", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public InformationResource uniqueInformationResource(PersistentSession session) {
		return (InformationResource) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public InformationResource[] listInformationResource(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (InformationResource[]) list.toArray(new InformationResource[list.size()]);
	}
}

