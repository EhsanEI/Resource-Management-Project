package test;

import businesslogic.*;
import businesslogic.accounting.AuthenticationResult;
import businesslogic.accounting.ResourceManagement;
import businesslogic.accounting.ResourceManagementDAO;
import businesslogic.accounting.job.*;
import businesslogic.accounting.user.Employee;
import businesslogic.accounting.user.EmployeeDAO;
import businesslogic.accounting.user.User;
import businesslogic.accounting.user.UserDAO;
import businesslogic.distribution.requirement.Requirement;
import businesslogic.distribution.requirement.RequirementDAO;
import businesslogic.distribution.requirement.RequirementPriorityEnum;
import businesslogic.distribution.resource.*;
import businesslogic.utility.Date;
import businesslogic.utility.DateDAO;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import java.lang.System;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Esi on 6/25/2016.
 */
public class Main {
    public static void main(String[] args) throws PersistentException {
        PersistentTransaction t = businesslogic.accounting.user.OODPersistentManager.instance().getSession().beginTransaction();

//        signup();

//        registerProject();

//        registerRequirement();

//        registerNewResource();

        registerResourceAllocation();

        t.commit();
    }

    public static void test1() {
        Date d = DateDAO.createDate();
        d.setDay(0);
        d.setHour(0);
        d.setMinute(0);
        d.setMonth(0);
        d.setSecond(0);
        d.setYear(0);
        try {
            DateDAO.save(d);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }

    public static void test2() {
        try {
            Employee em = EmployeeDAO.createEmployee();
            em.setUsername("ali");
            em.setPassword("123");
            em.setEmail("e@a.com");
            EmployeeDAO.save(em);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }

    public static void test3() {
        try {
            Employee[] ems = EmployeeDAO.listEmployeeByQuery("Username = 'ali' and password = 123", null);
            System.out.println(ems.length);
            for(Employee em:ems) {
                System.out.println(em.getEmail());
            }


//            Employee[] ems = EmployeeDAO.listEmployeeByQuery("Username = 'ali'", null);
            Employee em = ems[0];

//            Permission per = PermissionDAO.createPermission();
//            per.setTitle("fuckdb");
//            PermissionDAO.save(per);

//            Permission per = PermissionDAO.listPermissionByQuery("Title = 'fuckdb'",null)[0];
//            PermissionDAO.delete(per);

            UserJob uj = UserJobDAO.createUserJob();

            Set<UserJob> ujs = new HashSet<UserJob>();
            ujs.add(uj);
            em.setORM_UserJobs(ujs);

            Programming pr = ProgrammingDAO.createProgramming();
            pr.setORM_UserJobs(ujs);

            UserJobDAO.save(uj);
            ProgrammingDAO.save(pr);
            EmployeeDAO.save(em);


        }catch(Exception ex) {
                ex.printStackTrace();
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
        f.recoverPassword("ali");
    }

    public static void signup() {

        Employee em = EmployeeDAO.createEmployee();
        em.setUsername("signed up user");
        em.setPassword("123");
        em.setEmail("e@a.com");

        ProjectManagement pm = ProjectManagementDAO.createProjectManagement();
        em.addJob(pm);

        Programming pr = ProgrammingDAO.createProgramming();
        em.addJob(pr);

        Specialty sp = SpecialtyDAO.createSpecialty();
        sp.setTitle("Android");
        sp.setProficiencyLevel(3);
        pr.addSpecialty(sp);

        Employee em2 = EmployeeDAO.createEmployee();
        em2.setUsername("user 2");
        em2.setPassword("123");
        em2.setEmail("e2@a.com");

        ResourceManagement rm = ResourceManagementDAO.createResourceManagement();
        em2.addJob(rm);

        Job[] jobs = {pm, pr};
        Specialty[] specialties = {sp};
        ServerAccountingLogicFacade.getInstance().signup(em, jobs, specialties);

        Job[] jobs2 = {rm};
        Specialty[] specialties2 = {};
        ServerAccountingLogicFacade.getInstance().signup(em2, jobs2, specialties2);

    }

    public static void approveUser() {
        User[] users = ServerManagerLogicFacade.getInstance().getUnapprovedUsers();
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
            int informationResourceID = 1;
            Requirement requirement = RequirementDAO.createRequirement();
            requirement.setStartDate("4/4/73");
            requirement.setEndDate("4/3/76");
            requirement.setQuantity(34);
            requirement.setResourceName("some module");
            requirement.setResourceType("Module");
            requirement.setRequirementPriority(RequirementPriorityEnum.ESSENTIAL.ordinal());
            requirement.setInformationResource(ModuleDAO.getModuleByORMID(informationResourceID));
            ServerProjectManagerLogicFacade.getInstance().registerRequirement(userID, requirement);
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
        Project[] projects = ServerProjectManagerLogicFacade.getInstance().getProjectList(userID);

        for(Project project: projects) {
            System.out.println(project.getName());
        }
    }

    public static void registerNewResource() {

        PhysicalResource resource = PhysicalResourceDAO.createPhysicalResource();

        resource.setName("printer");
        resource.setUniqueIdentifier("HP203756");
        resource.addSpec("Color", "CMYK");
        resource.addSpec("Rate", "20 PPM");

        int userID = 2;

        ServerResourceManagerLogicFacade.getInstance().registerNewResource(userID, resource);

    }

    public static void  predictEssentialResourceAllocations() {
        Project[] projects = ServerResourceManagerLogicFacade.getInstance().getAllProjectList();
        for(Project project:projects) {
            System.out.println(project.getName());
        }
        //TODO
    }

    public static void registerResourceAllocation() {
        int userID = 2;
        Requirement[] requirements = ServerResourceManagerLogicFacade.getInstance().getRequirements(userID);
        for (Requirement req: requirements) {
            System.out.println(req.getID());
        }

        Resource[] resources = ServerResourceManagerLogicFacade.getInstance().getRequirementResources(userID,
                "PhysicalResource", "printer");

        for(Resource resource:resources) {
            System.out.println(resource.getID());
        }
    }
}