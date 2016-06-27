package businesslogic;

import businesslogic.distribution.Allocation;
import businesslogic.distribution.ResourceAllocation;
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
public class ClientResourceManagerLogicFacade implements ResourceManagerLogicInterface{

    @Override
    public void registerResourceAllocation(int userID, Allocation allocation, Resource[] resources) {

    }

    @Override
    public InformationResource[] getInformationResources(int uesrID) {
        return new InformationResource[0];
    }

    @Override
    public String[] getResourceNames(int userID, String resourceType) {
        return new String[0];
    }

    @Override
    public FlowReport reportFlowResourceAllocations(Resource resource, String startDate, String endDate) {
        return null;
    }

    @Override
    public Requirement[] getRequirements(int userID) {
        return new Requirement[0];
    }

    @Override
    public Resource[] getResources(int userID, String resourceType, String resourceName) {
        return new Resource[0];
    }

    @Override
    public boolean registerNewResource(int userID, Resource newResource) {
        return false;
    }

    @Override
    public ResourceReport reportResources() {
        return null;
    }

    @Override
    public FlowReport reportFlowResourceAllocations(Resource resource, Date startDate, Date endDate) {
        return null;
    }

    @Override
    public ResourceRequirementReport reportResourceRequirements(InformationResource informationResource) {
        return null;
    }

    @Override
    public Project[] predictEssentialResourceAllocations(Project project) {
        return new Project[0];
    }

    @Override
    public Project[] getAllProjectList() {
        return new Project[0];
    }
}
