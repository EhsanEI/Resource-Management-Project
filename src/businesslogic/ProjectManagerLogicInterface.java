package businesslogic;

import businesslogic.distribution.requirement.Requirement;
import businesslogic.distribution.resource.*;
import businesslogic.utility.Date;
import businesslogic.utility.Notification;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Esi on 6/22/2016.
 */
public interface ProjectManagerLogicInterface {

    Notification assignModules(HashMap<HumanResource, Module> assignments) throws IOException, ClassNotFoundException;

    Notification registerProjectScale(int UserID, Project newProject) throws IOException, ClassNotFoundException;

    InformationResource[] estimateResourceAllocations(String[] technologies, Date startDate, Date endDate, int budget) throws IOException, ClassNotFoundException;

    Notification registerRequirement(int userID, Requirement newRequirement, InformationResource resource) throws IOException, ClassNotFoundException;

    Project[] getProjectList(int userID) throws IOException, ClassNotFoundException;

    HumanResource[] getProgrammers(Project project) throws IOException, ClassNotFoundException;

    Module[] getModules(Project project) throws IOException, ClassNotFoundException;

    InformationResource[] getInformationResources(int userID) throws IOException, ClassNotFoundException;

    String[] getResourceNames(int userID, String resourceType) throws IOException, ClassNotFoundException;
}
