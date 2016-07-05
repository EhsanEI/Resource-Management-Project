package businesslogic;

import businesslogic.distribution.Allocation;
import businesslogic.distribution.requirement.Requirement;
import businesslogic.distribution.resource.InformationResource;
import businesslogic.distribution.resource.Project;
import businesslogic.distribution.resource.Resource;
import businesslogic.report.FlowReport;
import businesslogic.report.ResourceReport;
import businesslogic.report.ResourceRequirementReport;
import businesslogic.utility.Date;
import businesslogic.utility.Notification;

/**
 * Created by Esi on 6/22/2016.
 */
public interface ResourceManagerLogicInterface {
    Notification registerResourceAllocation(int userID, Allocation allocation, Resource[] resources);
    Notification rejectResourceAllocation(int userID, int requirementID);
    InformationResource[] getInformationResources(int uesrID);
    String[] getResourceNames(int userID, String resourceType);
    Requirement[] getRequirements(int userID);
    Resource[] getResources(int userID, String resourceType, String resourceName);
    Notification registerNewResource(int userID, Resource newResource);
    ResourceReport reportResources();
    FlowReport reportFlowResourceAllocations(Resource resource, Date startDate, Date endDate);
    ResourceRequirementReport reportResourceRequirements(InformationResource informationResource);
    Project[] predictEssentialResourceAllocations(Project project);
    Project[] getAllProjectList();
}
