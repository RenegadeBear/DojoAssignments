import java.util.ArrayList;

public class ExecptionsAndGenerics {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Object> myList = new ArrayList<Object>();
		myList.add("13");
		myList.add("hello world");
		myList.add(48);
		myList.add("Goodbye World");
		System.out.println(myList);
		Integer castedVal0 = (Integer) 13;
		System.out.println(castedVal0);
//		Integer castedVal1 = (Integer) "hello world";
//		System.out.println(castedVal1);
		Integer castedVal2 = (Integer) 48;
		System.out.println(castedVal2);
//		Integer castedVal3 = (Integer) "Goodbye World";
//		System.out.println(castedVal3);
		
		for (int i = 0; i < myList.size(); i++) {
			try {
				@SuppressWarnings("unused")
				Integer x = (Integer) myList.get(i);
				System.out.println(myList.get(i) + " Successfully cast to Integer.");
			}
			catch (Exception e) {
				System.out.println("Unable to cast " + myList.get(i) + " to Integer.");
			}
		}
		
	}

}
