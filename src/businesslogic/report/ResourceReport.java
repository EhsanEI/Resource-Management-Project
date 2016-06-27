package businesslogic.report;

import businesslogic.distribution.resource.Resource;
import businesslogic.distribution.resource.ResourceDAO;
import businesslogic.distribution.resource.ResourceStateEnum;
import businesslogic.utility.Date;
import businesslogic.utility.Table;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Esi on 6/23/2016.
 */
public class ResourceReport extends Report{
    public ResourceReport() {
        super();
    }

    public ResourceReport(String date) {
        super(date);
    }

    @Override
    public Table makeReport() throws PersistentException {
        PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();
        List<Object[]> result = session
                .createSQLQuery("SELECT Discriminator, UniqueIdentifier, Name2, ResourceState FROM Resource").list();

        String[] headers = new String[]{"Type", "Unique Identifier", "Name", "State"};
        String[][] contents = new String[result.size()][headers.length];
        for(int i = 0 ; i < result.size(); i++) {
            Object[] row = result.get(i);

            String[] tableRow = new String[headers.length];

            tableRow[0] = (String)row[0];
            tableRow[1] = (String)row[1];
            tableRow[2] = (String)row[2];
            tableRow[3] = (ResourceStateEnum.values()[(int)row[3]]).toString();

            contents[i] = tableRow;

        }

        Table table = new Table(headers, contents);
        setTable(table);
        return table;
    }


}
