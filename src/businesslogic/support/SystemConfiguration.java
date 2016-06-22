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

public class SystemConfiguration {
	public SystemConfiguration() {
	}
	
	private businesslogic.support.BackupFormat backupFormat;
	
	private businesslogic.utility.Date date;
	
	private int ID;
	
	private int backupPreiodDays;
	
	public int getORMID() {
		return getID();
	}
	
	public void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setBackupPreiodDays(int value) {
		this.backupPreiodDays = value;
	}
	
	public int getBackupPreiodDays() {
		return backupPreiodDays;
	}
	
	public void setDate(businesslogic.utility.Date value) {
		this.date = value;
	}
	
	public businesslogic.utility.Date getDate() {
		return date;
	}
	
	public void setBackupFormat(businesslogic.support.BackupFormat value) {
		this.backupFormat = value;
	}
	
	public businesslogic.support.BackupFormat getBackupFormat() {
		return backupFormat;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
