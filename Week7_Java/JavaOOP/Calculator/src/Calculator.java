
public class Calculator implements Results, java.io.Serializable {
	private Double operandOne;
	private char operation;
	private Double operandTwo;
	private Double result;
	
	public Calculator() {
	}
	
	public Calculator(Double operandOne, char operation, Double operandTwo) {
		this.operandOne = operandOne;
		this.operation = operation;
		this.operandTwo = operandTwo;
	}

	public Double getOperandOne() {
		return operandOne;
	}
	public Double getOperandTwo() {
		return operandTwo;
	}
	public char getOperation() {
		return operation;
	}
	
	public void setOperandOne(Double one) {
		this.operandOne = one;
	}
	public void setOperandTwo(Double two) {
		this.operandTwo = two;
	}
	public void setOperation(char op) {
		this.operation = op;
	}
	

	
	public void performOperation() {
		if (this.getOperandOne() == null || this.getOperandTwo() == null) {
			System.out.println("Must set operandOne and operandTwo before performing Operation.");
		}
		else if (this.getOperation() != '+' && this.getOperation() != '-') {
			System.out.println("Operations limited to addition(+) and subtraction(-).");
		}
		else {
			if (operation == '+') {
				this.result = this.getOperandOne() + this.getOperandTwo();
			}
			else if (operation == '-') {
				this.result = this.getOperandOne() - this.getOperandTwo();
			}
		}		
	}
	
	public Double getResults() {
		return this.result;
	}

	
	
}
