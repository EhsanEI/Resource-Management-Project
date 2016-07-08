package test;

import businesslogic.*;
import businesslogic.accounting.*;
import businesslogic.accounting.job.*;
import businesslogic.accounting.user.Employee;
import businesslogic.accounting.user.EmployeeDAO;
import businesslogic.accounting.user.User;
import businesslogic.accounting.user.UserDAO;
import businesslogic.distribution.Allocation;
import businesslogic.distribution.Allocation_DAO;
import businesslogic.distribution.requirement.Requirement;
import businesslogic.distribution.requirement.RequirementDAO;
import businesslogic.distribution.requirement.RequirementPriorityEnum;
import businesslogic.distribution.resource.*;
import businesslogic.report.FlowReport;
import businesslogic.report.Report;
import businesslogic.utility.Date;
import businesslogic.utility.Table;
import businesslogic.utility.Tree;
import network.Email;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;
import orm.OODPersistentManager;

import javax.mail.MessagingException;
import java.lang.System;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Esi on 6/25/2016.
 */
public class Main {
    public static void main(String[] args) throws PersistentException {
        PersistentTransaction t = OODPersistentManager.instance().getSession().beginTransaction();

//        signup();

//        registerProject();

//        registerNewResource();

//        registerRequirement();

//        registerResourceAllocation();

//        reportResources();

//        reportResourceRequirements();

//        reportFlowResourceAllocations();

//        predictEssentialResourceAllocations();

//        assignModules();

//        sendEmail();

        test1();

//        test2();
        
//        test3();

        t.commit();
    }

    public static void test1() {
        try {
            User user = UserDAO.getUserByORMID(1);
            user.getJobInfo().print();
            System.out.println(user.getPermissions().length);
        } catch (PersistentException e) {
            e.printStackTrace();
        }

    }

