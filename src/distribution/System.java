package distribution;

public class System extends InformationResource {

	private String[] technologies;
	private Subsystem[] subsystems;

	public System(String name, Requirement[] requirements, int id) {
		super(name, requirements, id);
	}
}