package businesslogic;

import businesslogic.distribution.requirement.Requirement;
import businesslogic.distribution.resource.InformationResource;
import businesslogic.distribution.resource.Project;
import businesslogic.distribution.resource.Resource;
import businesslogic.report.FlowReport;
import businesslogic.report.ResourceReport;
import businesslogic.report.ResourceRequirementReport;
import businesslogic.utility.Date;

/**
 * Created by Esi on 6/22/2016.
 */
public interface ResourceManagerLogicInterface {
    void registerResourceAllocation(String[] resourceID, Date[] startDate, Date endDate[], Requirement requirement);
    boolean registerNewResource(int userID, Resource newResource);
    ResourceReport reportResources();
    FlowReport reportFlowResourceAllocations(Resource resource, Date startDate, Date endDate);
    ResourceRequirementReport reportResourceRequirements(InformationResource informationResource);
    Project[] predictEssentialResourceAllocations(Project project);
}
