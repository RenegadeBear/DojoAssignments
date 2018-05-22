
public class Human {
	protected Integer strength = 3;
	protected Integer intelligence = 3;
	protected Integer stealth = 3;
	protected Integer health = 100;
	
	public Human() {
	}
	
	public Integer getStrength() {
		System.out.println(strength);
		return strength;
	}
	public Integer getIntelligence() {
		System.out.println(intelligence);
		return intelligence;
	}
	public Integer getStealth() {
		System.out.println(stealth);
		return stealth;
	}
	public Integer getHealth() {
		System.out.println(health);
		return health;
	}
	public void getVitals() {
		System.out.println("Strength: " + strength + ", Intelligence: " + intelligence + ", Stealth: " + stealth + ", Health: " + health);
	}

	public Integer setStrength(Integer num) {
		this.strength += num;
		return this.strength;
	}
	public Integer setIntelligence(Integer num) {
		this.intelligence += num;
		return this.intelligence;
	}
	public Integer setStealth(Integer num) {
		this.stealth += num;
		return this.stealth;
	}
	public Integer setHealth(Integer num) {
		this.health += num;
		return this.health;
	}
	
	

	
	public void attack(Human x) {
//		health -=  x.getStealth();
//		System.out.println("You've been attacked!  Health is now " + health);
		x.setHealth(-this.stealth);
		System.out.println("You've attacked" + x + "! His health is now:" + x.getHealth());
	}
}
