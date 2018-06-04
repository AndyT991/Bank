package lab7;
import java.text.DecimalFormat;
/**
 * SavingsAccount.java
 * Andy Ta
 * CST8132
 * Lab 7/Assignment 
 * Professor Anu Thomas/ Professor Angela Giddings
 */
/**
 * This class extends BankAccount and is used to create savings account 
 * @author Andy Ta
 * @see java.text.DecimalFormat
 */

public class SavingsAccount extends BankAccount {
	/**
	 * Stores the interest rate of savingsAccount object 
	 */
	double interestRate;
	/**
	 * Stores the minimum balance of savingsAccount object 
	 */
	double minimumBalance;
	
	/**
	 * Method that calls the addBankAccount method using super, to initilize variables
	 */
	public boolean addBankAccount() {
		
		if (!super.addBankAccount()) {
			return false;
		}
		
		System.out.println("Enter an interest rate: ");
		while(!Bank.input.hasNextDouble()) {
			System.out.println("Invalid interest rate, please try again");
			Bank.input.next();
		}
		interestRate = Bank.input.nextDouble();
		
		System.out.println("Enter a minimum balance: ");
		while(!Bank.input.hasNextDouble()) {
			System.out.println("Invalid minimum balance, please try again");
		}
		minimumBalance = Bank.input.nextDouble();
		
		return true;
	}
	/**
	 * Method that processes the monthly transaction
	 */
	public void monthlyAccountUpdate() {
		
		DecimalFormat df = new DecimalFormat("$###,###.##");		
		
		if (balance > minimumBalance)
			balance += balance * interestRate;
		else
			System.err.println("Minimum balance of " + df.format(minimumBalance) + " on account " + accNumber + " not met.");
	}
	/**
	 * Method used to format printing of toString
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("$###,###.##");
		return super.toString() + "  Interest Rate: " + interestRate + "%  Minimum Balance: " + df.format(minimumBalance);
		
	}
}
