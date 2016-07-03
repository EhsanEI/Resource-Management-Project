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
package businesslogic.accounting;

import businesslogic.accounting.user.ORMConstants;

public class Permission {
	public Permission() {
	}

	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_PERMISSION_USERPERMISSIONS) {
			return ORM_userPermissions;
		}

		return null;
	}

	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}

	};
	
	private int ID;

	private java.util.Set ORM_userPermissions = new java.util.HashSet();
	
	private String title;

	public void setORM_userPermissions(java.util.Set value) {
		this.ORM_userPermissions = value;
	}

	public java.util.Set getORM_userPermissions() {
		return ORM_userPermissions;
	}

	public final businesslogic.accounting.job.UserPermissionSetCollection userPermissions = new businesslogic.accounting.job.UserPermissionSetCollection(this, _ormAdapter, ORMConstants.KEY_PERMISSION_USERPERMISSIONS, businesslogic.accounting.user.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setTitle(String value) {
		this.title = value;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
