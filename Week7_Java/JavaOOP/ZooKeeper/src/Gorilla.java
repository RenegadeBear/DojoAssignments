
public class Gorilla extends Mammal{
	
	public Gorilla() {
	}
	
	public Integer displayEnergy() {
		System.out.println(getEnergyLevel());
		return getEnergyLevel();
	}
	
	public void throwSomething() {
		this.setEnergyLevel(this.getEnergyLevel() - 5);
		System.out.println("watch out for flying objects!");
		System.out.println(getEnergyLevel());
	}
	
	public void eatBananas() {
		this.setEnergyLevel(this.getEnergyLevel() + 10);
		System.out.println("yummy bananas, I am revitalized!");
		System.out.println(getEnergyLevel());
	}
	
	public void climb() {
		this.setEnergyLevel(this.getEnergyLevel() - 10);
		System.out.println("phew! Climbing trees is hard work");
		System.out.println(getEnergyLevel());
	}
	
}
