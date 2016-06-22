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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class BackupFormatCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public BackupFormatCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public BackupFormatCriteria(PersistentSession session) {
		this(session.createCriteria(BackupFormat.class));
	}
	
	public BackupFormatCriteria() throws PersistentException {
		this(businesslogic.distribution.resource.OODPersistentManager.instance().getSession());
	}
	
	public BackupFormat uniqueBackupFormat() {
		return (BackupFormat) super.uniqueResult();
	}
	
	public BackupFormat[] listBackupFormat() {
		java.util.List list = super.list();
		return (BackupFormat[]) list.toArray(new BackupFormat[list.size()]);
	}
}

