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
	public final StringExpression description;
	
	public ModuleChangeCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		description = new StringExpression("description", this);
	}
	
	public ModuleChangeCriteria(PersistentSession session) {
		this(session.createCriteria(ModuleChange.class));
	}
	
	public ModuleChangeCriteria() throws PersistentException {
		this(businesslogic.distribution.resource.OODPersistentManager.instance().getSession());
	}
	
	public ModuleChange uniqueModuleChange() {
		return (ModuleChange) super.uniqueResult();
	}
	
	public ModuleChange[] listModuleChange() {
		java.util.List list = super.list();
		return (ModuleChange[]) list.toArray(new ModuleChange[list.size()]);
	}
}

