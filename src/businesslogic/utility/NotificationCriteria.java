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
package businesslogic.utility;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class NotificationCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression content;
	
	public NotificationCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		content = new StringExpression("content", this);
	}
	
	public NotificationCriteria(PersistentSession session) {
		this(session.createCriteria(Notification.class));
	}
	
	public NotificationCriteria() throws PersistentException {
		this(businesslogic.distribution.resource.OODPersistentManager.instance().getSession());
	}
	
	public Notification uniqueNotification() {
		return (Notification) super.uniqueResult();
	}
	
	public Notification[] listNotification() {
		java.util.List list = super.list();
		return (Notification[]) list.toArray(new Notification[list.size()]);
	}
}

