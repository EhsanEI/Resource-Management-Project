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
public class ClientProjectManagerLogicFacade implements ProjectManagerLogicInterface{
    @Override
    public Project createProject(String name, Date startDate, Date endDate, int budget, String description) {
        return null;
    }

    @Override
    public System createSystem(Project project, String name, String[] technologies) {
        return null;
    }

    @Override
    public Subsystem createSubsystem(System system, String name) {
        return null;
    }

    @Override
    public Module createModule(Subsystem subsystem, String name, String description, int estimatedLinesOfCode, int numberOfHours, Specialty[] specialties) {
        return null;
    }

    @Override
    public Project[] estimateResourceAllocations(String[] technologies, Date startDate, Date endDate, int budget) {
        return new Project[0];
    }

    @Override
    public void registerRequirement(InformationResource informationResource, String resourceType, String resourceName, RequirementPriority priority, Date startDate, Date endDate) {

    }

    @Override
    public Specialty createSpecialty(String title, int proficiencyLevel) {
        return null;
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
}
