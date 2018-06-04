package lab7;
/**
 * Assign7.java
 * Andy Ta
 * CST8132
 * Lab 7/Assignment 
 * Professor Anu Thomas/ Professor Angela Giddings
 */
/**
 * This class contains the main method, which contains the main menu of the program
 * @author Andy
 * @version 1.0
 */
public class Assign7 {
	/**
	 * Method that displays menu 
	 */
	public static void displayMenu() {
		
		System.out.println("a: Add new account");
		System.out.println("u: Update an account");
		System.out.println("d: Display an account");
		System.out.println("p: Print all accounts");
		System.out.println("m: Run monthly update");
		System.out.println("q: Quit");
		System.out.println("Enter an option:");
		
	}
	
	/**
	 * The main menu creates a bank object called bank and keeps calling displayMenu method until condition is met
	 * @param args Command line arguments. UNUSED.
	 */
	public static void main(String[] args) {
		
		Bank bank = new Bank(10);
		
		char option = 'x';
		
		do {
			
			displayMenu();
			
			option = Bank.input.next().toLowerCase().charAt(0);
			
			switch(option) {
			
			case 'a':
				bank.addAccount();
				break;
			case 'd':
				System.out.println(bank.displayAccount());
				break;
			case 'm':
				bank.monthlyUpdate();
				break;
			case 'p':
				bank.printAccountDetails();
				break;
			case 'q':
				break;
			case 'u':
				bank.updateAccount();
				break;
			default:
				System.out.println("Invalid selection. Please try again.");
			}
			
		} while (option != 'q');
		 
		Bank.input.close();
		
		System.out.println("Have a nice day!");
		
	}
	
}
