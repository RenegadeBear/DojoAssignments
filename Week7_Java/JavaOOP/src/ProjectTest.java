
public class ProjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Project x = new Project();
		Project y = new Project("y");
		Project abc = new Project("abc","alphabet");
		System.out.println(x.getName());
		System.out.println(y.getName());
		System.out.println(abc.elevatorPitch());
		System.out.println(abc.getDescription());
		
	}

}
