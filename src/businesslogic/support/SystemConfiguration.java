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

import businesslogic.utility.Date;

public class SystemConfiguration {
	public SystemConfiguration() {
	}
	
	private int ID;

	private Date date;
	
	private int backupPreiodDays;

	private BackupFormat backupFormat;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setBackupPreiodDays(int value) {
		this.backupPreiodDays = value;
	}
	
	public int getBackupPreiodDays() {
		return backupPreiodDays;
	}
	
	public businesslogic.utility.Date getDate() {
		return date;
	}
	
	public void setDate(businesslogic.utility.Date date) {
		this.date = date;
	}
	
	public BackupFormat getBackupFormat() {
		return backupFormat;
	}
	
	public void setBackupFormat(BackupFormat backupFormat) {
		this.backupFormat = backupFormat;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
