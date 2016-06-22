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
package businesslogic.distribution.requirement;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class RequirementCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression resourceName;
	public final StringExpression resourceType;
	public final IntegerExpression quantity;
	public final CollectionExpression date;
	
	public RequirementCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		resourceName = new StringExpression("resourceName", this);
		resourceType = new StringExpression("resourceType", this);
		quantity = new IntegerExpression("quantity", this);
		date = new CollectionExpression("ORM_Date", this);
	}
	
	public RequirementCriteria(PersistentSession session) {
		this(session.createCriteria(Requirement.class));
	}
	
	public RequirementCriteria() throws PersistentException {
		this(businesslogic.distribution.resource.OODPersistentManager.instance().getSession());
	}
	
	public businesslogic.utility.DateCriteria createDateCriteria() {
		return new businesslogic.utility.DateCriteria(createCriteria("ORM_Date"));
	}
	
	public Requirement uniqueRequirement() {
		return (Requirement) super.uniqueResult();
	}
	
	public Requirement[] listRequirement() {
		java.util.List list = super.list();
		return (Requirement[]) list.toArray(new Requirement[list.size()]);
	}
}

