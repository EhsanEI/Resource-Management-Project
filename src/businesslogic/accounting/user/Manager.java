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

public class Manager extends businesslogic.accounting.user.User {
	public Manager() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == businesslogic.accounting.user.ORMConstants.KEY_MANAGER_JOBS) {
			return ORM_jobs;
		}
		else if (key == businesslogic.accounting.user.ORMConstants.KEY_MANAGER_USERS) {
			return ORM_users;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private java.util.Set ORM_jobs = new java.util.HashSet();
	
	private java.util.Set ORM_users = new java.util.HashSet();
	
	private void setORM_Jobs(java.util.Set value) {
		this.ORM_jobs = value;
	}
	
	private java.util.Set getORM_Jobs() {
		return ORM_jobs;
	}
	
	public final businesslogic.accounting.job.JobSetCollection jobs = new businesslogic.accounting.job.JobSetCollection(this, _ormAdapter, businesslogic.accounting.user.ORMConstants.KEY_MANAGER_JOBS, businesslogic.accounting.user.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setORM_Users(java.util.Set value) {
		this.ORM_users = value;
	}
	
	private java.util.Set getORM_Users() {
		return ORM_users;
	}
	
	public final businesslogic.accounting.user.UserSetCollection users = new businesslogic.accounting.user.UserSetCollection(this, _ormAdapter, businesslogic.accounting.user.ORMConstants.KEY_MANAGER_USERS, businesslogic.accounting.user.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
