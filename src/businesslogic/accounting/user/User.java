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

import businesslogic.accounting.Permission;
import businesslogic.accounting.PermissionDAO;
import businesslogic.accounting.PermissionTitles;
import businesslogic.accounting.job.*;
import businesslogic.utility.Tree;
import network.Email;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import javax.mail.MessagingException;
import java.io.Serializable;
import java.util.*;

public class User implements Serializable {
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
		else if (key == ORMConstants.KEY_USER_USERPERMISSIONS) {
			return ORM_userPermissions;
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

	private java.util.Set ORM_userPermissions = new java.util.HashSet();
	
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
	
	private void setUser(businesslogic.accounting.user.User value) {
		this.user = value;
	}
	
	private businesslogic.accounting.user.User getUser() {
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


	public void setORM_UserPermissions(java.util.Set value) {
		this.ORM_userPermissions = value;
	}

	public java.util.Set getORM_UserPermissions() {
		return ORM_userPermissions;
	}

	public final businesslogic.accounting.job.UserPermissionSetCollection userPermissions = new businesslogic.accounting.job.UserPermissionSetCollection(this, _ormAdapter, businesslogic.accounting.user.ORMConstants.KEY_USER_USERPERMISSIONS, businesslogic.accounting.user.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public businesslogic.accounting.job.Job[] getJobs() {
		try {
			PersistentSession session = OODPersistentManager.instance().getSession();
			List<Integer> jobIDs = session
					.createSQLQuery("SELECT JobID FROM UserJob WHERE UserID = "+ getID()).list();
			ArrayList<Job> result = new ArrayList<>();
			for(int jID:jobIDs) {
				result.add(JobDAO.getJobByORMID(jID));
			}
			return result.toArray(new Job[result.size()]);
		}
		catch(PersistentException ex) {
			ex.printStackTrace();
		}
		return new Job[0];
	}
	
	public void addJob(businesslogic.accounting.job.Job job) {
		UserJob uj = UserJobDAO.createUserJob();
		getORM_UserJobs().add(uj);
		job.getORM_UserJobs().add(uj);
	}
	
	public void deleteJob(businesslogic.accounting.job.Job job) {
		getORM_UserJobs().remove(job);
	}
	
	public void approve() {
		setApproved(true);
	}
	
	public void sendPassword(String password) throws MessagingException {
		Email email = new Email(password, getEmail());
		email.send();
	}

	public businesslogic.accounting.user.User getCreatorUser() {
		return getUser();
	}

	public void setCreatorUser(businesslogic.accounting.user.User creatorUser) {
		setUser(creatorUser);
	}

	public Tree<String> getJobInfo() {
		Tree<String> info = new Tree<>("User");
		for(Job job: getJobs()) {
			info.addChild(job.getInfo());
		}
		return info;
	}

	public PermissionTitles[] getPermissions() {
		Set<PermissionTitles> permissions = new HashSet<>();
		for(Job job: getJobs()) {
			permissions.addAll(Arrays.asList(job.getPermissions()));
		}
		return permissions.toArray(new PermissionTitles[permissions.size()]);
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
