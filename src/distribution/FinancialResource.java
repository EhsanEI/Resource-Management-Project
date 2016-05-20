package distribution;

public class FinancialResource extends Resource {

	private int credit;
	private String name;

	public FinancialResource(int credit, String name, int id) {
		super(id);
		this.credit = credit;
		this.name = name;
	}
}