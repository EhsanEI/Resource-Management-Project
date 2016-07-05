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

import businesslogic.distribution.Allocation;
import businesslogic.distribution.Allocation_DAO;
import businesslogic.distribution.ResourceAllocation;
import businesslogic.distribution.requirement.Requirement;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Resource {
	public Resource() {
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
	
	public int getResourceState() {

		try {
			PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();

			//Can be done easier with join
			List<Integer> allocationIDs = session
					.createSQLQuery("SELECT [Allocation ID] FROM ResourceAllocation WHERE ResourceID2 = " + getID()).list();


			java.util.Date currentDate = new java.util.Date();
			for (Integer allocationID : allocationIDs) {
				Requirement requirement = Allocation_DAO.getAllocation_ByORMID(allocationID).getRequirement();

				DateFormat df = new SimpleDateFormat("dd/mm/yy");

				java.util.Date reqStartDate = null;
				java.util.Date reqEndDate = null;
				try {
					reqStartDate = df.parse(requirement.getStartDate());
					reqEndDate = df.parse(requirement.getEndDate());
				} catch (ParseException e) {
					return ResourceStateEnum.UNALLOCATED.ordinal();
				}

				if (reqStartDate.before(currentDate) && reqEndDate.after(currentDate)) {
					return ResourceStateEnum.ALLOCATED.ordinal();
				}
			}

		}catch(PersistentException e){
		}
		return ResourceStateEnum.UNALLOCATED.ordinal();
	}

	public void addResourceAllocation(ResourceAllocation resourceAllocation) {
		getORM_ResourceAllocations().add(resourceAllocation);
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
