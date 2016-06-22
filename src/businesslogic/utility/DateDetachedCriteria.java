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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class DateDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression second;
	public final IntegerExpression minute;
	public final IntegerExpression hour;
	public final IntegerExpression day;
	public final IntegerExpression month;
	public final IntegerExpression year;
	
	public DateDetachedCriteria() {
		super(businesslogic.utility.Date.class, businesslogic.utility.DateCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		second = new IntegerExpression("second", this.getDetachedCriteria());
		minute = new IntegerExpression("minute", this.getDetachedCriteria());
		hour = new IntegerExpression("hour", this.getDetachedCriteria());
		day = new IntegerExpression("day", this.getDetachedCriteria());
		month = new IntegerExpression("month", this.getDetachedCriteria());
		year = new IntegerExpression("year", this.getDetachedCriteria());
	}
	
	public DateDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, businesslogic.utility.DateCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		second = new IntegerExpression("second", this.getDetachedCriteria());
		minute = new IntegerExpression("minute", this.getDetachedCriteria());
		hour = new IntegerExpression("hour", this.getDetachedCriteria());
		day = new IntegerExpression("day", this.getDetachedCriteria());
		month = new IntegerExpression("month", this.getDetachedCriteria());
		year = new IntegerExpression("year", this.getDetachedCriteria());
	}
	
	public Date uniqueDate(PersistentSession session) {
		return (Date) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Date[] listDate(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Date[]) list.toArray(new Date[list.size()]);
	}
}

