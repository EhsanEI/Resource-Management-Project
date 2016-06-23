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

public class Admin extends businesslogic.accounting.user.User {
	public Admin() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == businesslogic.accounting.user.ORMConstants.KEY_ADMIN_SYSTEMCONFIGURATIONS) {
			return ORM_systemConfigurations;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private java.util.Set ORM_systemConfigurations = new java.util.HashSet();
	
	private void setORM_SystemConfigurations(java.util.Set value) {
		this.ORM_systemConfigurations = value;
	}
	
	private java.util.Set getORM_SystemConfigurations() {
		return ORM_systemConfigurations;
	}
	
	public final businesslogic.support.SystemConfigurationSetCollection systemConfigurations = new businesslogic.support.SystemConfigurationSetCollection(this, _ormAdapter, businesslogic.accounting.user.ORMConstants.KEY_ADMIN_SYSTEMCONFIGURATIONS, businesslogic.accounting.user.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public Admin(String username, String password, String email, businesslogic.accounting.job.Job[] jobs) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void configureSystem(businesslogic.utility.Date date, businesslogic.support.BackupFormat backupFormat, int backupPeriodDays) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return super.toString();
	}
	
}
