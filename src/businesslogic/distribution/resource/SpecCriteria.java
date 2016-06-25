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

import businesslogic.accounting.job.UserJob;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMCriteria;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;

public class SpecCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression name;
	public final StringExpression value;
	
	public SpecCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		name = new StringExpression("name", this);
		value = new StringExpression("value", this);
	}
	
	public SpecCriteria(PersistentSession session) {
		this(session.createCriteria(Spec.class));
	}
	
	public SpecCriteria() throws PersistentException {
		this(businesslogic.accounting.user.OODPersistentManager.instance().getSession());
	}
	
	public Spec uniqueSpec() {
		return (Spec) super.uniqueResult();
	}
	
	public Spec[] listSpec() {
		java.util.List list = super.list();
		return (Spec[]) list.toArray(new Spec[list.size()]);
	}
}

