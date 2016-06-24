package businesslogic;

import businesslogic.accounting.job.Specialty;
import businesslogic.accounting.user.User;
import businesslogic.distribution.requirement.RequirementPriority;
import businesslogic.distribution.resource.InformationResource;
import businesslogic.distribution.resource.Module;
import businesslogic.distribution.resource.Project;
import businesslogic.distribution.resource.Subsystem;
import businesslogic.utility.Date;

/**
 * Created by Esi on 6/22/2016.
 */
public interface ProjectManagerLogicInterface {
    Project createProject(String name, Date startDate, Date endDate, int budget, String description);
    System createSystem(Project project, String name, String[] technologies);
    Subsystem createSubsystem(System system, String name);
    Module createModule(Subsystem subsystem, String name, String description, int estimatedLinesOfCode,
                        int numberOfHours, Specialty[] specialties);
    Project[] estimateResourceAllocations(String[] technologies, Date startDate, Date endDate, int budget);
    void registerRequirement(InformationResource informationResource, String resourceType, String resourceName,
                             RequirementPriority priority, Date startDate, Date endDate);
    Specialty createSpecialty(String title, int proficiencyLevel);
    Project[] getProjectList(int userID);
    User[] getProgrammers(Project project);
    Module[] getModules(Project project);
}
