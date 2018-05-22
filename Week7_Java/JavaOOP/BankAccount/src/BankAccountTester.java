
public class BankAccountTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount mine = new BankAccount(15000.00 , 1000000.00);
		BankAccount yours = new BankAccount (300.00);
		BankAccount theirs = new BankAccount(25632.79, 97468.32);
	
		mine.getTotalBalance();
		yours.getTotalBalance();
		theirs.getTotalBalance();
		BankAccount.getTotalMoney();
		mine.withdrawalChecking(5000.00);
		mine.withdrawalChecking(12000.00);
		mine.getTotalBalance();
		yours.depositChecking(150.00);
		
		mine.depositChecking(50.00);
		
		BankAccount.getNumOfAccounts();
	}

}
