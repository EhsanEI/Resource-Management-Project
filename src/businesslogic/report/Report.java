package businesslogic.report;

import businesslogic.utility.Date;
import businesslogic.utility.Table;
import org.orm.PersistentException;

import java.text.SimpleDateFormat;

/**
 * Created by Esi on 6/23/2016.
 */
public abstract class Report {
    private Date date;
    private Table table;

    public Report() {
        this.date = new Date(new java.util.Date());
    }

    public Report(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public abstract Table makeReport() throws PersistentException;
}
