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

public class ModuleStateCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public ModuleStateCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public ModuleStateCriteria(PersistentSession session) {
		this(session.createCriteria(ModuleState.class));
	}
	
	public ModuleStateCriteria() throws PersistentException {
		this(businesslogic.distribution.resource.OODPersistentManager.instance().getSession());
	}
	
	public ModuleState uniqueModuleState() {
		return (ModuleState) super.uniqueResult();
	}
	
	public ModuleState[] listModuleState() {
		java.util.List list = super.list();
		return (ModuleState[]) list.toArray(new ModuleState[list.size()]);
	}
}

