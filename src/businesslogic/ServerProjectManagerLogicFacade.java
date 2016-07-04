package businesslogic;

import businesslogic.accounting.job.Job;
import businesslogic.accounting.job.ProjectManagement;
import businesslogic.accounting.job.ProjectManagementDAO;
import businesslogic.accounting.job.Specialty;
import businesslogic.accounting.user.User;
import businesslogic.accounting.user.UserDAO;
import businesslogic.distribution.Allocation;
import businesslogic.distribution.requirement.Requirement;
import businesslogic.distribution.requirement.RequirementDAO;
import businesslogic.distribution.requirement.ResourceRequirementPriority;
import businesslogic.distribution.resource.*;
import businesslogic.distribution.resource.System;
import businesslogic.utility.Date;
import businesslogic.utility.Notification;
import businesslogic.utility.NotificationDAO;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.util.*;

/**
 * Created by Esi on 6/22/2016.
 */
public class ServerProjectManagerLogicFacade implements ProjectManagerLogicInterface{

    private static ServerProjectManagerLogicFacade instance;

    private ServerProjectManagerLogicFacade() {
    }

    public static ServerProjectManagerLogicFacade getInstance() {
        if(instance == null) {
            instance = new ServerProjectManagerLogicFacade();
        }
        return instance;
    }

    @Override
    public Notification assignModules(Map<HumanResource, Module> assignments) {
        StringBuffer msg = new StringBuffer("");
        for(HumanResource humanResource: assignments.keySet()) {
            humanResource.getProgramming().addModule(assignments.get(humanResource));
            try {
                HumanResourceDAO.save(humanResource);
            }
            catch (PersistentException ex) {
                ex.printStackTrace();
                msg.append("Cannot assign module to programmer " + humanResource.getName());
            }
        }
        Notification notification = NotificationDAO.createNotification();
        if(msg.length() == 0) {
            notification.setContent(msg.toString());
        }
        else {
            notification.setContent("Modules were assigned.");
        }
        return notification;
    }

    @Override
    public Notification registerProjectScale(int UserID, Project newProject) {

        try {

            User user = UserDAO.getUserByORMID(UserID);

            ProjectManagement pm = getProjectManagement(user);

            if(pm == null) {
                Notification notification = NotificationDAO.createNotification();
                notification.setContent("The user is not a project manager.");
                return notification;
            }

            newProject.setProjectManagement(pm);

            Set<System> systems = newProject.getORM_Systems();
            for (System system : systems) {
                system.setProjectManagement(pm);
                Set<Subsystem> subsystems = system.getORM_Subsystems();
                for (Subsystem subsystem : subsystems) {
                    subsystem.setProjectManagement(pm);
                    Set<Module> modules = subsystem.getORM_Modules();
                    for (Module module : modules) {
                        module.setProjectManagement(pm);
                        ModuleDAO.save(module);
                    }
                    SubsystemDAO.save(subsystem);
                }
                SystemDAO.save(system);
            }
            ProjectDAO.save(newProject);

            ProjectManagementDAO.save(pm);
        }
        catch(PersistentException ex) {
            ex.printStackTrace();
            Notification notification = NotificationDAO.createNotification();
            notification.setContent("Cannot save the project.");
            return notification;
        }
        Notification notification = NotificationDAO.createNotification();
        notification.setContent("The project has been registered successfully.");
        return notification;
    }

