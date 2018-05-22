import java.util.ArrayList;
public class Portfolio {
	private String name;
	private ArrayList<Project> projects;


	//constructor
	public Portfolio(String name) {
	}
	public Portfolio(String name, ArrayList<Project> projects) {
		this.name = name;
		this.projects = projects;
	}
	
	
	//setters
	public void addPortfolioName(String name) {
		this.name = name;
	}
	public void addProject(Project name) {
		projects.add(name);
	}

	
	//getters
	public void showPortfolio() {
		for (Project project: this.projects) {
			System.out.println(project.elevatorPitch());
		}
		System.out.println(this.getPortfolioCost());
	}
	
	public Double getPortfolioCost() {
		Double portfolioCost = 0.0;
		for (Project project: this.projects) { 
			portfolioCost += project.getInitialCost();
		}
		return portfolioCost;
	}
	public String getPortfolioName() {
		return name;
	}
	
}
