package distribution;

public class Subsystem extends InformationResource {

	private Module[] modules;

	public Subsystem(String name, Requirement[] requirements, int id) {
		super(name, requirements, id);
	}
}