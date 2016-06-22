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

import businesslogic.utility.Date;

public class Module extends businesslogic.distribution.resource.InformationResource {
	public Module() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == businesslogic.distribution.resource.ORMConstants.KEY_MODULE_MODULESPECIALTY) {
			return ORM_moduleSpecialty;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private String name;
	
	private String description;
	
	private int linesOfCode;
	
	private java.util.Set ORM_moduleSpecialty = new java.util.HashSet();
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setLinesOfCode(int value) {
		this.linesOfCode = value;
	}
	
	public int getLinesOfCode() {
		return linesOfCode;
	}
	
	private void setORM_ModuleSpecialty(java.util.Set value) {
		this.ORM_moduleSpecialty = value;
	}
	
	private java.util.Set getORM_ModuleSpecialty() {
		return ORM_moduleSpecialty;
	}
	
	public final businesslogic.distribution.resource.ModuleSpecialtySetCollection moduleSpecialty = new businesslogic.distribution.resource.ModuleSpecialtySetCollection(this, _ormAdapter, businesslogic.distribution.resource.ORMConstants.KEY_MODULE_MODULESPECIALTY, businesslogic.distribution.resource.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public Module(String name, Date startDate, int linesOfCode) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public ModuleState getState() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setState(ModuleState state) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public businesslogic.utility.Date getStartDate() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setStartDate(businesslogic.utility.Date startDate) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public businesslogic.utility.Date getEndDate() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setEndDate(businesslogic.utility.Date endDate) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void registerCreation(String description, businesslogic.utility.Date startDate, businesslogic.utility.Date endDate) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void registerChange(String description, businesslogic.utility.Date startDate, businesslogic.utility.Date endDate) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return super.toString();
	}
	
}
