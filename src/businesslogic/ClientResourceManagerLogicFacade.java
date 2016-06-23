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
public class ClientResourceManagerLogicFacade implements ResourceManagerLogicInterface{
    @Override
    public void registerResourceAllocation(String[] resourceID, Date[] startDate, Date[] endDate, Requirement requirement) {

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
}
