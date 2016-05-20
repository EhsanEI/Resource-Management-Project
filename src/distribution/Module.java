package distribution;

public class Module extends InformationResource {

	private int loc;
	private int hours;
	private Speciality[] specialities;
	private String state;

	public Module(String name, Requirement[] requirements, int id) {
		super(name, requirements, id);
	}

}