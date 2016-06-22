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

public class PhysicalResourceCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression uniqueIdentifier;
	public final StringExpression name;
	
	public PhysicalResourceCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		uniqueIdentifier = new StringExpression("uniqueIdentifier", this);
		name = new StringExpression("name", this);
	}
	
	public PhysicalResourceCriteria(PersistentSession session) {
		this(session.createCriteria(PhysicalResource.class));
	}
	
	public PhysicalResourceCriteria() throws PersistentException {
		this(businesslogic.distribution.resource.OODPersistentManager.instance().getSession());
	}
	
	public PhysicalResource uniquePhysicalResource() {
		return (PhysicalResource) super.uniqueResult();
	}
	
	public PhysicalResource[] listPhysicalResource() {
		java.util.List list = super.list();
		return (PhysicalResource[]) list.toArray(new PhysicalResource[list.size()]);
	}
}

