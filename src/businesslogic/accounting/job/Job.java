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
package businesslogic.accounting.job;

import businesslogic.accounting.Permission;
import businesslogic.utility.Tree;

public class Job {
	private Permission[] permissions;

	public Job() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == businesslogic.accounting.user.ORMConstants.KEY_JOB_USERJOBS) {
			return ORM_userJobs;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int ID;
	
	private java.util.Set ORM_userJobs = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	private void setORM_UserJobs(java.util.Set value) {
		this.ORM_userJobs = value;
	}
	
	private java.util.Set getORM_UserJobs() {
		return ORM_userJobs;
	}
	
	public final businesslogic.accounting.job.UserJobSetCollection userJobs = new businesslogic.accounting.job.UserJobSetCollection(this, _ormAdapter, businesslogic.accounting.user.ORMConstants.KEY_JOB_USERJOBS, businesslogic.accounting.user.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public businesslogic.accounting.Permission[] getPermissions() {
		return permissions;
	}
	
	public void setPermissions(businesslogic.accounting.Permission[] permissions) {
		this.permissions = permissions;
	}
	
	public Tree<String> getInfo() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}