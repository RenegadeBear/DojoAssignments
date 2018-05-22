
public class Pokemon {
	private String name;
	private Integer health;
	private String type;
	public static Integer count = 0;
	
	
	//constructor
	public Pokemon(String name, Integer health, String type) {
		this.name = name;
		this.health = health;
		this.type = type;
//		this.setName(name);
//		this.setHealth(health);
//		this.setType(type);
		count += 1;
	}
	
	//getters
	public String getName() {
		return this.name;
	}
	public Integer getHealth() {
		return this.health;
	}
	public String getType() {
		return this.type;
	}
	
	//setters
	public void setName(String name) {
		this.name = name;
	}
	public void setHealth(Integer health) {
		this.health += health;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
