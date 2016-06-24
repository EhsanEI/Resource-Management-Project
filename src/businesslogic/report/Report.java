package businesslogic.report;

import businesslogic.utility.Date;
import businesslogic.utility.Table;

/**
 * Created by Esi on 6/23/2016.
 */
public abstract class Report {
    private Date date;

    public Report(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract Table makeReport();
}
