package businesslogic;

import businesslogic.accounting.job.Specialty;
import businesslogic.accounting.user.User;
import businesslogic.distribution.requirement.Requirement;
import businesslogic.distribution.requirement.ResourceRequirementPriority;
import businesslogic.distribution.resource.InformationResource;
import businesslogic.distribution.resource.Module;
import businesslogic.distribution.resource.Project;
import businesslogic.distribution.resource.System;
import businesslogic.distribution.resource.Subsystem;
import businesslogic.utility.Date;

/**
 * Created by Esi on 6/22/2016.
 */
public interface ProjectManagerLogicInterface {

    void registerProjectScale(int UserID, Project newProject);

    Project[] estimateResourceAllocations(String[] technologies, Date startDate, Date endDate, int budget);
    void registerRequirement(int userID, Requirement newRequirement);

    Project[] getProjectList(int userID);
    User[] getProgrammers(Project project);

    Module[] getModules(Project project);

    InformationResource[] getInformationResources(int userID);

    String[] getResourceNames(int userID, String resourceType);
}
