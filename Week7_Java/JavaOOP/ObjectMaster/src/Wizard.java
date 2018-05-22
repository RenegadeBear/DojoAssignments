
public class Wizard extends Human {

	public Wizard() {
		// TODO Auto-generated constructor stub
		this.setHealth(-50);
		this.setIntelligence(5);
	}

	public void heal(Human x){
		x.setHealth(this.getIntelligence());
		}
	
	public void fireball(Human y) {
		y.setHealth(-this.getIntelligence()*3);
	}

}
