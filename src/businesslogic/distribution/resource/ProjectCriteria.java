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

public class ProjectCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression uniqueIdentifier;
	public final StringExpression name;
	public final IntegerExpression budget;
	
	public ProjectCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		uniqueIdentifier = new StringExpression("uniqueIdentifier", this);
		name = new StringExpression("name", this);
		budget = new IntegerExpression("budget", this);
	}
	
	public ProjectCriteria(PersistentSession session) {
		this(session.createCriteria(Project.class));
	}
	
	public ProjectCriteria() throws PersistentException {
		this(businesslogic.distribution.resource.OODPersistentManager.instance().getSession());
	}
	
	public Project uniqueProject() {
		return (Project) super.uniqueResult();
	}
	
	public Project[] listProject() {
		java.util.List list = super.list();
		return (Project[]) list.toArray(new Project[list.size()]);
	}
}

