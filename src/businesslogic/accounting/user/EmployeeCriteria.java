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
import org.orm.criteria.AbstractORMCriteria;
import org.orm.criteria.AssociationExpression;
import org.orm.criteria.BooleanExpression;
import org.orm.criteria.CollectionExpression;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;

import orm.OODPersistentManager;

public class EmployeeCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression userId;
	public final AssociationExpression user;
	public final StringExpression username;
	public final StringExpression password;
	public final StringExpression email;
	public final BooleanExpression approved;
	public final CollectionExpression emails;
	public final CollectionExpression userJobs;
	
	public EmployeeCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		userId = new IntegerExpression("user.ID", this);
		user = new AssociationExpression("user", this);
		username = new StringExpression("username", this);
		password = new StringExpression("password", this);
		email = new StringExpression("email", this);
		approved = new BooleanExpression("approved", this);
		emails = new CollectionExpression("ORM_Emails", this);
		userJobs = new CollectionExpression("ORM_UserJobs", this);
	}
	
	public EmployeeCriteria(PersistentSession session) {
		this(session.createCriteria(Employee.class));
	}
	
	public EmployeeCriteria() throws PersistentException {
		this(OODPersistentManager.instance().getSession());
	}
	
	public UserCriteria createUserCriteria() {
		return new UserCriteria(createCriteria("user"));
	}
	
	public network.EmailCriteria createEmailsCriteria() {
		return new network.EmailCriteria(createCriteria("ORM_Emails"));
	}
	
	public businesslogic.accounting.job.UserJobCriteria createUserJobsCriteria() {
		return new businesslogic.accounting.job.UserJobCriteria(createCriteria("ORM_UserJobs"));
	}
	
	public Employee uniqueEmployee() {
		return (Employee) super.uniqueResult();
	}
	
	public Employee[] listEmployee() {
		java.util.List list = super.list();
		return (Employee[]) list.toArray(new Employee[list.size()]);
	}
}

