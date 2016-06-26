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

public class ModuleChangeCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression dateId;
	public final AssociationExpression date;
	public final StringExpression description;
	public final StringExpression startDate;
	public final StringExpression endDate;
	
	public ModuleChangeCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		dateId = new IntegerExpression("date.ID", this);
		date = new AssociationExpression("date", this);
		description = new StringExpression("description", this);
		startDate = new StringExpression("startDate", this);
		endDate = new StringExpression("endDate", this);
	}
	
	public ModuleChangeCriteria(PersistentSession session) {
		this(session.createCriteria(ModuleChange.class));
	}
	
	public ModuleChangeCriteria() throws PersistentException {
		this(businesslogic.accounting.user.OODPersistentManager.instance().getSession());
	}
	
	public businesslogic.utility.DateCriteria createDateCriteria() {
		return new businesslogic.utility.DateCriteria(createCriteria("date"));
	}
	
	public ModuleChange uniqueModuleChange() {
		return (ModuleChange) super.uniqueResult();
	}
	
	public ModuleChange[] listModuleChange() {
		java.util.List list = super.list();
		return (ModuleChange[]) list.toArray(new ModuleChange[list.size()]);
	}
}

