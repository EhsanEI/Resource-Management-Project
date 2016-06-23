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

import businesslogic.distribution.requirement.Requirement;
import businesslogic.distribution.resource.Resource;

public class Allocation {
	public Allocation(int ID) {
		this.ID = ID;
		this.allocated = false; //TODO really false?
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == businesslogic.accounting.user.ORMConstants.KEY_ALLOCATION__REQUIREMENTS) {
			return ORM_requirements;
		}
		else if (key == businesslogic.accounting.user.ORMConstants.KEY_ALLOCATION__RESOURCEALLOCATIONS) {
			return ORM_resourceAllocations;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int ID;
	
	private boolean allocated;

	private Requirement requirement;

	private Resource[] resources;
	
	private java.util.Set ORM_requirements = new java.util.HashSet();
	
	private java.util.Set ORM_resourceAllocations = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setAllocated(boolean value) {
		this.allocated = value;
	}
	
	public boolean getAllocated() {
		return allocated;
	}
	
	private void setORM_Requirements(java.util.Set value) {
		this.ORM_requirements = value;
	}
	
	private java.util.Set getORM_Requirements() {
		return ORM_requirements;
	}
	
	public final businesslogic.distribution.requirement.RequirementSetCollection requirements = new businesslogic.distribution.requirement.RequirementSetCollection(this, _ormAdapter, businesslogic.accounting.user.ORMConstants.KEY_ALLOCATION__REQUIREMENTS, businesslogic.accounting.user.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_ResourceAllocations(java.util.Set value) {
		this.ORM_resourceAllocations = value;
	}
	
	private java.util.Set getORM_ResourceAllocations() {
		return ORM_resourceAllocations;
	}
	
	public final businesslogic.distribution.ResourceAllocationSetCollection resourceAllocations = new businesslogic.distribution.ResourceAllocationSetCollection(this, _ormAdapter, businesslogic.accounting.user.ORMConstants.KEY_ALLOCATION__RESOURCEALLOCATIONS, businesslogic.accounting.user.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public businesslogic.distribution.requirement.Requirement getRequirement() {
		return requirement;
	}
	
	public void setRequirement(businesslogic.distribution.requirement.Requirement requirement) {
		this.requirement = requirement;
	}
	
	public Resource[] getResources() {
		return resources;
	}
	
	public void setResources(Resource[] resources) {
		this.resources = resources;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
