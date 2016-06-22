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

public class User {
	public User() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == businesslogic.distribution.resource.ORMConstants.KEY_USER_PERMISSION) {
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
	
	private String username;
	
	private String password;
	
	private String email;
	
	private boolean approved;
	
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
	
	public void setUsername(String value) {
		this.username = value;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setApproved(boolean value) {
		this.approved = value;
	}
	
	public boolean getApproved() {
		return approved;
	}
	
	private void setORM_Permission(java.util.Set value) {
		this.ORM_permission = value;
	}
	
	private java.util.Set getORM_Permission() {
		return ORM_permission;
	}
	
	public final businesslogic.accounting.PermissionSetCollection permission = new businesslogic.accounting.PermissionSetCollection(this, _ormAdapter, businesslogic.distribution.resource.ORMConstants.KEY_USER_PERMISSION, businesslogic.distribution.resource.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public businesslogic.accounting.job.Job[] getJobs() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setJobs(int[] Job) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void addJob(businesslogic.accounting.job.Job job) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void deleteJob(businesslogic.accounting.job.Job job) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void approve() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public businesslogic.accounting.Permission[] getPermissions() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void addPermission(businesslogic.accounting.Permission permission) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void sendPassword() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public businesslogic.accounting.user.User getCreatorUser() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setCreatorUser(businesslogic.accounting.user.User creatorUser) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