    public static void test2() {
        try {
            Employee em = EmployeeDAO.createEmployee();
            em.setUsername("ali");
            em.setPassword("123");
            em.setEmail("e@animate.com");
            EmployeeDAO.save(em);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }


    public static void test4() {
        try {
            PhysicalResource p = PhysicalResourceDAO.createPhysicalResource();
            p.setUniqueIdentifier("85s");

            Spec s = SpecDAO.createSpec();
            s.setName("namename");
            s.setValue("valval");

            Set<Spec> m = new HashSet<Spec>();
            m.add(s);

            p.setORM_Specs(m);

            SpecDAO.save(s);
            PhysicalResourceDAO.save(p);

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void recoverPassword() {
        AccountingLogicInterface f = ServerAccountingLogicFacade.getInstance();
        //f.recoverPassword("ali");
    }

    public static void signup() {

        Employee em = EmployeeDAO.createEmployee();
        em.setUsername("signed up user");
        em.setPassword("123");
        em.setEmail("e@animate.com");

        ProjectManagement pm = ProjectManagementDAO.createProjectManagement();
        em.addJob(pm);

        Programming pr = ProgrammingDAO.createProgramming();
        em.addJob(pr);

        HumanResource hr = HumanResourceDAO.createHumanResource();
        hr.setProgramming(pr);
        hr.setName(em.getUsername());
        hr.setUniqueIdentifier("HumanResource_"+em.getUsername());

        Specialty sp = SpecialtyDAO.createSpecialty();
        sp.setTitle("Android");
        sp.setProficiencyLevel(3);
        pr.addSpecialty(sp);

        Employee em2 = EmployeeDAO.createEmployee();
        em2.setUsername("user 2");
        em2.setPassword("123");
        em2.setEmail("e2@animate.com");

        ResourceManagement rm = ResourceManagementDAO.createResourceManagement();
        em2.addJob(rm);

        Job[] jobs = {pm, pr};
        Specialty[] specialties = {sp};
        HumanResource[] humanResources = {};
        ServerAccountingLogicFacade.getInstance().signup(em, jobs, specialties, humanResources);

        Job[] jobs2 = {rm};
        Specialty[] specialties2 = {};
        HumanResource[] humanResources2 = {hr};
        ServerAccountingLogicFacade.getInstance().signup(em2, jobs2, specialties2, humanResources2);

    }

    public static void approveUser() {
        User[] users = ServerManagerLogicFacade.getInstance().getUnapprovedUsers();
        for(User user: users) {
            System.out.println(user.getID());
        }
        ServerManagerLogicFacade.getInstance().approveUser(users[0], true);
    }

    public static void loginLogout() {
        AuthenticationResult result = ServerAccountingLogicFacade.getInstance().login("signed up user", "123");

    }

    public static void registerProject() {
        int userID = 1;

        Module m = ModuleDAO.createModule();
        m.setName("some module");
        m.setStartDate("10/8/72");
        m.setEndDate("10/4/74");
        m.setLinesOfCode(110);
        m.setUniqueIdentifier("module_somemodule");

        Subsystem ss = SubsystemDAO.createSubsystem();
        ss.setName("some subsystem");
        ss.setUniqueIdentifier("subsystem_somesub");
        ss.addModule(m);

        businesslogic.distribution.resource.System system = SystemDAO.createSystem();
        system.setName("some system");
        system.setUniqueIdentifier("system_somesys");
        system.setTechnologies("Web");
        system.addSubsystem(ss);

        Project project = ProjectDAO.createProject();
        project.setName("A big project");
        project.setUniqueIdentifier("project_someproj");
        project.setBudget(1000);
        project.addSystem(system);

        ServerProjectManagerLogicFacade.getInstance().registerProjectScale(userID, project);

    }

    public static void getResourceNames() {
        int userID = 1;
        ServerProjectManagerLogicFacade.getInstance().getResourceNames(userID, "Subsystem");
    }

    public static void getInformationResources() {
        int userID = 1;
        InformationResource[] informationResources = ServerProjectManagerLogicFacade.getInstance().getInformationResources(userID);
        for(InformationResource i : informationResources) {
            System.out.println(i.getName());
        }
    }

    public static void registerRequirement() {
        try {
            int userID = 1;
            int informationResourceID = 2;
            Requirement requirement = RequirementDAO.createRequirement();
            requirement.setStartDate("4/4/73");
            requirement.setEndDate("4/3/76");
            requirement.setQuantity(2);
            requirement.setResourceName("printer");
            requirement.setResourceType("PhysicalResource");
            requirement.setRequirementPriority(RequirementPriorityEnum.ORDINARY.ordinal());
            requirement.setInformationResource(ModuleDAO.getModuleByORMID(informationResourceID));
            ServerProjectManagerLogicFacade.getInstance().registerRequirement(userID, requirement);

            Requirement requirement2 = RequirementDAO.createRequirement();
            requirement2.setStartDate("6/6/66");
            requirement2.setEndDate("4/8/77");
            requirement2.setQuantity(1);
            requirement2.setResourceName("signed up user");
            requirement2.setResourceType("HumanResource");
            requirement2.setRequirementPriority(RequirementPriorityEnum.ESSENTIAL.ordinal());
            requirement2.setInformationResource(ModuleDAO.getModuleByORMID(informationResourceID));
            ServerProjectManagerLogicFacade.getInstance().registerRequirement(userID, requirement2);
        }
        catch(PersistentException ex) {
            ex.printStackTrace();
        }
    }

    public static void estimateResourceAllocation() {
        String[] technologies = new String[]{"Web", "Android"};
        InformationResource[] result = ServerProjectManagerLogicFacade.getInstance()
                .estimateResourceAllocations(technologies, null, null, 1000);
        for(InformationResource ir:result) {
            System.out.println(ir.getID());
        }
    }

    public static void assignModules() {
        int userID = 1;
        int projectInd = 0;
        int programmerInd = 0;
        int moduleInd = 0;

        Project[] projects = ServerProjectManagerLogicFacade.getInstance().getProjectList(userID);
        Project project = projects[projectInd];
        HumanResource[] programmers = ServerProjectManagerLogicFacade.getInstance().getProgrammers(project);
        Module[] modules = ServerProjectManagerLogicFacade.getInstance().getModules(project);

        HashMap<HumanResource, Module> assignments = new HashMap<>();
        assignments.put(programmers[programmerInd], modules[moduleInd]);
        ServerProjectManagerLogicFacade.getInstance().assignModules(assignments);
    }

    public static void registerNewResource() {
        int userID = 2;

        PhysicalResource resource = PhysicalResourceDAO.createPhysicalResource();

        resource.setName("printer");
        resource.setUniqueIdentifier("HP203757");
        resource.addSpec("Color", "CMYK");
        resource.addSpec("Rate", "20 PPM");

        ServerResourceManagerLogicFacade.getInstance().registerNewResource(userID, resource);

        FinancialResource resource2 = FinancialResourceDAO.createFinancialResource();

        resource2.setName("Building");
        resource2.setUniqueIdentifier("BS68");
        resource2.setFinancialValue(1000);

        System.out.println(ServerResourceManagerLogicFacade.getInstance().registerNewResource(userID, resource2).getContent());

    }

    public static void  predictEssentialResourceAllocations() {
        Project[] projects = ServerResourceManagerLogicFacade.getInstance().getAllProjectList();
        for(Project project:projects) {
            System.out.println(project.getName());
        }

        int projectInd = 0;
        InformationResource[] results = ServerResourceManagerLogicFacade.getInstance().predictEssentialResourceAllocations(projects[projectInd]);
        for(InformationResource project:results) {
            System.out.println(project.getName());
        }

    }

    public static void registerResourceAllocation() {
        int userID = 2;
        int reqIndex = 0;
        int resourceIndex = 0;
        Requirement[] requirements = ServerResourceManagerLogicFacade.getInstance().getRequirements(userID);

        Resource[] resources = ServerResourceManagerLogicFacade.getInstance().getResources(userID,
                "PhysicalResource", "printer");

        Allocation allocation = Allocation_DAO.createAllocation_();
        allocation.setRequirement(requirements[reqIndex]);
        allocation.addResources(resources);

        System.out.println(allocation.getRequirement().getResourceName());
        ServerResourceManagerLogicFacade.getInstance().registerResourceAllocation(userID, allocation, resources);

        int reqIndex2 = 1;
        int resourceIndex2 = 0;
        Requirement[] requirements2 = ServerResourceManagerLogicFacade.getInstance().getRequirements(userID);

        Resource[] resources2 = ServerResourceManagerLogicFacade.getInstance().getResources(userID,
                "HumanResource", "signed up user");

        Allocation allocation2 = Allocation_DAO.createAllocation_();
        allocation2.setRequirement(requirements2[reqIndex2]);
        allocation2.addResources(resources2);

        System.out.println(allocation2.getRequirement().getResourceName());
        ServerResourceManagerLogicFacade.getInstance().registerResourceAllocation(userID, allocation2, resources2);
    }

    private static void reportResources() {
        Report report = ServerResourceManagerLogicFacade.getInstance().reportResources();
        Table table = report.getTable();

        table.print();
    }

    private static void reportResourceRequirements() {
        int userID = 2;
        int informationResourceInd = 1;
        InformationResource[] informationResources = ServerResourceManagerLogicFacade.getInstance().getInformationResources(2);
        for(InformationResource i:informationResources) {
            System.out.println(i.getName());
        }
        System.out.println();
        Report report = ServerResourceManagerLogicFacade.getInstance()
                .reportResourceRequirements(informationResources[informationResourceInd].getID());
        Table table = report.getTable();
//
        table.print();
    }

    public static void reportFlowResourceAllocations() {
        int userID = 2;
        String resourceType = "PhysicalResource";
        int resourceNameInd = 0;
        int resourceInd = 0;

        String[] resourceNames = ServerResourceManagerLogicFacade.getInstance().getResourceNames(userID, resourceType);

        for(String name:resourceNames) {
            System.out.println(name);
        }

        Resource[] resources = ServerResourceManagerLogicFacade.getInstance()
                .getResources(userID, resourceType, resourceNames[resourceNameInd]);

        Date startDate = new Date();
        startDate.setYear(70);
        startDate.setMonth(4);
        startDate.setDay(4);

        Date endDate = new Date();
        endDate.setYear(79);
        endDate.setMonth(3);
        endDate.setDay(4);

        FlowReport report = ServerResourceManagerLogicFacade.getInstance().reportFlowResourceAllocations(resources[resourceInd], startDate, endDate);
        report.getTable().print();

    }

    public static void viewProfile() {
        int userID = 1;
        try {
            User user = UserDAO.getUserByORMID(userID);
            Tree<String> info = user.getJobInfo();
            info.print();
        } catch (PersistentException e) {
            e.printStackTrace();
        }


    }

    public static void sendEmail() {
        Email email = new Email("Hello!", "ehsan.silverman@gmail.com");
        try {
            email.send();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}