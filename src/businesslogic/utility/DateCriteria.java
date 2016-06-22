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

public class DateCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression second;
	public final IntegerExpression minute;
	public final IntegerExpression hour;
	public final IntegerExpression day;
	public final IntegerExpression month;
	public final IntegerExpression year;
	
	public DateCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		second = new IntegerExpression("second", this);
		minute = new IntegerExpression("minute", this);
		hour = new IntegerExpression("hour", this);
		day = new IntegerExpression("day", this);
		month = new IntegerExpression("month", this);
		year = new IntegerExpression("year", this);
	}
	
	public DateCriteria(PersistentSession session) {
		this(session.createCriteria(Date.class));
	}
	
	public DateCriteria() throws PersistentException {
		this(businesslogic.distribution.resource.OODPersistentManager.instance().getSession());
	}
	
	public Date uniqueDate() {
		return (Date) super.uniqueResult();
	}
	
	public Date[] listDate() {
		java.util.List list = super.list();
		return (Date[]) list.toArray(new Date[list.size()]);
	}
}

