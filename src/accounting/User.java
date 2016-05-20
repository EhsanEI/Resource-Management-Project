package accounting;

import distribution.Resource;
import distribution.Warehouse;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String firstname;
	private String lastname;
	private List<Job> jobs;

	public User(String firstname, String lastname, List<Job> jobs) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.jobs = jobs;
	}

	public String[] getPermissions() {
		List<String> permissions = new ArrayList<>();
		for (Job job : jobs)
			for (String permission : job.getPermissions())
				permissions.add(permission);
		return permissions.toArray(new String[permissions.size()]);
	}

	public String getFisrtName(){
		return  firstname;
	}

	public String getLastname(){
		return lastname;
	}

	public Job[] getJobs(){
		return jobs.toArray(new Job[jobs.size()]);
	}

	public boolean addJob(Job job){
		if(job != null) {
			jobs.add(job);
		}else{
			return  false;
		}
		return true;
	}

	public boolean addNewResource(Resource resource){
		if (resource != null)
			Warehouse.getInstance().addResource(resource);
		else
			return false;
		return  true;
	}
}