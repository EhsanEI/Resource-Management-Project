package businesslogic;

import businesslogic.accounting.job.Specialty;
import businesslogic.accounting.user.User;
import businesslogic.distribution.requirement.Requirement;
import businesslogic.distribution.requirement.ResourceRequirementPriority;
import businesslogic.distribution.resource.*;
import businesslogic.distribution.resource.System;
import businesslogic.utility.Date;

/**
 * Created by Esi on 6/22/2016.
 */
public class ClientProjectManagerLogicFacade implements ProjectManagerLogicInterface{
    @Override
    public void registerProjectScale(int UserID, Project newProject) {

    }

    @Override
    public Project[] estimateResourceAllocations(String[] technologies, Date startDate, Date endDate, int budget) {
        return new Project[0];
    }

    @Override
    public void registerRequirement(int userID, Requirement newRequirement) {

    }

    @Override
    public Project[] getProjectList(int userID) {
        return new Project[0];
    }

    @Override
    public User[] getProgrammers(Project project) {
        return new User[0];
    }

    @Override
    public Module[] getModules(Project project) {
        return new Module[0];
    }

    @Override
    public InformationResource[] getInformationResources(int userID) {
        return new InformationResource[0];
    }

    @Override
    public String[] getResourceNames(int userID, String resourceType) {
        return new String[0];
    }
}
