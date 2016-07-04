package businesslogic;

import businesslogic.accounting.ResourceManagement;
import businesslogic.accounting.job.Job;
import businesslogic.accounting.job.ProjectManagement;
import businesslogic.accounting.job.ProjectManagementDAO;
import businesslogic.accounting.user.User;
import businesslogic.accounting.user.UserDAO;
import businesslogic.distribution.Allocation;
import businesslogic.distribution.Allocation_DAO;
import businesslogic.distribution.ResourceAllocation;
import businesslogic.distribution.ResourceAllocationDAO;
import businesslogic.distribution.requirement.Requirement;
import businesslogic.distribution.requirement.RequirementDAO;
import businesslogic.distribution.resource.*;
import businesslogic.report.FlowReport;
import businesslogic.report.ResourceReport;
import businesslogic.report.ResourceRequirementReport;
import businesslogic.utility.Date;
import businesslogic.utility.Notification;
import businesslogic.utility.NotificationDAO;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.lang.System;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Esi on 6/22/2016.
 */
public class ServerResourceManagerLogicFacade implements ResourceManagerLogicInterface{

    private static ServerResourceManagerLogicFacade instance;

    private ServerResourceManagerLogicFacade() {
    }

    public static ServerResourceManagerLogicFacade getInstance() {
        if(instance == null) {
            instance = new ServerResourceManagerLogicFacade();
        }
        return instance;
    }

    @Override
    public Notification registerResourceAllocation(int userID, Allocation allocation, Resource[] resources) {
        try{

            User user = UserDAO.getUserByORMID(userID);
            getResourceManagement(user).addAllocation(allocation);

            allocation.setAllocated(true);

            for(Resource resource: resources) {
                resource.allocate();
            }

            InformationResource informationResource = allocation.getRequirement().getInformationResource();
            informationResource.addAllocation(allocation);
            InformationResourceDAO.save(informationResource);

            for(ResourceAllocation ra:(Set<ResourceAllocation>)allocation.getORM_ResourceAllocations()) {
                ResourceAllocationDAO.save(ra);
            }

            Allocation_DAO.save(allocation);

            for(Resource resource: resources) {
                ResourceDAO.save(resource);
            }

            RequirementDAO.save(allocation.getRequirement());

            Notification projectManagerNotification = NotificationDAO.createNotification();
            projectManagerNotification .setContent("A resource manager responded to your requirement for "
                    + allocation.getRequirement().getResourceName() + ".");
            allocation.getRequirement().getProjectManagement().addNotification(projectManagerNotification );

            NotificationDAO.save(projectManagerNotification);
            ProjectManagementDAO.save(allocation.getRequirement().getProjectManagement());

            Notification notification = NotificationDAO.createNotification();
            notification.setContent("The allocation has been registered successfully.");
            return notification;
        }
        catch (PersistentException ex) {
            ex.printStackTrace();
        }
        Notification notification = NotificationDAO.createNotification();
        notification.setContent("The allocation cannot be registered.");
        return notification;
    }

    @Override
    public Notification rejectResourceAllocation(int userID, int requirementID) {
        Notification notification = new Notification();

        Requirement requirement = null;
        try {
            requirement = RequirementDAO.getRequirementByORMID(requirementID);
        } catch (PersistentException e) {
            e.printStackTrace();
            notification.setContent("Requirement not found.");
            return notification;
        }

        Notification projectManagerNotification = NotificationDAO.createNotification();
        projectManagerNotification .setContent("A resource manager rejected your requirement for "
                + requirement.getResourceName() + ".");
        requirement.getProjectManagement().addNotification(projectManagerNotification );

        try {
            RequirementDAO.delete(requirement);
            NotificationDAO.save(projectManagerNotification);
            ProjectManagementDAO.save(requirement.getProjectManagement());
        } catch (PersistentException e) {
            e.printStackTrace();
            notification.setContent("Cannot reject the requirement.");
            return notification;
        }

        notification.setContent("The requirement has been rejected.");
        return notification;
    }

    @Override
    public InformationResource[] getInformationResources(int userID) {
        try {
            PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();
            List<InformationResource> informationResourceList= session
                    .createQuery("SELECT resource FROM Resource AS resource WHERE " +
                            "Discriminator IN ('Project','System','Subsystem', 'Module')").list();

            return informationResourceList.toArray(new InformationResource[informationResourceList.size()]);
        }
        catch(PersistentException ex) {
        }
        return null;
    }

