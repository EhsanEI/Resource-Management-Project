package businesslogic.report;

import businesslogic.distribution.requirement.RequirementPriorityEnum;
import businesslogic.distribution.resource.InformationResource;
import businesslogic.distribution.resource.InformationResourceDAO;
import businesslogic.distribution.resource.ResourceStateEnum;
import businesslogic.utility.Date;
import businesslogic.utility.Table;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.util.List;

/**
 * Created by Esi on 6/23/2016.
 */
public class ResourceRequirementReport  extends Report{
    private InformationResource informationResource;
    public ResourceRequirementReport(int informationResourceID) throws PersistentException{
        super();
        informationResource = InformationResourceDAO.getInformationResourceByORMID(informationResourceID);
    }

    public ResourceRequirementReport(Date date, int informationResourceID) throws PersistentException{
        super(date);
        informationResource = InformationResourceDAO.getInformationResourceByORMID(informationResourceID);
    }

    @Override
    public Table makeReport() throws PersistentException{
        PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();


        List<Object[]> result = session
                .createSQLQuery("SELECT ResourceName, Quantity, StartDate, EndDate, RequirementPriority FROM Requirement").list();

        String[] headers = new String[]{"Resource", "Quantity", "StartDate", "EndDate", "RequirementPriority"};
        String[][] contents = new String[result.size()][headers.length];
        for(int i = 0 ; i < result.size(); i++) {
            Object[] row = result.get(i);

            String[] tableRow = new String[headers.length];

            tableRow[0] = (String)row[0];
            tableRow[1] = ""+row[1];
            tableRow[2] = (String)row[2];
            tableRow[3] = (String)row[3];
            tableRow[4] = (RequirementPriorityEnum.values()[(int)row[4]]).toString();

            contents[i] = tableRow;

        }

        Table table = new Table(headers, contents);
        setTable(table);
        return table;

    }
}
