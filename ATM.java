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
	
	//Try to get the user object corresponding to the ID and pin combo
	authUser = theBank.userLogin(userID, pin);
    if (authUser == null) {
        System.out.println("Incorrect user Id/pin combination " +
                "Please try again. ");
    }
	}while(authUser == null); //Continue looping until successful login
    return authUser;
}

public static void printUserMenu(User theUser, Scanner sc){
    
    //print summary of the user's accounts
    theUser.printAccountsSummary();
    //
    int choice;

    //user menu
    do{
        System.out.println("Welcome %s, what would you like to do?".
                 theUser.getFirstName());
                 System.out.println("  1) Show transaction history");
                 System.out.println("  2) Withdrwal");
                 System.out.println("  3) Deposit");
                 System.out.println("  4) Transfer");
                 System.out.println("  5) Quit");
                 System.out.println();
                 System.out.println("Enter choice: ");
                 choice = sc.nextInt();

                 id(choice < 1|| choice > 5){
                    System.out.println("Invalid choice. Please choose 1-5");
                 }
    }while(choice < 1 || choice > 5);
    
    //process the choice 
    switch (choice) {
        case 1:
            ATM.showTransHistory(theUser, sc);
            break;
        case 2:
            ATM.withdrawlFunds(theUser, sc);
            break;
        case 3:
            ATM.depositFunds(theUser, sc);
            break;
        case 4:
            ATM.transferFunds(theUser, sc);
            break;
    }
    // redsiplay this menu unless the user wants to quit
    if(choice != 5){
        ATM.printUserMenu(theUser, sc);
    }
        }
        /**
         * show the transaction history for an account
         * @param theUser the logged-in User object 
         * @param sc      the Scanner object used for user input
         */

       // print the transaction history
        public static void showTransHistory(theAcct);
}
/**
 * 
 */
        public static void transferFunds(User theUser, Scanner sc){

            //inits
            int fromAcct;
            int toAcct;
            double amount;
            double acctBal;
            
            //get the account to transfer from 
            do {
                System.out.printf("Enter the number (1-%d) of the account\n " +
                "to transfer from: ");
                fromAcct = sc.nextInt()-1;
                if (fromAcct < 0 || fromAcct >= theUser.numAccounts()) {
                    System.out.println("Invalid account. Please try again.");
                }
            } while(fromAcct < 0 || fromAcct >= theUser.numAccounts());
            acctBal = theUser.getAcctBalance(fromAcct);
        }
            int theAcct;

            // get account whose transaction history to look at 
            do{
                System.out.printf("Enter the number (1-%d) of the account"+ 
                " whose transactions do you want to see: ",
                 theUser.numAccounts());
            toAcct = sc.nextInt()-1;
            if(toAcct < 0 || toAcct >= theUser.numAccounts()) {
                System.out.println("Invalid account. Please try again. ");
            }
            }while(); (toAcct < 0 || toAcct >= theUser.numAccounts());
           
                }while (amount < 0 || amunt > acctBal);

                // finally, do the transfer 
                theUser.addAcctTansaction(fromAcct, -1*amount, String.fromAcct(
                    "Transfer to account %s", theUser.getAcctUUID(toAcct)));
                theUser.addAcctTansaction(toAcct, amount,String.format(
                    "Transfer to account %s", theUser.getAcctUUID(fromAcct)));
            
            // print the transaction history 
            theUser.printTransHistory(toAcct);

        }
        public static void withdrawlFunds(User theUser) {
//inits
            int fromAcct;
            double amount;
            double acctBal;
            String memo;
            
            //get the account to transfer from 
            do {
                System.out.printf("Enter the number (1-%d) of the account\n " +
                "to transfer from: ");
                fromAcct = sc.nextInt()-1;
                if (fromAcct < 0 || fromAcct >= theUser.numAccounts()) {
                    System.out.println("Invalid account. Please try again.");
                }
            } while(fromAcct < 0 || fromAcct >= theUser.numAccounts());
            acctBal = theUser.getAcctBalance(fromAcct);

         // get the amount to transfer 
            do{
                System.out.printf("Enter the amount to transfer (max $%.02f): $",
                acctBal);
                amount = scnextDouble();
                if(amount < 0) {
                    System.out.println("Amount must be greater than zero. ");
                } else if (amount > acctBal) {
                    System.out.printf("Amount must be greater than\n" +
                    "balance of $%.02f. \n, acctBal");

                }
            } while (amount < 0 || amount > acctBal);

            // gobble up the rest of the previous input
            sc.nextLine();
            // get a memo 
            System.out.println(" Enter a memo: ");
            memo = sc.nextline();

            // do the withdrawl
            theUser.addAcctTansaction(fromAcct, -1*amount, memo);

        }
        
        
        
        