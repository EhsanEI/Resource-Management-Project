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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class EmployeeCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression username;
	public final StringExpression password;
	public final StringExpression email;
	public final BooleanExpression approved;
	public final CollectionExpression permission;
	
	public EmployeeCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		username = new StringExpression("username", this);
		password = new StringExpression("password", this);
		email = new StringExpression("email", this);
		approved = new BooleanExpression("approved", this);
		permission = new CollectionExpression("ORM_Permission", this);
	}
	
	public EmployeeCriteria(PersistentSession session) {
		this(session.createCriteria(Employee.class));
	}
	
	public EmployeeCriteria() throws PersistentException {
		this(businesslogic.distribution.resource.OODPersistentManager.instance().getSession());
	}
	
	public businesslogic.accounting.PermissionCriteria createPermissionCriteria() {
		return new businesslogic.accounting.PermissionCriteria(createCriteria("ORM_Permission"));
	}
	
	public Employee uniqueEmployee() {
		return (Employee) super.uniqueResult();
	}
	
	public Employee[] listEmployee() {
		java.util.List list = super.list();
		return (Employee[]) list.toArray(new Employee[list.size()]);
	}
}

