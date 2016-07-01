package businesslogic;

import businesslogic.accounting.job.Specialty;
import businesslogic.accounting.user.User;
import businesslogic.distribution.requirement.Requirement;
import businesslogic.distribution.requirement.ResourceRequirementPriority;
import businesslogic.distribution.resource.*;
import businesslogic.distribution.resource.System;
import businesslogic.utility.Date;
import businesslogic.utility.Notification;

import java.util.Map;

/**
 * Created by Esi on 6/22/2016.
 */
public interface ProjectManagerLogicInterface {

    Notification assignModules(Map<HumanResource, Module> assignments);

    Notification registerProjectScale(int UserID, Project newProject);

    InformationResource[] estimateResourceAllocations(String[] technologies, Date startDate, Date endDate, int budget);

    Notification registerRequirement(int userID, Requirement newRequirement);

    Project[] getProjectList(int userID);

    HumanResource[] getProgrammers(Project project);

    Module[] getModules(Project project);

    InformationResource[] getInformationResources(int userID);

    String[] getResourceNames(int userID, String resourceType);
}
