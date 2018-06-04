package lab7;
/**
 * Person.java
 * Andy Ta
 * CST8132
 * Lab 7/Assignment 
 * Professor Anu Thomas/ Professor Angela Giddings
 */
/**
 * This class contains the constructor for the Person object and is used to initlize a Person object 
 * @author Andy Ta
 * @version 1.0
 */
public class Person {
	/**
	 * Stores the first name of Person
	 */
	private String firstName;
	/**
	 * Stores the last name of Person
	 */
	private String lastName;
	/**
	 * Stores the phone number of Person 
	 */
	private long phoneNumber;
	/**
	 * Stores the email address of Person 
	 */
	private String email;
	
	/**
	 * Class constructor
	 * @param firstName used to initialize firstName of Person
	 * @param lastName used to initlialize lastName of Person 
	 * @param phoneNumber used to initialize phoneNumber of Person 
	 * @param email used to initialize email of Person 
	 */
	public Person(String firstName, String lastName, long phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		
	}
	/**
	 * Getter method used to get name of person 
	 * @return name of person 
	 */
	public String getName() {
		return firstName + " " + lastName;
	}
	/**
	 * Getter method used to get phone number of person 
	 * @return phone number of person 
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * Getter method used to get email of person 
	 * @return email of person 
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Method used to format printing of toString
	 */
	public String toString() {
		return "Name: " + getName() + "  Phone: " + phoneNumber + "  Email: " + email;
		
	}
	
	
}

