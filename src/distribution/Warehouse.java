package distribution;

import java.util.List;

public class Warehouse {

	private List<Resource> resources;

	private static Warehouse instance = new Warehouse();

	private Warehouse(){}

	public static  Warehouse getInstance() {
		return instance;
	}

	public boolean addResource(Resource resource) {
		if(resource != null)
			resources.add(resource);
		else
			return false;
		return true;
	}

}