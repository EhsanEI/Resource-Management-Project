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

public class ModuleStateDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public ModuleStateDetachedCriteria() {
		super(businesslogic.distribution.resource.ModuleState.class, businesslogic.distribution.resource.ModuleStateCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public ModuleStateDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, businesslogic.distribution.resource.ModuleStateCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public ModuleState uniqueModuleState(PersistentSession session) {
		return (ModuleState) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public ModuleState[] listModuleState(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (ModuleState[]) list.toArray(new ModuleState[list.size()]);
	}
}

