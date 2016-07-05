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

import businesslogic.accounting.job.Specialty;
import businesslogic.distribution.requirement.Requirement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class Module extends businesslogic.distribution.resource.InformationResource {
	public Module() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == businesslogic.accounting.user.ORMConstants.KEY_MODULE_SPECIALTIES) {
			return ORM_specialties;
		}
		else if (key == businesslogic.accounting.user.ORMConstants.KEY_MODULE_MODULECHANGES) {
			return ORM_moduleChanges;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == businesslogic.accounting.user.ORMConstants.KEY_MODULE_DATE) {
			this.date = (businesslogic.utility.Date) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private businesslogic.utility.Date date;
	
	private String name;
	
	private String description;
	
	private int linesOfCode;

	private String startDate;
	private String endDate;
	
	private java.util.Set ORM_specialties = new java.util.HashSet();
	
	private java.util.Set ORM_moduleChanges = new java.util.HashSet();
	
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
	
	private void setORM_Specialties(java.util.Set value) {
		this.ORM_specialties = value;
	}
	
	private java.util.Set getORM_Specialties() {
		return ORM_specialties;
	}
	
	public final businesslogic.accounting.job.SpecialtySetCollection specialties = new businesslogic.accounting.job.SpecialtySetCollection(this, _ormAdapter, businesslogic.accounting.user.ORMConstants.KEY_MODULE_SPECIALTIES, businesslogic.accounting.user.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_ModuleChanges(java.util.Set value) {
		this.ORM_moduleChanges = value;
	}
	
	private java.util.Set getORM_ModuleChanges() {
		return ORM_moduleChanges;
	}
	
	public final businesslogic.distribution.resource.ModuleChangeSetCollection moduleChanges = new businesslogic.distribution.resource.ModuleChangeSetCollection(this, _ormAdapter, businesslogic.accounting.user.ORMConstants.KEY_MODULE_MODULECHANGES, businesslogic.accounting.user.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setDate(businesslogic.utility.Date value) {
		this.date = value;
	}
	
	public businesslogic.utility.Date getDate() {
		return date;
	}
	
	public Module(String name, String startDate, String endDate, int linesOfCode) {
		setName(name);
		setStartDate(startDate);
		setEndDate(endDate);
		setLinesOfCode(linesOfCode);
	}
	
	public ModuleState getState() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setState(ModuleState state) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void registerCreation(String description, String startDate, String endDate) {

	}
	
	public void registerChange(String description, businesslogic.utility.Date startDate, businesslogic.utility.Date endDate) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}

	public void addSpecialty(Specialty specialty) {
		getORM_Specialties().add(specialty);
	}

	public Requirement[] getRequirementsRecursive() {
		ArrayList<Requirement> requirements = new ArrayList<>();
		requirements.addAll(Arrays.asList(getRequirements()));

		return requirements.toArray(new Requirement[requirements.size()]);
	}
	
	public String toString() {
		return super.toString();
	}
	
}
