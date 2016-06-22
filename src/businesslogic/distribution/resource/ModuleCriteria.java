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

public class ModuleCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression uniqueIdentifier;
	public final StringExpression name;
	public final StringExpression description;
	public final IntegerExpression linesOfCode;
	public final CollectionExpression moduleSpecialty;
	
	public ModuleCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		uniqueIdentifier = new StringExpression("uniqueIdentifier", this);
		name = new StringExpression("name", this);
		description = new StringExpression("description", this);
		linesOfCode = new IntegerExpression("linesOfCode", this);
		moduleSpecialty = new CollectionExpression("ORM_ModuleSpecialty", this);
	}
	
	public ModuleCriteria(PersistentSession session) {
		this(session.createCriteria(Module.class));
	}
	
	public ModuleCriteria() throws PersistentException {
		this(businesslogic.distribution.resource.OODPersistentManager.instance().getSession());
	}
	
	public businesslogic.distribution.resource.ModuleSpecialtyCriteria createModuleSpecialtyCriteria() {
		return new businesslogic.distribution.resource.ModuleSpecialtyCriteria(createCriteria("ORM_ModuleSpecialty"));
	}
	
	public Module uniqueModule() {
		return (Module) super.uniqueResult();
	}
	
	public Module[] listModule() {
		java.util.List list = super.list();
		return (Module[]) list.toArray(new Module[list.size()]);
	}
}