    @Override
    public InformationResource[] estimateResourceAllocations(String[] technologies, Date startDate, Date endDate, int budget) {
        try {
            if(technologies.length < 1) {
                return null;
            }

            StringBuffer condition = new StringBuffer("");
            condition.append("SELECT ID2 FROM Resource WHERE Technologies IN ('").append(technologies[0]);
            for(int i = 1;i < technologies.length; i++) {
                condition.append("','").append(technologies[i]);
            }
            condition.append("')");

            condition.append(" OR budget = ").append(budget);

            PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();
            List<Integer> resultIDs = session.createSQLQuery(condition.toString()).list();

            ArrayList<InformationResource> result = new ArrayList<>();
            for(Integer id:resultIDs) {
                result.add(InformationResourceDAO.getInformationResourceByORMID(id));
            }
            return result.toArray(new InformationResource[result.size()]);
        }
        catch(PersistentException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Notification registerRequirement(int userID, Requirement newRequirement) {
        try {

            User user = UserDAO.getUserByORMID(userID);
            newRequirement.setProjectManager(getProjectManagement(user));
            RequirementDAO.save(newRequirement);
            Notification notification = NotificationDAO.createNotification();
            notification.setContent("The requirement has been registered successfully.");
            return notification;
        }
        catch(PersistentException ex) {
            ex.printStackTrace();
        }
        Notification notification = NotificationDAO.createNotification();
        notification.setContent("Cannot save the requirement.");
        return notification;
    }

    @Override
    public Project[] getProjectList(int userID) {
        try {
            User user = UserDAO.getUserByORMID(userID);
            ProjectManagement pm = getProjectManagement(user);
            InformationResource[] informationResources = pm.getInformationResources();

            ArrayList<Project> projects = new ArrayList<>();
            for(InformationResource informationResource:informationResources) {
                if(informationResource instanceof Project) {
                    projects.add((Project) informationResource);
                }
            }
            return projects.toArray(new Project[projects.size()]);
        }
        catch(PersistentException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public HumanResource[] getProgrammers(Project project) {
        Set<Allocation> allAllocations = new HashSet<>();

        allAllocations.addAll(Arrays.asList(project.getAllocations()));
        for(System system : (Set<System>) project.getORM_Systems()) {

            allAllocations.addAll(Arrays.asList(system.getAllocations()));
            for(Subsystem subsystem : (Set<Subsystem>) system.getORM_Subsystems()) {

                allAllocations.addAll(Arrays.asList(subsystem.getAllocations()));
                for(Module module : (Set<Module>)subsystem.getORM_Modules()) {
                    allAllocations.addAll(Arrays.asList(module.getAllocations()));
                }
            }
        }

        ArrayList<HumanResource> programmers = new ArrayList();
        for(Allocation allocation:allAllocations) {
            for (Resource resource: allocation.getResources()) {
                if(resource instanceof HumanResource) {
                    programmers.add((HumanResource)resource);
                }
            }
        }

        return programmers.toArray(new HumanResource[programmers.size()]);
    }

    @Override
    public Module[] getModules(Project project) {
        Set<Module> allModules = new HashSet<>();

        for(System system : (Set<System>) project.getORM_Systems()) {
            for(Subsystem subsystem : (Set<Subsystem>) system.getORM_Subsystems()) {
                for(Module module : (Set<Module>)subsystem.getORM_Modules()) {
                    allModules.add(module);
                }
            }
        }
        return allModules.toArray(new Module[allModules.size()]);
    }

    @Override
    public InformationResource[] getInformationResources(int userID) {
        try {
            ProjectManagement pm = getProjectManagement(UserDAO.getUserByORMID(userID));
            return pm.getInformationResources();
        }
        catch(PersistentException | NullPointerException  ex) {
            ex.printStackTrace();
        }
        return null;

    }

    @Override
    public String[] getResourceNames(int userID, String ResourceType ) {
        try {
            PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();
            StringBuffer condition = new StringBuffer("");
            condition.append("SELECT resource.name FROM Resource AS resource WHERE Discriminator = '")
                    .append(ResourceType).append("'");
            List<String> results = session.createQuery(condition.toString()).list();
            return results.toArray(new String[results.size()]);
        }
        catch(PersistentException | NullPointerException  ex) {
            ex.printStackTrace();
        }
        return null;

    }

    private ProjectManagement getProjectManagement(User user) {
        ProjectManagement pm = null;
        for(Job job:user.getJobs()) {
            if(job instanceof ProjectManagement) {
                pm = (ProjectManagement) job;
                return pm;
            }
        }
        return null;
    }
}
