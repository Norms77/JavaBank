package project;

import java.util.ArrayList;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
	private String firstName;
	private String lastName;
	private String uuid;
	private byte pinHash[];
	private ArrayList<Account> accounts;
	
	public User( String firstName, String lastName, String pin, Bank theBank ){
		this.firstName=firstName;
		this.lastName=lastName;

		try {
			MessageDigest md= MessageDigest.getInstance("MD5");
			this.pinHash=md.digest(pin.getBytes());
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Error, caugth NoSuchAlgorithmException ");
			e.printStackTrace();
			System.exit(1);
		}
		
	//get a new,unique universal ID for the user
	this.uuid=theBank.getNewUserUUID();
	
	//Create empty list of accounts 
	this.accounts= new ArrayList<Account>();
	
	
	System.out.printf("New user %s, %s with ID %s created.\n", lastName, firstName, this.uuid);
	
	}
	public void addAccount(Account anAcct) {
		this.accounts.add(anAcct); 
	}
	public String getUUID() {
		return this.uuid;
	}
	public boolean validatePin(String aPin) {
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			return MessageDigest.isEqual(md.digest(aPin.getBytes()), this.pinHash);
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Error, caugth NoSuchAlgorithmException ");
			e.printStackTrace();
			System.exit(1);
		}
		return false;
	}
    /**
     * return the user's first name.
     * @return the first name 
     */
public String getFirstName(){
    this.firstName
}
public void printAccountsSummary(){

    System.out.printf("\n\n%s's accounts summary", this.firstName);
    for (int a = 0; a < this.accounts.size(); a++) {
        System.out.printf("%d) $s\n", a+1, 
        this.account.get(a).getSummaryLine());
    }
    System.out.println();
    }
    /**
     * Get the number of accounts of the user 
     * @return this.accounts.size();
     * 
     */
    public int numAccounts() {
        return this.accounts.size();

    }
    public void printAcctTransHistory(int acctIdx){
        this.accounts.get(acctIdx).printTransHistory();
    }
    /**
     * get the balance of  a particular account 
     * @param acctIdx   the index of the account to use 
     * @return          the balance of the account
     */
    public double getAcctBalance(int acctIdx) {
        return this.accounts.get(acctIdx).getBalance();
    }
}

