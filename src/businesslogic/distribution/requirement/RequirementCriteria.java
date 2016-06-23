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
	public final IntegerExpression requirementPriorityId;
	public final AssociationExpression requirementPriority;
	public final StringExpression resourceName;
	public final StringExpression resourceType;
	public final IntegerExpression quantity;
	
	public RequirementCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		requirementPriorityId = new IntegerExpression("requirementPriority.ID", this);
		requirementPriority = new AssociationExpression("requirementPriority", this);
		resourceName = new StringExpression("resourceName", this);
		resourceType = new StringExpression("resourceType", this);
		quantity = new IntegerExpression("quantity", this);
	}
	
	public RequirementCriteria(PersistentSession session) {
		this(session.createCriteria(Requirement.class));
	}
	
	public RequirementCriteria() throws PersistentException {
		this(businesslogic.accounting.user.OODPersistentManager.instance().getSession());
	}
	
	public RequirementPriorityCriteria createRequirementPriorityCriteria() {
		return new RequirementPriorityCriteria(createCriteria("requirementPriority"));
	}
	
	public Requirement uniqueRequirement() {
		return (Requirement) super.uniqueResult();
	}
	
	public Requirement[] listRequirement() {
		java.util.List list = super.list();
		return (Requirement[]) list.toArray(new Requirement[list.size()]);
	}
}

