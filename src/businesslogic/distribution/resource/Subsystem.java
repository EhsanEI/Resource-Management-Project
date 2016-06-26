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

public class Subsystem extends businesslogic.distribution.resource.InformationResource {
	public Subsystem() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == businesslogic.accounting.user.ORMConstants.KEY_SUBSYSTEM_MODULES) {
			return ORM_modules;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private java.util.Set ORM_modules = new java.util.HashSet();
	
	public void setORM_Modules(java.util.Set value) {
		this.ORM_modules = value;
	}
	
	public java.util.Set getORM_Modules() {
		return ORM_modules;
	}
	
	public final businesslogic.distribution.resource.ModuleSetCollection modules = new businesslogic.distribution.resource.ModuleSetCollection(this, _ormAdapter, businesslogic.accounting.user.ORMConstants.KEY_SUBSYSTEM_MODULES, businesslogic.accounting.user.ORMConstants.KEY_MUL_ONE_TO_MANY);

	public void addModule(Module module) {
		getORM_Modules().add(module);
	}
	
	public String toString() {
		return super.toString();
	}
	
}
