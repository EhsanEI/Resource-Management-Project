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

import java.io.IOException;

/**
 * Created by Esi on 6/22/2016.
 */
public interface ResourceManagerLogicInterface {
    Notification registerResourceAllocation(int userID, Allocation allocation, Resource[] resources) throws IOException, ClassNotFoundException;
    Notification rejectResourceAllocation(int userID, int requirementID) throws IOException, ClassNotFoundException;
    InformationResource[] getInformationResources(int uesrID) throws IOException, ClassNotFoundException;
    String[] getResourceNames(int userID, String resourceType) throws IOException, ClassNotFoundException;
    Requirement[] getRequirements(int userID) throws IOException, ClassNotFoundException;
    Resource[] getResources(int userID, String resourceType, String resourceName) throws IOException, ClassNotFoundException;
    Notification registerNewResource(int userID, Resource newResource) throws IOException, ClassNotFoundException;
    ResourceReport reportResources() throws IOException, ClassNotFoundException;
    FlowReport reportFlowResourceAllocations(Resource resource, Date startDate, Date endDate) throws IOException, ClassNotFoundException;
    ResourceRequirementReport reportResourceRequirements(InformationResource informationResource) throws IOException, ClassNotFoundException;
    InformationResource[] predictEssentialResourceAllocations(Project project) throws IOException, ClassNotFoundException;
    Project[] getAllProjectList() throws IOException, ClassNotFoundException;
}
