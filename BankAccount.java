package lab7;
import java.text.DecimalFormat;
/**
 * BankAccount.java
 * Andy Ta
 * CST8132
 * Lab 7/Assignment 
 * Professor Anu Thomas/ Professor Angela Giddings
 */
/**
 * This acts as the super class of all bankAccounts
 * @author Andy
 * @version 1.0
 * @see java.text.DecimalFormat
 */
public abstract class BankAccount {
	/**
	 * stores the balance of the account
	 */
	protected double balance = 0;
	/**
	 * stores the account number 
	 */
	protected long accNumber;
	/**
	 * stores the Person of the bank account
	 */
	protected Person accHolder;
	
	/**
	 * Adds a bank account by asking the user information to create person object and parts of bankAccount
	 * @return will return true if information submitted is valid 
	 */
	public boolean addBankAccount() {
		//accNum is set outside the do while loop
		long accNum = 0;
		do {
			System.out.println("Enter an account number:");
			String accN = Bank.input.next();
			
			if (accN.length() <= 8) {
				try {
					//assigns the value of accN to accNum by parsing it to a long 
					accNum = Long.parseLong(accN);
					if (Bank.searchAccounts(accNum) != null) {
						//resets value of accNum back to 0, so that while loop will keep looping
						accNum = 0;
						System.out.println("Account number already in use. Please try again.");
					}
				} catch (Exception e) {
					accNum = 0;
					System.out.println("Invalid account number. Please try again.");
					
				}
			}
		
		} while (accNum == 0);
		
		accNumber = accNum;
		
		System.out.println("Enter an opening balance amount:");
		
		// if user does not enter a proper balance it will keep prompting error
		while (!Bank.input.hasNextDouble()) {
			System.out.println("Invalid opening balance amount. Please try again:");
			//this next statement will accept anything, it will be checked by the while statement
			Bank.input.next();
		}
		
		balance = Bank.input.nextDouble();
		
		System.out.println("Enter a first name:");
		String fName = Bank.input.next();
		
		System.out.println("Enter a last name:");
		String lName = Bank.input.next();
		
		long phoneNum = 0;
		do {
			System.out.println("Enter a phone number:");
			String pNum = Bank.input.next();
			
			if (pNum.length() == 7 || pNum.length() == 10) {
				try {
					phoneNum = Long.parseLong(pNum);
					
				} catch (Exception e) {
					phoneNum = 0;
					System.out.println("Invalid phone number. Please try again.");
				}
			}
		
		} while (phoneNum == 0);
		
		String email;
		do {
		System.out.println("Enter an email address:");
		email = Bank.input.next();
		
		}while(  !(email.contains("@")) ||  !(email.contains(".")) || email.indexOf("@")>email.indexOf(".")  );
			
		accHolder = new Person(lName, fName, phoneNum, email);
		
		return true;
	}
	/**
	 * Method used to return account number
	 * @return accNumber variable of the class
	 */
	public long getAccNumber() {
		return accNumber;
	}
	/**
	 * Method used to return account holder 
	 * @return account holder 
	 */
	public Person getAccHolder()  {
		return accHolder;
	}
	/**
	 * Method used to update the balance of the bank account
	 * @param amount accepts a double used for the transaction value 
	 */
	public void updateBalance(double amount) {
		if (amount < 0) {
			amount = Math.abs(amount);
			if (amount > balance) {
				System.out.println("Insufficient funds.");
				return;
			}
			balance -= amount;
		}
		else {
			balance += amount;
		}
	}
	/**
	 * This method overwrites the toString method to print object variables 
	 */
	public String toString() {
		
		DecimalFormat df = new DecimalFormat("$###,###.##");
		return "Account Number: " + accNumber + "  " + accHolder.toString() + "  Balance: " + df.format(balance);
		
	}
	/**
	 * abstract method that is defined in the child classes 
	 */
	public abstract void monthlyAccountUpdate();
	
}