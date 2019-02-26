package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String department;
	private int emailboxCapacity = 500;
	private int defaultPasswordLength = 9;
	private String alternateEmail;
	private String companySuffix = "imersja.pl";
	
	// Constructor to receive the first name and the last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		//System.out.println("Email created: " + this.firstName + " " + this.lastName);
		
		// Call the method asking for the department - return the department
		this.department = setDepartment();
		//System.out.println("Department: " + this.department);
		
		// Call the method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		
		// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		//System.out.println("Your email is: " + email);
	}
	// Ask for the department
	private String setDepartment() {
		System.out.println("New worker: " + firstName + "\nDEAPRTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 none\nEnter the department");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if (depChoice == 1) {
			return "sales";
		} else if (depChoice == 2) {
			return "dev";
		} else if (depChoice == 3) {
			return "account";
		} else return "";
	}
	
	//Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOQPRSTUWYZ0123456789@#$%^&*()<>?";
		char[] password = new char[length];
		for (int i=0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	// Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.emailboxCapacity = capacity;
	}
	
	// Set the alternate email
	public void setAlternateEmail(String alterEmail) {
		this.alternateEmail = alterEmail;
	}
	
	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() {
		return emailboxCapacity;
	}
	
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String showInfo() {
		return "Display name: " + firstName + " " + lastName +
				"\nCompany email: " + email +
				"\nMailbox capacity: " + emailboxCapacity + "MB";
	}
}
