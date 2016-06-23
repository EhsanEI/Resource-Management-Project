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
package businesslogic.accounting.job;

public class Programming extends businesslogic.accounting.job.Job {
	public Programming() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == businesslogic.accounting.user.ORMConstants.KEY_PROGRAMMING_SPECIALTIES) {
			return ORM_specialties;
		}
		else if (key == businesslogic.accounting.user.ORMConstants.KEY_PROGRAMMING_MODULES) {
			return ORM_modules;
		}
		else if (key == businesslogic.accounting.user.ORMConstants.KEY_PROGRAMMING_MODULECHANGES) {
			return ORM_moduleChanges;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private java.util.Set ORM_specialties = new java.util.HashSet();
	
	private java.util.Set ORM_modules = new java.util.HashSet();
	
	private java.util.Set ORM_moduleChanges = new java.util.HashSet();
	
	private void setORM_Specialties(java.util.Set value) {
		this.ORM_specialties = value;
	}
	
	private java.util.Set getORM_Specialties() {
		return ORM_specialties;
	}
	
	public final businesslogic.accounting.job.SpecialtySetCollection specialties = new businesslogic.accounting.job.SpecialtySetCollection(this, _ormAdapter, businesslogic.accounting.user.ORMConstants.KEY_PROGRAMMING_SPECIALTIES, businesslogic.accounting.user.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Modules(java.util.Set value) {
		this.ORM_modules = value;
	}
	
	private java.util.Set getORM_Modules() {
		return ORM_modules;
	}
	
	public final businesslogic.distribution.resource.ModuleSetCollection modules = new businesslogic.distribution.resource.ModuleSetCollection(this, _ormAdapter, businesslogic.accounting.user.ORMConstants.KEY_PROGRAMMING_MODULES, businesslogic.accounting.user.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_ModuleChanges(java.util.Set value) {
		this.ORM_moduleChanges = value;
	}
	
	private java.util.Set getORM_ModuleChanges() {
		return ORM_moduleChanges;
	}
	
	public final businesslogic.distribution.resource.ModuleChangeSetCollection moduleChanges = new businesslogic.distribution.resource.ModuleChangeSetCollection(this, _ormAdapter, businesslogic.accounting.user.ORMConstants.KEY_PROGRAMMING_MODULECHANGES, businesslogic.accounting.user.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public Specialty[] getSpecialties() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void addSpecialty(Specialty specialty) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return super.toString();
	}
	
}
