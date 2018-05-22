
public class Dragon extends Mammal{
	Integer energyLevel = 300;
	
	public Dragon() {
	}
	
	public Integer displayEnergy() {
		System.out.println(energyLevel);
		return energyLevel;
	}
	
	public void attackTown() {
		this.energyLevel -= 100;
		System.out.println("the horror!");
		System.out.println(energyLevel);
	}
	
	public void eatHumans() {
		this.energyLevel += 25;
		System.out.println("population control?");
		System.out.println(energyLevel);
	}
	
	public void fly() {
		this.energyLevel -= 50;
		System.out.println("wooooooooosh");
		System.out.println(energyLevel);
	}
}
