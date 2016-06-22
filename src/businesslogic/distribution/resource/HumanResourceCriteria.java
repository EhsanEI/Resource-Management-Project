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

public class HumanResourceCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression uniqueIdentifier;
	public final StringExpression name;
	
	public HumanResourceCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		uniqueIdentifier = new StringExpression("uniqueIdentifier", this);
		name = new StringExpression("name", this);
	}
	
	public HumanResourceCriteria(PersistentSession session) {
		this(session.createCriteria(HumanResource.class));
	}
	
	public HumanResourceCriteria() throws PersistentException {
		this(businesslogic.distribution.resource.OODPersistentManager.instance().getSession());
	}
	
	public HumanResource uniqueHumanResource() {
		return (HumanResource) super.uniqueResult();
	}
	
	public HumanResource[] listHumanResource() {
		java.util.List list = super.list();
		return (HumanResource[]) list.toArray(new HumanResource[list.size()]);
	}
}

