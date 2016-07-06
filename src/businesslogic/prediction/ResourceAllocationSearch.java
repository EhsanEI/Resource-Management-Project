package businesslogic.prediction;

import businesslogic.distribution.resource.InformationResource;
import businesslogic.distribution.resource.Project;
import businesslogic.utility.Table;

/**
 * Created by Esi on 6/23/2016.
 */
public abstract class ResourceAllocationSearch {
    private InformationResource[] results;

    public ResourceAllocationSearch() {
    }

    public InformationResource[] getResults() {
        return results;
    }

    public void setResults(InformationResource[] results) {
        this.results = results;
    }

    public abstract InformationResource[] search();

}
