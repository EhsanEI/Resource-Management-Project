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

public class ModuleDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression uniqueIdentifier;
	public final StringExpression name;
	public final StringExpression description;
	public final IntegerExpression linesOfCode;
	public final CollectionExpression moduleSpecialty;
	
	public ModuleDetachedCriteria() {
		super(businesslogic.distribution.resource.Module.class, businesslogic.distribution.resource.ModuleCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		uniqueIdentifier = new StringExpression("uniqueIdentifier", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		linesOfCode = new IntegerExpression("linesOfCode", this.getDetachedCriteria());
		moduleSpecialty = new CollectionExpression("ORM_ModuleSpecialty", this.getDetachedCriteria());
	}
	
	public ModuleDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, businesslogic.distribution.resource.ModuleCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		uniqueIdentifier = new StringExpression("uniqueIdentifier", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		linesOfCode = new IntegerExpression("linesOfCode", this.getDetachedCriteria());
		moduleSpecialty = new CollectionExpression("ORM_ModuleSpecialty", this.getDetachedCriteria());
	}
	
	public businesslogic.distribution.resource.ModuleSpecialtyDetachedCriteria createModuleSpecialtyCriteria() {
		return new businesslogic.distribution.resource.ModuleSpecialtyDetachedCriteria(createCriteria("ORM_ModuleSpecialty"));
	}
	
	public Module uniqueModule(PersistentSession session) {
		return (Module) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Module[] listModule(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Module[]) list.toArray(new Module[list.size()]);
	}
}

