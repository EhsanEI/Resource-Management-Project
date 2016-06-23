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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class SystemCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression resourceStateId;
	public final AssociationExpression resourceState;
	public final IntegerExpression uniqueIdentifier;
	public final StringExpression name;
	public final CollectionExpression resourceAllocations;
	public final IntegerExpression projectManagementId;
	public final AssociationExpression projectManagement;
	public final CollectionExpression allocation_s;
	public final CollectionExpression requirements;
	public final StringExpression technologies;
	public final CollectionExpression subsystems;
	
	public SystemCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		resourceStateId = new IntegerExpression("resourceState.ID", this);
		resourceState = new AssociationExpression("resourceState", this);
		uniqueIdentifier = new IntegerExpression("uniqueIdentifier", this);
		name = new StringExpression("name", this);
		resourceAllocations = new CollectionExpression("ORM_ResourceAllocations", this);
		projectManagementId = new IntegerExpression("projectManagement.ID", this);
		projectManagement = new AssociationExpression("projectManagement", this);
		allocation_s = new CollectionExpression("ORM_Allocation_s", this);
		requirements = new CollectionExpression("ORM_Requirements", this);
		technologies = new StringExpression("technologies", this);
		subsystems = new CollectionExpression("ORM_Subsystems", this);
	}
	
	public SystemCriteria(PersistentSession session) {
		this(session.createCriteria(System.class));
	}
	
	public SystemCriteria() throws PersistentException {
		this(businesslogic.accounting.user.OODPersistentManager.instance().getSession());
	}
	
	public businesslogic.distribution.resource.SubsystemCriteria createSubsystemsCriteria() {
		return new businesslogic.distribution.resource.SubsystemCriteria(createCriteria("ORM_Subsystems"));
	}
	
	public businesslogic.accounting.job.ProjectManagementCriteria createProjectManagementCriteria() {
		return new businesslogic.accounting.job.ProjectManagementCriteria(createCriteria("projectManagement"));
	}
	
	public businesslogic.distribution.Allocation_Criteria createAllocation_sCriteria() {
		return new businesslogic.distribution.Allocation_Criteria(createCriteria("ORM_Allocation_s"));
	}
	
	public businesslogic.distribution.requirement.RequirementCriteria createRequirementsCriteria() {
		return new businesslogic.distribution.requirement.RequirementCriteria(createCriteria("ORM_Requirements"));
	}
	
	public ResourceStateCriteria createResourceStateCriteria() {
		return new ResourceStateCriteria(createCriteria("resourceState"));
	}
	
	public businesslogic.distribution.ResourceAllocationCriteria createResourceAllocationsCriteria() {
		return new businesslogic.distribution.ResourceAllocationCriteria(createCriteria("ORM_ResourceAllocations"));
	}
	
	public System uniqueSystem() {
		return (System) super.uniqueResult();
	}
	
	public System[] listSystem() {
		java.util.List list = super.list();
		return (System[]) list.toArray(new System[list.size()]);
	}
}

