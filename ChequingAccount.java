package lab7;
import java.text.DecimalFormat;
/**
 * ChequingAccount.java
 * Andy Ta
 * CST8132
 * Lab 7/Assignment 
 * Professor Anu Thomas/ Professor Angela Giddings
 */
/**
 * This class extends BankAccount is used to create a chequings account
 * @author Andy Ta
 * @see java.text.DecimalFormat
 */
public class ChequingAccount extends BankAccount {
	/**
	 * Stores the monthlyFee of the ChequingAccount
	 */
	private double fee;
	
	/**
	 * Method that calls the super addBankAccount method and initializes fields
	 */
	public boolean addBankAccount() {
		
		if (!super.addBankAccount()) {
			return false;
		}
			
		System.out.println("Enter a monthly fee:");
		while(!Bank.input.hasNextDouble()) {
			System.out.println("Invalid monthly fee. Please try again");
			Bank.input.next();
		}
		fee = Bank.input.nextDouble();
			
		return true;
		
	}
	/**
	 * Method that processes the monthly transaction 
	 */
	public void monthlyAccountUpdate() {
		DecimalFormat df = new DecimalFormat("$###,###.##");
		if (balance > fee) {
			balance -= fee;
			System.out.println("Accounts have been updated");
		}
		else
			System.err.println("Insufficent funds to charge " + df.format(fee) + " on account " + accNumber + ".");
	}
	/**
	 * Method used to format printing of toString
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("$###,###.##");
		return super.toString() + "  Fee: " + df.format(fee);
		
	}	
	
}
