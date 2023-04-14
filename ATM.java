package project;

import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
	    Bank theBank=new Bank("Bank of Drausin ");
	    
	    //add a user, which also create a savings account 
	    User aUser = theBank.addUser("John","Doe","1234");
	    
	    //add a checking account for our user
	    Account newAccount = new Account("Checking", aUser, theBank); 
	    aUser.addAccount(newAccount);
	    theBank.addAccount(newAccount);
	    
	    User curUser;
	    while(true) {
	    	//stay in the login prompt until successful login
	    	curUser = ATM.main(theBank, sc);
	    	
	    	//stay in main menu until user quits 
	    	ATM.printUserMenu(curUser, sc);
	    	
	    	
	    	
	    	//(MINUTO 56:00)
	    }
	}
public static User mainMenuPrompt(bank theBank, Scanner sc) {
	String userID;
	String pin;
	User authUser;
	
	//prompt the user for user ID/pin combo until a correct is reached
	do{
	System.out.printf("\n\nWelcome to %s\n\n", theBank.getName()); 
        System.out.print("Enter user ID: ");
	userID = nextLine():
		System.out.print("Enter pin");
		pin = sc.nextLine();
	}while();
	//Try to get the user object corresponding to the ID and pin combo
	authUser = 
	}
