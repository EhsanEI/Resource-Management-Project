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

public class Job {
	public Job() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == businesslogic.distribution.resource.ORMConstants.KEY_JOB_PERMISSION) {
			return ORM_permission;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int ID;
	
	private java.util.Set ORM_permission = new java.util.HashSet();
	
	
	public int getORMID() {
		return getID();
	}
	
	public void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	private void setORM_Permission(java.util.Set value) {
		this.ORM_permission = value;
	}
	
	private java.util.Set getORM_Permission() {
		return ORM_permission;
	}
	
	public final businesslogic.accounting.PermissionSetCollection permission = new businesslogic.accounting.PermissionSetCollection(this, _ormAdapter, businesslogic.distribution.resource.ORMConstants.KEY_JOB_PERMISSION, businesslogic.distribution.resource.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public businesslogic.accounting.Permission[] getPermissions() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setPermissions(businesslogic.accounting.Permission[] permissions) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
