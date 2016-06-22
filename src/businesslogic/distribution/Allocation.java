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
package businesslogic.distribution;

import businesslogic.distribution.resource.Resource;

public class Allocation {
	public Allocation() {
	}
	
	private int ID;
	
	private boolean allocated;
	
	
	public int getORMID() {
		return getID();
	}
	
	public void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setAllocated(boolean value) {
		this.allocated = value;
	}
	
	public boolean getAllocated() {
		return allocated;
	}
	
	public businesslogic.distribution.requirement.Requirement getRequirement() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setRequirement(businesslogic.distribution.requirement.Requirement requirement) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public Resource[] getResources() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setResources(Resource[] resources) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
