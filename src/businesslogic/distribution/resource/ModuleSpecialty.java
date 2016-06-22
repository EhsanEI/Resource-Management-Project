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

public class ModuleSpecialty {
	public ModuleSpecialty() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == businesslogic.distribution.resource.ORMConstants.KEY_MODULESPECIALTY_SPECIALTY) {
			this.specialty = (businesslogic.accounting.job.Specialty) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private businesslogic.accounting.job.Specialty specialty;
	
	private int ID;
	
	
	public int getORMID() {
		return getID();
	}
	
	public void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setSpecialty(businesslogic.accounting.job.Specialty value) {
		this.specialty = value;
	}
	
	public businesslogic.accounting.job.Specialty getSpecialty() {
		return specialty;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
