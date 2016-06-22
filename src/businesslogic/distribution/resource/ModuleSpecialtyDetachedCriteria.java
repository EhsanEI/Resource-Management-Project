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

public class ModuleSpecialtyDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression specialtyId;
	public final AssociationExpression specialty;
	public final IntegerExpression ID;
	
	public ModuleSpecialtyDetachedCriteria() {
		super(businesslogic.distribution.resource.ModuleSpecialty.class, businesslogic.distribution.resource.ModuleSpecialtyCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		specialtyId = new IntegerExpression("specialty.ID", this.getDetachedCriteria());
		specialty = new AssociationExpression("specialty", this.getDetachedCriteria());
	}
	
	public ModuleSpecialtyDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, businesslogic.distribution.resource.ModuleSpecialtyCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		specialtyId = new IntegerExpression("specialty.ID", this.getDetachedCriteria());
		specialty = new AssociationExpression("specialty", this.getDetachedCriteria());
	}
	
	public businesslogic.accounting.job.SpecialtyDetachedCriteria createSpecialtyCriteria() {
		return new businesslogic.accounting.job.SpecialtyDetachedCriteria(createCriteria("specialty"));
	}
	
	public ModuleSpecialty uniqueModuleSpecialty(PersistentSession session) {
		return (ModuleSpecialty) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public ModuleSpecialty[] listModuleSpecialty(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (ModuleSpecialty[]) list.toArray(new ModuleSpecialty[list.size()]);
	}
}

