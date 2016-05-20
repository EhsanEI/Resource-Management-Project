package distribution;

public class PhysicalResource extends Resource {

	private String name;
	private String[] specs;

	public PhysicalResource( String name, String[] specs, int id) {
		super(id);
		this.name = name;
		this.specs = specs;
	}

}