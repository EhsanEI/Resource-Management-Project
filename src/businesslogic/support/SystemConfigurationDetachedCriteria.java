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

public class SystemConfigurationDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression backupFormatId;
	public final AssociationExpression backupFormat;
	public final IntegerExpression dateId;
	public final AssociationExpression date;
	public final IntegerExpression ID;
	public final IntegerExpression backupPreiodDays;
	
	public SystemConfigurationDetachedCriteria() {
		super(businesslogic.support.SystemConfiguration.class, businesslogic.support.SystemConfigurationCriteria.class);
		backupFormatId = new IntegerExpression("backupFormat.ID", this.getDetachedCriteria());
		backupFormat = new AssociationExpression("backupFormat", this.getDetachedCriteria());
		dateId = new IntegerExpression("date.ID", this.getDetachedCriteria());
		date = new AssociationExpression("date", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		backupPreiodDays = new IntegerExpression("backupPreiodDays", this.getDetachedCriteria());
	}
	
	public SystemConfigurationDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, businesslogic.support.SystemConfigurationCriteria.class);
		backupFormatId = new IntegerExpression("backupFormat.ID", this.getDetachedCriteria());
		backupFormat = new AssociationExpression("backupFormat", this.getDetachedCriteria());
		dateId = new IntegerExpression("date.ID", this.getDetachedCriteria());
		date = new AssociationExpression("date", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		backupPreiodDays = new IntegerExpression("backupPreiodDays", this.getDetachedCriteria());
	}
	
	public businesslogic.support.BackupFormatDetachedCriteria createBackupFormatCriteria() {
		return new businesslogic.support.BackupFormatDetachedCriteria(createCriteria("backupFormat"));
	}
	
	public businesslogic.utility.DateDetachedCriteria createDateCriteria() {
		return new businesslogic.utility.DateDetachedCriteria(createCriteria("date"));
	}
	
	public SystemConfiguration uniqueSystemConfiguration(PersistentSession session) {
		return (SystemConfiguration) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public SystemConfiguration[] listSystemConfiguration(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (SystemConfiguration[]) list.toArray(new SystemConfiguration[list.size()]);
	}
}

