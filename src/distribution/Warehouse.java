package distribution;

import java.lang.*;
import java.lang.System;
import java.util.ArrayList;
import java.util.List;

public class Warehouse {

	private List<Resource> resources;

	private static Warehouse instance;

	private Warehouse(){
		resources = new ArrayList<>();
	}

	public static  Warehouse getInstance() {
		if (instance == null) {
			instance = new Warehouse();
		}
		return instance;
	}

	public Resource getResource(int id){
		for(Resource resource : resources) {
			if (resource.getId() == id)
				return resource;
		}
		return  null;

	}

	public boolean addResource(Resource resource) {
		if(resource != null)
			resources.add(resource);
		else
			return false;
		return true;
	}

}