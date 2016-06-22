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

public class ProjectDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression uniqueIdentifier;
	public final StringExpression name;
	public final IntegerExpression budget;
	
	public ProjectDetachedCriteria() {
		super(businesslogic.distribution.resource.Project.class, businesslogic.distribution.resource.ProjectCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		uniqueIdentifier = new StringExpression("uniqueIdentifier", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		budget = new IntegerExpression("budget", this.getDetachedCriteria());
	}
	
	public ProjectDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, businesslogic.distribution.resource.ProjectCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		uniqueIdentifier = new StringExpression("uniqueIdentifier", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		budget = new IntegerExpression("budget", this.getDetachedCriteria());
	}
	
	public Project uniqueProject(PersistentSession session) {
		return (Project) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Project[] listProject(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Project[]) list.toArray(new Project[list.size()]);
	}
}

