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
package network;

public class Email {
	
	private int ID;
	
	private String content;
	
	private String address;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setContent(String value) {
		this.content = value;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setAddress(String value) {
		this.address = value;
	}
	
	public String getAddress() {
		return address;
	}
	
	public Email(businesslogic.utility.Notification notification, String address) {
		//TODO create html
		this.content = notification.getContent();
		this.address = address;
	}
	
	public Email(String content, String address) {
		this.content = content;
		this.address = address;
	}

	public void send() {
		//TODO implement
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}