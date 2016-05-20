package distribution;

public class Project extends InformationResource {

	private int budget;
	private System[] systems;

	public Project(String name, Requirement[] requirements, int id) {
		super(name, requirements, id);
	}
}