
public class FizzBuzz {

	public String fizzBuzz(int number) {
		// TODO Auto-generated method stub
		String fizz = "";
		String buzz = "";
		String num = Integer.toString(number);
		if (number%3 == 0) {
			fizz = "Fizz";
		}
		if (number%5 == 0) {
			buzz = "Buzz";
		}
		if (fizz == "Fizz" || buzz == "Buzz") {
			return fizz + buzz;
		}
		return num;
	}

}
