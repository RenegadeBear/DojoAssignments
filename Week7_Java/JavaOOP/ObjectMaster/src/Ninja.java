
public class Ninja extends Human{
	
	public Ninja() {
		// TODO Auto-generated constructor stub
		this.setStealth(7);
	}

	public void steal(Human x){
		x.setHealth(-this.getStealth());
		this.setHealth(this.getStealth());
		}
	
	public void runAway() {
		this.setHealth(-10);
	}
	
	}
