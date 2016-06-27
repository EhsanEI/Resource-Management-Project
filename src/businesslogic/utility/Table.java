package businesslogic.utility;

/**
 * Created by Esi on 6/23/2016.
 */
public class Table {
    private String[] headers;
    private String[][] contents;

    public Table(String[] headers, String[][] contents) {
        this.headers = headers;
        this.contents = contents;
    }

    public String[] getHeaders() {
        return headers;
    }

    public String[][] getContents() {
        return contents;
    }

    public void print() {
        for(String h:getHeaders()) {
            System.out.print(h + ", ");
        }

        for(String[] row:getContents()) {
            System.out.println();
            for(String i:row) {
                System.out.print(i + ", ");
            }
        }
    }
}
