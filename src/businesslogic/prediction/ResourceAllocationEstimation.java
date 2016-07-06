package businesslogic.prediction;

import businesslogic.distribution.resource.InformationResource;
import businesslogic.distribution.resource.InformationResourceDAO;
import businesslogic.utility.Date;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import orm.OODPersistentManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Esi on 7/6/2016.
 */
public class ResourceAllocationEstimation extends ResourceAllocationSearch {
    String[] technologies;
    Date startDate;
    Date endDate;
    int budget;

    public ResourceAllocationEstimation(String[] technologies, Date startDate, Date endDate, int budget) {
        super();
        this.technologies = technologies;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    @Override
    public InformationResource[] search() {
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

            PersistentSession session = OODPersistentManager.instance().getSession();
            List<Integer> resultIDs = session.createSQLQuery(condition.toString()).list();

            ArrayList<InformationResource> result = new ArrayList<>();
            for(Integer id:resultIDs) {
                result.add(InformationResourceDAO.getInformationResourceByORMID(id));
            }
            setResults(result.toArray(new InformationResource[result.size()]));
            return getResults();
        }
        catch(PersistentException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
