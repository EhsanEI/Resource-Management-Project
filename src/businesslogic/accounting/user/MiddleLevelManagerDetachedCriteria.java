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

public class MiddleLevelManagerDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression userId;
	public final AssociationExpression user;
	public final StringExpression username;
	public final StringExpression password;
	public final StringExpression email;
	public final BooleanExpression approved;
	public final CollectionExpression emails;
	public final CollectionExpression userJobs;
	public final CollectionExpression jobs;
	public final CollectionExpression users;
	
	public MiddleLevelManagerDetachedCriteria() {
		super(businesslogic.accounting.user.MiddleLevelManager.class, businesslogic.accounting.user.MiddleLevelManagerCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		userId = new IntegerExpression("user.ID", this.getDetachedCriteria());
		user = new AssociationExpression("user", this.getDetachedCriteria());
		username = new StringExpression("username", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		approved = new BooleanExpression("approved", this.getDetachedCriteria());
		emails = new CollectionExpression("ORM_Emails", this.getDetachedCriteria());
		userJobs = new CollectionExpression("ORM_UserJobs", this.getDetachedCriteria());
		jobs = new CollectionExpression("ORM_Jobs", this.getDetachedCriteria());
		users = new CollectionExpression("ORM_Users", this.getDetachedCriteria());
	}
	
	public MiddleLevelManagerDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, businesslogic.accounting.user.MiddleLevelManagerCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		userId = new IntegerExpression("user.ID", this.getDetachedCriteria());
		user = new AssociationExpression("user", this.getDetachedCriteria());
		username = new StringExpression("username", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		approved = new BooleanExpression("approved", this.getDetachedCriteria());
		emails = new CollectionExpression("ORM_Emails", this.getDetachedCriteria());
		userJobs = new CollectionExpression("ORM_UserJobs", this.getDetachedCriteria());
		jobs = new CollectionExpression("ORM_Jobs", this.getDetachedCriteria());
		users = new CollectionExpression("ORM_Users", this.getDetachedCriteria());
	}
	
	public businesslogic.accounting.job.JobDetachedCriteria createJobsCriteria() {
		return new businesslogic.accounting.job.JobDetachedCriteria(createCriteria("ORM_Jobs"));
	}
	
	public businesslogic.accounting.user.UserDetachedCriteria createUsersCriteria() {
		return new businesslogic.accounting.user.UserDetachedCriteria(createCriteria("ORM_Users"));
	}
	
	public businesslogic.accounting.user.UserDetachedCriteria createUserCriteria() {
		return new businesslogic.accounting.user.UserDetachedCriteria(createCriteria("user"));
	}
	
	public network.EmailDetachedCriteria createEmailsCriteria() {
		return new network.EmailDetachedCriteria(createCriteria("ORM_Emails"));
	}
	
	public businesslogic.accounting.job.UserJobDetachedCriteria createUserJobsCriteria() {
		return new businesslogic.accounting.job.UserJobDetachedCriteria(createCriteria("ORM_UserJobs"));
	}
	
	public MiddleLevelManager uniqueMiddleLevelManager(PersistentSession session) {
		return (MiddleLevelManager) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public MiddleLevelManager[] listMiddleLevelManager(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (MiddleLevelManager[]) list.toArray(new MiddleLevelManager[list.size()]);
	}
}

