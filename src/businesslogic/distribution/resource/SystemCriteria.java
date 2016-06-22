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

public class SystemCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression uniqueIdentifier;
	public final StringExpression name;
	public final StringExpression technologies;
	
	public SystemCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		uniqueIdentifier = new StringExpression("uniqueIdentifier", this);
		name = new StringExpression("name", this);
		technologies = new StringExpression("technologies", this);
	}
	
	public SystemCriteria(PersistentSession session) {
		this(session.createCriteria(System.class));
	}
	
	public SystemCriteria() throws PersistentException {
		this(businesslogic.distribution.resource.OODPersistentManager.instance().getSession());
	}
	
	public System uniqueSystem() {
		return (System) super.uniqueResult();
	}
	
	public System[] listSystem() {
		java.util.List list = super.list();
		return (System[]) list.toArray(new System[list.size()]);
	}
}

