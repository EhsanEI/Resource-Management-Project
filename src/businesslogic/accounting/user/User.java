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

import businesslogic.utility.Tree;

public class User {
	public User() {
		approved = false;
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == businesslogic.accounting.user.ORMConstants.KEY_USER_EMAILS) {
			return ORM_emails;
		}
		else if (key == businesslogic.accounting.user.ORMConstants.KEY_USER_USERJOBS) {
			return ORM_userJobs;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == businesslogic.accounting.user.ORMConstants.KEY_USER_USER) {
			this.user = (businesslogic.accounting.user.User) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private businesslogic.accounting.user.User user;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private boolean approved;
	
	private java.util.Set ORM_emails = new java.util.HashSet();
	
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
	
	public void setUser(businesslogic.accounting.user.User value) {
		this.user = value;
	}
	
	public businesslogic.accounting.user.User getUser() {
		return user;
	}
	
	private void setORM_Emails(java.util.Set value) {
		this.ORM_emails = value;
	}
	
	public java.util.Set getORM_Emails() {
		return ORM_emails;
	}
	
	public final network.EmailSetCollection emails = new network.EmailSetCollection(this, _ormAdapter, businesslogic.accounting.user.ORMConstants.KEY_USER_EMAILS, businesslogic.accounting.user.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setORM_UserJobs(java.util.Set value) {
		this.ORM_userJobs = value;
	}
	
	public java.util.Set getORM_UserJobs() {
		return ORM_userJobs;
	}
	
	public final businesslogic.accounting.job.UserJobSetCollection userJobs = new businesslogic.accounting.job.UserJobSetCollection(this, _ormAdapter, businesslogic.accounting.user.ORMConstants.KEY_USER_USERJOBS, businesslogic.accounting.user.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
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
		this.user = creatorUser;
	}

	public Tree<String> getJobInfo() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
