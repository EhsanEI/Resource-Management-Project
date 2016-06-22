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

public class ModuleSpecialtyCriteria extends AbstractORMCriteria {
	public final IntegerExpression specialtyId;
	public final AssociationExpression specialty;
	public final IntegerExpression ID;
	
	public ModuleSpecialtyCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		specialtyId = new IntegerExpression("specialty.ID", this);
		specialty = new AssociationExpression("specialty", this);
	}
	
	public ModuleSpecialtyCriteria(PersistentSession session) {
		this(session.createCriteria(ModuleSpecialty.class));
	}
	
	public ModuleSpecialtyCriteria() throws PersistentException {
		this(businesslogic.distribution.resource.OODPersistentManager.instance().getSession());
	}
	
	public businesslogic.accounting.job.SpecialtyCriteria createSpecialtyCriteria() {
		return new businesslogic.accounting.job.SpecialtyCriteria(createCriteria("specialty"));
	}
	
	public ModuleSpecialty uniqueModuleSpecialty() {
		return (ModuleSpecialty) super.uniqueResult();
	}
	
	public ModuleSpecialty[] listModuleSpecialty() {
		java.util.List list = super.list();
		return (ModuleSpecialty[]) list.toArray(new ModuleSpecialty[list.size()]);
	}
}

