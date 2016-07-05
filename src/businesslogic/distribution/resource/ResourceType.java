package businesslogic.distribution.resource;

/**
 * Created by qizilbash on 7/4/2016.
 */
public enum ResourceType {
    PHYSICAL("Physical Resource"),
    FINANCIAL("Financial Resource"),
    HUMAN("Human Resource"),
    INFORMATION("Human Resource");

    private String title;

    public String getTitle() {
        return title;
    }

    ResourceType(String title) {
        this.title = title;
    }
}
