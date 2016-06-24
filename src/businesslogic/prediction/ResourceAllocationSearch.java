package businesslogic.prediction;

import businesslogic.utility.Table;

/**
 * Created by Esi on 6/23/2016.
 */
public class ResourceAllocationSearch {
    private Table resourceAllocationsHierearchy;

    public ResourceAllocationSearch(Table resourceAllocationsHierearchy) {
        this.resourceAllocationsHierearchy = resourceAllocationsHierearchy;
    }

    public Table getResourceAllocationsHierearchy() {
        return resourceAllocationsHierearchy;
    }

}
