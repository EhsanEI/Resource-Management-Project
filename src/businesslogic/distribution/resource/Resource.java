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
package businesslogic.distribution.resource;

public class Resource {
	public Resource() {
	}
	
	private int ID;
	
	private String uniqueIdentifier;
	
	private String name;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setUniqueIdentifier(String value) {
		this.uniqueIdentifier = value;
	}
	
	public String getUniqueIdentifier() {
		return uniqueIdentifier;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public Resource(int id, String name) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void allocate() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void deallocate() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setState(businesslogic.distribution.resource.ResourceState state) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
