import java.util.ArrayList;

public class CalculatorII implements Results {
	private ArrayList<Double> numbers = new ArrayList<Double>();
	private ArrayList<String> operations = new ArrayList<String>(); 
	private Double 
	
	public CalculatorII() {
	}
	
	public void performOperation(Double number) {
		numbers.add(number);
	}
	
	public void performOperation(String operation) {
		operations.add(operation);
	}
	
	
	
	public Double getResults() {
		for (String op: operations) {
			if (op == "*" || op == "/") {
				if(op == "*") {
					Double product = numbers[i] * numbers[i+1];
					this.results += product; 
				}
				else if(op =="/") {
					Double quotient = numbers[i] / numbers [i+1];
					this.results += quotient;
				}
			}
		}
		for (String op: operations) {
			else if (op == "+" || op == "-") {
				if (op == "+") {
					Double sum = numbers[i] + numbers[i+1];
					this.results += sum;
				}
				if (op == "-") {
					Double difference = numbers[i] - numbers[i+1];
					this.results -= difference;
				}
			}
		}
		
		return this.results;
	}
	
	
	
	
	
	
}
