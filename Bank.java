package lab7;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Bank.java
 * Andy Ta
 * CST8132
 * Lab 7/Assignment 
 * Professor Anu Thomas/ Professor Angela Giddings
 */
/**
 * This class holds the array of Bank Accounts and calls the methods in chequing and savings
 * @author Andy Ta
 * @version 1.0
 * @see java.util.ArrayList
 * @see java.util.Scanner
 *
 */
public class Bank {
	/**
	 * Stores objects of BankAccount
	 */
	private static ArrayList<BankAccount> accounts;
	/**
	 * Used to initlize accounts size 
	 */
	private int maxSize;
	/**
	 * Counter variable used to keep track of the number of accounts that have been added 
	 */
	private int numAccounts;
	/**
	 * Static Scanner object 
	 */
	static Scanner input;
	/**
	 * No argument constructor that initlizes the array list to 1000 
	 */
	public Bank() {
		this(1000);
	}
	/**
	 * Class constructor used to initilize fields 
	 * @param bankSize accepts an int to initlize array list size
	 */
	public Bank(int bankSize) {
		numAccounts = 0;
		maxSize = bankSize;
		accounts = new ArrayList<BankAccount>(maxSize);
		input = new Scanner(System.in);
	}
	/**
	 * Method that creates the bankAccount objects and adds them into arrayOfAccounts
	 * @return either true or false depending if an object is created and added to the array
	 */
	public boolean addAccount() {
		
		char option = 'x';
		BankAccount newAccount = null;
		
		System.out.println("Enter details for account number " + (accounts.size() + 1));
		
		do { 
			
			System.out.println("Enter 'c' for Chequing, or 's' for Savings:");
			option = input.next().toLowerCase().charAt(0);
			
			switch (option) {
			case 'c':
				newAccount = new ChequingAccount();
				break;
			case 's':
				newAccount = new SavingsAccount();
				break;
			default:
				System.out.println("Invalid selection. Please try again.");
			}
	
		} while (option != 'c' && option != 's');
		
		if (newAccount.addBankAccount()) {
			accounts.add(newAccount);
			numAccounts += 1;
			return true;
		} 
		
		return false;
	}
	/**
	 * Method used to update account balance
	 */
	public void updateAccount() {
		
		BankAccount acc = findAccount();
		
		if (acc == null) {
			System.out.println("Account number requested not found.");
			return;
		}
		
		System.out.println("Enter an amount:");
		acc.updateBalance(input.nextDouble());
		
	}
	/**
	 * Method that displays an individual account 
	 * @return the values of the object by calling the overridden toString method 
	 */
	public String displayAccount() {
		//creates a BankAccount variable and assigns it to findAccount method
		BankAccount acc = findAccount();
		
		if (acc == null) {
			return "Account number requested not found.";
		}
		return acc.toString();
	}
	/**
	 * Method that prints all accounts 
	 */
	public void printAccountDetails() {
		
		for (BankAccount acc : accounts) {
			System.out.println(acc);
		}
		
	}
	/**
	 * Method that does the monthlyupdate 
	 */
	public void monthlyUpdate() {
		for (BankAccount acc : accounts) {
			acc.monthlyAccountUpdate();
		}
	}
	
	/**
	 * Method used to ask user for account number, calls searchAccounts method
	 * @return a long that is the matching account number
	 */
	public BankAccount findAccount() {
		
		System.out.println("Enter an account number: ");
		while (!input.hasNextLong()) {
			System.out.println("Invalid account number. Please try again:");
			input.next();
		}
		//will return the value given 
		return searchAccounts(input.nextLong());
	}
	/**
	 * Static method used to check if account number exists
	 * @param accNumToFind accepts a long has a reference to search 
	 * @return account number 
	 */
	public static BankAccount searchAccounts(long accNumToFind) {
		//assigns every accounts element to acc and iterates through them all
		for (BankAccount acc : accounts) {
			if (acc.getAccNumber() == accNumToFind)
				return acc;
		}
		return null;
	}
	/**
	 * Getter method used to get number of accounts 
	 * @return number of accounts
	 */
	public int getNumAccounts() {
		return numAccounts;
	}
	
}
