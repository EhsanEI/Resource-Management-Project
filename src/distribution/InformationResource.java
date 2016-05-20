package distribution;

public class InformationResource extends Resource {

	private String name;
	private Requirement[] requirements;

	public InformationResource(String name, Requirement[] requirements, int id) {
		super(id);
		this.name = name;
		this.requirements = requirements;
	}
}