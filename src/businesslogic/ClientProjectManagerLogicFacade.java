package businesslogic;

import businesslogic.distribution.requirement.Requirement;
import businesslogic.distribution.resource.*;
import businesslogic.utility.Date;
import businesslogic.utility.Notification;
import network.ClientNetwork;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Esi on 6/22/2016.
 */
public class ClientProjectManagerLogicFacade implements ProjectManagerLogicInterface{

    private static ClientProjectManagerLogicFacade instance;

    private static ClientNetwork clientNetwork;

    private ClientProjectManagerLogicFacade() {
    }

    public static ClientProjectManagerLogicFacade getInstance() throws IOException {
        if(instance == null) {
            instance = new ClientProjectManagerLogicFacade();
            clientNetwork = ClientNetwork.getInstance();
        }
        return instance;
    }

    @Override
    public Notification assignModules(Map<HumanResource, Module> assignments) {
        return null;
    }

    @Override
    public Notification registerProjectScale(int UserID, Project newProject) {
        return null;
    }

    @Override
    public InformationResource[] estimateResourceAllocations(String[] technologies, Date startDate, Date endDate, int budget) {
        return new Project[0];
    }

    @Override
    public Notification registerRequirement(int userID, Requirement newRequirement) {
        return null;
    }

    @Override
    public Project[] getProjectList(int userID) {
        return new Project[0];
    }

    @Override
    public HumanResource[] getProgrammers(Project project) {
        return new HumanResource[0];
    }

    @Override
    public Module[] getModules(Project project) {
        return new Module[0];
    }

    @Override
    public InformationResource[] getInformationResources(int userID) {
        return new InformationResource[0];
    }

    @Override
    public String[] getResourceNames(int userID, String resourceType) {
        return new String[0];
    }
}
