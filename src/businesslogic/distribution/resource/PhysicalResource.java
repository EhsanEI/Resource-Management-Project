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

import businesslogic.accounting.user.ORMConstants;

import java.util.HashMap;

public class PhysicalResource extends businesslogic.distribution.resource.Resource {
	public PhysicalResource() {
	}

	private java.util.Set ORM_specs= new java.util.HashSet();

	public void setORM_Specs(java.util.Set value) {
		this.ORM_specs = value;
	}

	public java.util.Set getORM_Specs() {
		return ORM_specs;
	}

	public final SpecSetCollection specs =
			new SpecSetCollection(this, _ormAdapter, ORMConstants.KEY_RESOURCE_SPECS, businesslogic.accounting.user.ORMConstants.KEY_MUL_ONE_TO_MANY);

	
	public void addSpec(String title, String value) {
		Spec spec = SpecDAO.createSpec();
		spec.setName(title);
		spec.setValue(value);
		getORM_Specs().add(spec);
	}
	
	public String toString() {
		return super.toString();
	}
	
}
