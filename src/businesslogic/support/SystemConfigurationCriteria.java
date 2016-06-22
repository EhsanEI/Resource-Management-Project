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

public class SystemConfigurationCriteria extends AbstractORMCriteria {
	public final IntegerExpression backupFormatId;
	public final AssociationExpression backupFormat;
	public final IntegerExpression dateId;
	public final AssociationExpression date;
	public final IntegerExpression ID;
	public final IntegerExpression backupPreiodDays;
	
	public SystemConfigurationCriteria(Criteria criteria) {
		super(criteria);
		backupFormatId = new IntegerExpression("backupFormat.ID", this);
		backupFormat = new AssociationExpression("backupFormat", this);
		dateId = new IntegerExpression("date.ID", this);
		date = new AssociationExpression("date", this);
		ID = new IntegerExpression("ID", this);
		backupPreiodDays = new IntegerExpression("backupPreiodDays", this);
	}
	
	public SystemConfigurationCriteria(PersistentSession session) {
		this(session.createCriteria(SystemConfiguration.class));
	}
	
	public SystemConfigurationCriteria() throws PersistentException {
		this(businesslogic.distribution.resource.OODPersistentManager.instance().getSession());
	}
	
	public BackupFormatCriteria createBackupFormatCriteria() {
		return new BackupFormatCriteria(createCriteria("backupFormat"));
	}
	
	public businesslogic.utility.DateCriteria createDateCriteria() {
		return new businesslogic.utility.DateCriteria(createCriteria("date"));
	}
	
	public SystemConfiguration uniqueSystemConfiguration() {
		return (SystemConfiguration) super.uniqueResult();
	}
	
	public SystemConfiguration[] listSystemConfiguration() {
		java.util.List list = super.list();
		return (SystemConfiguration[]) list.toArray(new SystemConfiguration[list.size()]);
	}
}

