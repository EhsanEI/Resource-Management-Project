package accounting;

import java.util.List;

public class Job {

	private String title;
	private List<String> permissions;

	public Job(String title, List<String> permissions) {
		this.title = title;
		this.permissions = permissions;
	}

	public List<String > getPermissions(){
		return  permissions;
	}

	public boolean addPermission(String permission){
		if( permission != null)
			permissions.add(permission);
		else
			return false;
		return true;

	}
}