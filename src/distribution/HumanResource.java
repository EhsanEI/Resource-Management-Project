package distribution;

import accounting.User;

public class HumanResource extends Resource {

	private User user;
	private Speciality[] specialities;

	public HumanResource(User user, Speciality[] specialities, int id) {
		super(id);
		this.user = user;
		this.specialities = specialities;
	}
}