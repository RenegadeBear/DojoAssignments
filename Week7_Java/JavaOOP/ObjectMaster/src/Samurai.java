
public class Samurai extends Human{
	private static Integer counter =0;
	
	public Samurai() {
		// TODO Auto-generated constructor stub
		this.setHealth(100);
		counter ++;
		
	}
	
	public void deathBlow(Human x) {
		x.setHealth(-x.getHealth());
		x.setStealth(-x.getStealth());
		x.setIntelligence(-x.getIntelligence());
		x.setStrength(-x.getStrength());
		this.setHealth(-this.getHealth()/2);
	}
	
	public void meditate() {
		this.setHealth(this.getHealth()/2);
	}
	
	public void howMany() {
		System.out.println(counter);
	}
}
