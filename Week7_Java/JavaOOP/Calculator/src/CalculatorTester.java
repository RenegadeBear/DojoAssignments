
public class CalculatorTester {

	public static void main(String[] args) {
		Calculator a = new Calculator();
		a.setOperandOne(10.5);
		a.setOperation('+');
		a.setOperandTwo(5.2);
		a.performOperation();
		System.out.println(a.getResults());
		
		Calculator b = new Calculator(7.1, '-', 5.2);
		b.performOperation();
		System.out.println(b.getResults());
		
		Calculator c = new Calculator();
		c.setOperandOne(10.5);
		c.setOperation('*');
		c.setOperandTwo(5.2);
		c.performOperation();
		System.out.println(c.getResults());
		
	}
}
