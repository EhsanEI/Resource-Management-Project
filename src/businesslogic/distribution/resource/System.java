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

public class System extends businesslogic.distribution.resource.InformationResource {
	public System() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == businesslogic.accounting.user.ORMConstants.KEY_SYSTEM_SUBSYSTEMS) {
			return ORM_subsystems;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private String technologies;
	
	private java.util.Set ORM_subsystems = new java.util.HashSet();
	
	public void setTechnologies(String value) {
		this.technologies = value;
	}
	
	public String getTechnologies() {
		return technologies;
	}
	
	private void setORM_Subsystems(java.util.Set value) {
		this.ORM_subsystems = value;
	}
	
	private java.util.Set getORM_Subsystems() {
		return ORM_subsystems;
	}
	
	public final businesslogic.distribution.resource.SubsystemSetCollection subsystems = new businesslogic.distribution.resource.SubsystemSetCollection(this, _ormAdapter, businesslogic.accounting.user.ORMConstants.KEY_SYSTEM_SUBSYSTEMS, businesslogic.accounting.user.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
