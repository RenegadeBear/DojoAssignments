
public class Project {
	private String name;
	private String description;
	private Double initialCost;
		// TODO Auto-generated method stub

	
	//constructors
	public Project() {
	}
	public Project(String name) {
		this.name = name;
	}
	public Project(String name, String description) {
		this.name = name;
		this.description = description;
	}

	//getters
	public String elevatorPitch() {
		return this.name + " (" + this.initialCost + "): " + this.description;
	}
	public String getName() {
		return this.name;
		
	}
	public String getDescription() {
		return this.description;
	}
	public Double getInitialCost() {
		return this.initialCost;
	}
	
	//setters
	public void setName(String nombre) {
		name = nombre;
	}
	public void setDescription(String desc) {
		description = desc;
	}
	public void setInitialCost(Double amt) {
		initialCost = amt;
	}
	
}
