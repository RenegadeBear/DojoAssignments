
import java.util.Random;


public class BankAccount {
	private String accountNumber;
	private Double checkingBalance;
	private Double savingsBalance;
	private Double totalBalance;
	public static int numOfAccounts = 0;
	public static Double totalMoney = 0.0;
	
	public BankAccount(Double check) {
		this.accountNumber = generateAccountNumber();
		this.checkingBalance = check;
		this.totalBalance = check;
		numOfAccounts += 1;
		totalMoney += check;
	}
	public BankAccount(Double check, Double save) {
		this.accountNumber = generateAccountNumber();
		this.checkingBalance = check;
		this.savingsBalance = save;
		this.totalBalance = check + save;
		numOfAccounts += 1;
		totalMoney += check; 
		totalMoney += save;
	}
	
	
	private String generateAccountNumber() {
		String SALTCHARS = "0123456789";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while(salt.length() <10) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
//		System.out.println(saltStr);
		return saltStr;
	}
	
	public String getAccountNumber() {
		System.out.println("Account Number: " + accountNumber);
		return this.accountNumber;
	}
	public Double getCheckingBalance() {
		System.out.println("Checking Balance: " + this.checkingBalance);
		return this.checkingBalance;
	}
	public Double getSavingsBalance() {
		System.out.println("Savings Balance: " + this.savingsBalance);
		return this.savingsBalance;
	}
	public Double getTotalBalance() {
		System.out.println("Your Total Balance:" + this.totalBalance);
		return this.totalBalance;
	}
	public static Double getTotalMoney() {
		System.out.println("Total Money Held in All Bank Accounts: " + totalMoney);
		return totalMoney;
	}
	public static int getNumOfAccounts() {
		System.out.println("Total Accounts at Bank: " + numOfAccounts);
		return numOfAccounts;
	}
	
	public void depositChecking(Double amt) {
		setCheckingBalance(amt);
	}
	public void depositSavings(Double amt) {
		setSavingsBalance(amt);
	}
	public void withdrawalChecking(Double amt) {
		setCheckingBalance(-amt);
	}
	public void withdrawalSavings(Double amt) {
		setSavingsBalance(-amt);
	}
	
//	public void setTotalMoney() {
//		totalMoney = this.checkingBalance + this.savingsBalance;
//		System.out.println("Total Money: " + totalMoney);
//	}
	public void setTotalBalance() {
		if (this.savingsBalance != null) {
			this.totalBalance = this.checkingBalance + this.savingsBalance;
		}
		else {
			this.totalBalance = this.checkingBalance;
		}
		System.out.println("Your Total Balance: " + totalBalance);
	}
	public void setCheckingBalance(Double amt) {
		if (this.checkingBalance + amt > 0) {
			this.checkingBalance += amt;
			System.out.println("Checking Balance: " + this.checkingBalance);
			this.setTotalBalance();
			totalMoney += amt;
		}
		else {
			System.out.println("Insufficient Funds");
		}
	}
	
	public void setSavingsBalance(Double amt) {
		if (this.savingsBalance + amt > 0) {	
			this.savingsBalance += amt;
			System.out.println("Savings Balance: " + this.savingsBalance);
			this.setTotalBalance();
			totalMoney += amt;
		}
		else {
			System.out.println("Insufficient Funds");
		}
	}
	
}