    @Override
    public String[] getResourceNames(int userID, String resourceType) {
        try {
            StringBuffer condition = new StringBuffer("");
            condition.append("SELECT DISTINCT Name2 FROM Resource WHERE Discriminator = '").append(resourceType)
                    .append("'");
            PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();
            List<String> resourceNameList = session
                    .createSQLQuery(condition.toString()).list();
            return resourceNameList.toArray(new String[resourceNameList.size()]);
        } catch (PersistentException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Requirement[] getRequirements(int userID) {
        try {
            PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();
            List<Requirement> requirementList= session
                    .createQuery("SELECT requirement FROM Requirement AS requirement").list();
            return requirementList.toArray(new Requirement[requirementList.size()]);
        }
        catch(PersistentException ex) {
        }
        return null;
    }

    @Override
    public Resource[] getResources(int userID, String resourceType, String resourceName) {
        try {
            StringBuffer condition = new StringBuffer("");
            condition.append("SELECT resource.ID2 FROM Resource AS resource WHERE resource.Discriminator = '")
                    .append(resourceType).append("' AND resource.Name2 = '").append(resourceName).append("'");

            PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();
            List<Integer> idList= session
                    .createSQLQuery(condition.toString()).list();

            ArrayList<Resource> resourceList = new ArrayList<>();
            for(Integer id:idList) {
                resourceList.add(ResourceDAO.getResourceByORMID(id));
            }
            return resourceList.toArray(new Resource[resourceList.size()]);
        }
        catch(PersistentException ex) {
        }
        return null;
    }

    @Override
    public Notification registerNewResource(int userID, Resource newResource) {
        try {
            User user = UserDAO.getUserByORMID(userID);
            ResourceManagement rm = getResourceManagement(user);

            if(rm == null) {
                Notification notification = NotificationDAO.createNotification();
                notification.setContent("The user is not a resource manager.");
                return notification;
            }

            ResourceDAO.save(newResource);
            Notification notification = NotificationDAO.createNotification();
            notification.setContent("The resource has been registered successfully.");
            return notification;
        }
        catch (PersistentException ex) {
            ex.printStackTrace();
        }
        Notification notification = NotificationDAO.createNotification();
        notification.setContent("The resource cannot be registered.");
        return notification;

    }

    @Override
    public ResourceReport reportResources() {
        try {
            ResourceReport report = new ResourceReport();
            report.makeReport();
            return report;
        }
        catch (PersistentException ex) {
        }
        return null;
    }

    @Override
    public FlowReport reportFlowResourceAllocations(Resource resource, Date startDate, Date endDate) {
        return null;
    }

    @Override
    public FlowReport reportFlowResourceAllocations(Resource resource, String startDate, String endDate) {
        try {
            FlowReport report = new FlowReport(resource, startDate, endDate);
            report.makeReport();
            return report;
        }
        catch (PersistentException ex) {
        }
        return null;
    }

    @Override
    public ResourceRequirementReport reportResourceRequirements(InformationResource informationResource) {
        try {
            ResourceRequirementReport report = new ResourceRequirementReport(informationResource.getID());
            report.makeReport();
            return report;
        }
        catch (PersistentException ex) {
        }
        return null;
    }

    @Override
    public Project[] predictEssentialResourceAllocations(Project project) {

        Requirement[] requirements = project.getRequirementsRecursive();

        Project[] allProjects = getAllProjectList();

        ArrayList<Project> resultList = new ArrayList<>();

        for(Project p:allProjects) {
            if(p.getID() == project.getID()) {
                continue;
            }
            Requirement [] rs = p.getRequirementsRecursive();
            boolean similar = false;
            for(Requirement r: rs) {
                for(Requirement requirement: requirements) {
                    if (r.getResourceType().equals(requirement.getResourceType()) &&
                            r.getResourceName().equals(requirement.getResourceName())) {
                        similar = true;
                        break;
                    }
                }
                if(similar) {
                    break;
                }
            }

            if(similar) {
                resultList.add(p);
            }
        }

        return resultList.toArray(new Project[resultList.size()]);
    }

    @Override
    public Project[] getAllProjectList() {
        try {
            PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();
            List<Project> projectsList = session
                    .createQuery("SELECT resource FROM Resource AS resource WHERE Discriminator = 'Project'").list();
            return projectsList.toArray(new Project[projectsList.size()]);
        }
        catch(PersistentException ex) {
        }
        return null;
    }

    private ResourceManagement getResourceManagement(User user) {
        ResourceManagement rm = null;
        for(Job job:user.getJobs()) {
            if(job instanceof ResourceManagement) {
                rm = (ResourceManagement) job;
                return rm;
            }
        }
        return null;
    }
}
