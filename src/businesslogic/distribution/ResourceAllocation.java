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

public class ResourceAllocation {
	public ResourceAllocation() {
	}
	
	private int ID;

	private Resource resource;

	private Allocation allocation;

	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public businesslogic.distribution.resource.Resource getResource() {
		return resource;
	}
	
	public void setResource(businesslogic.distribution.resource.Resource resource) {
		this.resource = resource;
	}
	
	public Allocation getAllocation() {
		return allocation;
	}
	
	public void setAllocation(businesslogic.distribution.Allocation  allocation) {
		this.allocation = allocation;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
