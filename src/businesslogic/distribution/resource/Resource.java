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
		setResourceState(ResourceStateEnum.UNALLOCATED.ordinal());
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == businesslogic.accounting.user.ORMConstants.KEY_RESOURCE_RESOURCEALLOCATIONS) {
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
	
	private int resourceState;
	
	private String uniqueIdentifier;
	
	private String name;
	
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
	
	private void setORM_ResourceAllocations(java.util.Set value) {
		this.ORM_resourceAllocations = value;
	}
	
	private java.util.Set getORM_ResourceAllocations() {
		return ORM_resourceAllocations;
	}
	
	public final businesslogic.distribution.ResourceAllocationSetCollection resourceAllocations = new businesslogic.distribution.ResourceAllocationSetCollection(this, _ormAdapter, businesslogic.accounting.user.ORMConstants.KEY_RESOURCE_RESOURCEALLOCATIONS, businesslogic.accounting.user.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setResourceState(int value) {
		this.resourceState = value;
	}
	
	public int getResourceState() {
		return resourceState;
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
