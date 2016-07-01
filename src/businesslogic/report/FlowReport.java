package businesslogic.report;

import businesslogic.distribution.Allocation;
import businesslogic.distribution.Allocation_DAO;
import businesslogic.distribution.requirement.Requirement;
import businesslogic.distribution.resource.InformationResource;
import businesslogic.distribution.resource.InformationResourceDAO;
import businesslogic.distribution.resource.Resource;
import businesslogic.utility.Table;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Esi on 6/23/2016.
 */
public class FlowReport  extends Report{
    private Resource resource;
    private String startDate;
    private String endDate;

    public FlowReport(Resource resource, String startDate, String endDate) {
        super();
        this.resource = resource;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public FlowReport(Resource resource, String startDate, String endDate, String date) {
        super(date);
        this.resource = resource;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    @Override
    public Table makeReport() throws PersistentException{
        PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();

        //Can be done easier with join
        List<Integer> allocationIDs = session
                .createSQLQuery("SELECT [Allocation ID] FROM ResourceAllocation WHERE ResourceID2 = " + resource.getID()).list();

        String[] headers = new String[]{"Information Resource Name", "Start Date", "End Date"};

        ArrayList<String[]> contentsList = new ArrayList<>();
        for(Integer allocationID:allocationIDs) {
            Requirement requirement= Allocation_DAO.getAllocation_ByORMID(allocationID).getRequirement();

            DateFormat df = new SimpleDateFormat("dd/mm/yy");

            Date reqStartDate = null;
            Date reqEndDate = null;
            Date startDate = null;
            Date endDate = null;
            try {
                reqStartDate = df.parse(requirement.getStartDate());
                reqEndDate = df.parse(requirement.getEndDate());
                startDate = df.parse(getStartDate());
                endDate = df.parse(getEndDate());
            } catch (ParseException e) {
                //TODO really do something here
                return null;
            }

            if(reqStartDate.after(endDate) || reqEndDate.before(startDate)) {
                continue;
            }

            Integer informationResourceID = (Integer) session
                    .createSQLQuery("SELECT ResourceID2 FROM Requirement WHERE ID = "+ allocationID).uniqueResult();
            InformationResource informationResource = InformationResourceDAO.getInformationResourceByORMID(informationResourceID);

            String[] row = new String[headers.length];

            row[0] = informationResource.getName();
            row[1] = requirement.getStartDate();
            row[2] = requirement.getEndDate();

            contentsList.add(row);

        }

        String[][] contents = new String[contentsList.size()][headers.length];
        for(int i =0 ; i < contentsList.size();i++) {
            contents[i] = contentsList.get(i);
        }

        Table table = new Table(headers, contents);
        setTable(table);
        return table;
    }
}
