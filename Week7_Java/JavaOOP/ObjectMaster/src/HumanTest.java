
public class HumanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human a = new Human();
		Human b = new Human();
//		a.attack(b);
//		a.getVitals();
//		b.getVitals();
//		
//		Wizard w= new Wizard();
//		w.getVitals();
//		w.heal(a);
//		a.getVitals();
//		w.fireball(b);
//		b.getVitals();
//		w.getVitals();
//		Wizard z= new Wizard();
		
		Ninja n = new Ninja();
		n.getVitals();

		n.steal(b);
		n.getVitals();
		b.getVitals();
		Ninja j = new Ninja();
		j.runAway();
		j.getVitals();
		
		
//		Samurai s = new Samurai();
//		s.getVitals();
//		Samurai r = new Samurai();
//		r.howMany();
//		r.meditate();
//		r.getVitals();
//		r.deathBlow(a);
//		a.getVitals();
//		r.getVitals();
	}

}
