package project;

import java.util.ArrayList;

public class Account {
	private String name;
	private  String uuid; 
	private User holder;
	private ArrayList<Transaction> transactions;
	
	public Account(String name, User holder, Bank theBank) {
		this.name=name;
		this.holder=holder;
		
		
		//get new account UUID
		this.uuid=theBank.getNewUserUUID();
		
		//init transactions 
		this.transactions= new ArrayList<Transaction>();
		 
	}
/**
 * get the account ID
 * @return the uuid
 */
	public String getUUID() {
		return this.uuid;
	}
public String getSummaryLine() {
    // get the account's balance 
    double balance = this.getBalance();
    
    //format the summary line, depending on the Whether the balance is 
    //negative 
    if (balance >= 0) {
        return String.format("%s : $%.03f : %s", this.uuid, balance, 
        this.name);
    } else {
        return String.format("%s : $(%.02f) : %s", this.uuid, balance,
        this.name);
    }
    }
    /**
     * get the balance of this account by adding the amounts of the transactions
     * @return the balance value  
     */
    public double getBalance(){
        double balance = 0;
        for (Transaction t : this.transactions) {
            balance += t.getAmount();
        }
        return balance;
    }
    /** 
     * Print the transaction history of the account
    */
   public printTransHistory() {

    System.out.printf("\nTransaction history for account %s\n", this.uuid);
    for (int t = this.transactions.size()-1; t>= 0; t--) {
        System.out.printf(this.transactions.get(t).getSummaryLine());
    }
    System.out.println();
   }
   /**
    * add a new transaction in this account
    * @param amount the amount transacted 
    * @param memo the transaction memo
    */
   public void addTansaction(double amount, String memo) {
    // create new transaction onject and add it to our list
    Transaction newTrans + new Transaction(amount, memo, this);
    this.transactions.add(newTrans);
   }
}

