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
package businesslogic.accounting.user;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class EmployeeDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression username;
	public final StringExpression password;
	public final StringExpression email;
	public final BooleanExpression approved;
	public final CollectionExpression permission;
	
	public EmployeeDetachedCriteria() {
		super(businesslogic.accounting.user.Employee.class, businesslogic.accounting.user.EmployeeCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		username = new StringExpression("username", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		approved = new BooleanExpression("approved", this.getDetachedCriteria());
		permission = new CollectionExpression("ORM_Permission", this.getDetachedCriteria());
	}
	
	public EmployeeDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, businesslogic.accounting.user.EmployeeCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		username = new StringExpression("username", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		approved = new BooleanExpression("approved", this.getDetachedCriteria());
		permission = new CollectionExpression("ORM_Permission", this.getDetachedCriteria());
	}
	
	public businesslogic.accounting.PermissionDetachedCriteria createPermissionCriteria() {
		return new businesslogic.accounting.PermissionDetachedCriteria(createCriteria("ORM_Permission"));
	}
	
	public Employee uniqueEmployee(PersistentSession session) {
		return (Employee) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Employee[] listEmployee(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Employee[]) list.toArray(new Employee[list.size()]);
	}
}

