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
package businesslogic.support;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class BackupFormatDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public BackupFormatDetachedCriteria() {
		super(businesslogic.support.BackupFormat.class, businesslogic.support.BackupFormatCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public BackupFormatDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, businesslogic.support.BackupFormatCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public BackupFormat uniqueBackupFormat(PersistentSession session) {
		return (BackupFormat) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public BackupFormat[] listBackupFormat(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (BackupFormat[]) list.toArray(new BackupFormat[list.size()]);
	}
}

