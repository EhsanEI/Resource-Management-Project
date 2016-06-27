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
import businesslogic.distribution.resource.*;
import businesslogic.report.FlowReport;
import businesslogic.report.ResourceReport;
import businesslogic.report.ResourceRequirementReport;
import businesslogic.utility.Date;
import org.orm.PersistentException;
import org.orm.PersistentSession;

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
    public void registerResourceAllocation(int userID, Allocation allocation, Resource[] resources) {
        try{

            //TODO add resource management for the allocation
            User user = UserDAO.getUserByORMID(userID);
            getResourceManagement(user).addAllocation(allocation);

            allocation.setAllocated(true);

            for(Resource resource: resources) {
                resource.allocate();
            }

            for(ResourceAllocation ra:(Set<ResourceAllocation>)allocation.getORM_ResourceAllocations()) {
                ResourceAllocationDAO.save(ra);
            }

            Allocation_DAO.save(allocation);

            for(Resource resource: resources) {
                ResourceDAO.save(resource);
            }

            //TODO add notification to allocation.getRequirement().getProjectManagement()
        }
        catch (PersistentException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public InformationResource[] getInformationResources(int uesrID) {
        try {
            PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();
            List<InformationResource> informationResourceList= session
                    .createQuery("SELECT resource FROM Resource AS resource WHERE " +
                            "Discriminator IN ('Project','System','Subsystem', 'Module')").list();

            return informationResourceList.toArray(new InformationResource[informationResourceList.size()]);
        }
        catch(PersistentException ex) {

        }
        return new Project[0];
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
        return new String[0];
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
            ex.printStackTrace();
        }
        return new Requirement[0];
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
            ex.printStackTrace();
        }
        return new Resource[0];
    }

    @Override
    public boolean registerNewResource(int userID, Resource newResource) {
        try {
            User user = UserDAO.getUserByORMID(userID);
            ResourceManagement rm = getResourceManagement(user);

            if(rm == null) {
                return false;
                //TODO send notification
            }

            ResourceDAO.save(newResource);
            return true;
        }
        catch (PersistentException ex) {
            ex.printStackTrace();
        }
        //TODO send notification
        return false;

    }

    @Override
    public ResourceReport reportResources() {
        try {
            ResourceReport report = new ResourceReport();
            report.makeReport();
            return report;
        }
        catch (PersistentException ex) {
            ex.printStackTrace();
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
            ex.printStackTrace();
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
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Project[] predictEssentialResourceAllocations(Project project) {

        Requirement[] requirements = project.getRequirements();

        Project[] allProjects = getAllProjectList();

        ArrayList<Project> resultList = new ArrayList<>();

        for(Project p:allProjects) {
            if(p.getID() == project.getID()) {
                continue;
            }
            Requirement [] rs = p.getRequirements();

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
        return new Project[0];
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
