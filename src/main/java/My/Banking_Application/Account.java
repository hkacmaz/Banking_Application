package My.Banking_Application;

import java.math.BigInteger;
import java.util.Scanner;

public class Account {
	

	private int account_number = 123456789;
	private double balance = 50.0;
	private String customer_name = "Halil";
	private String email = "asdf@asdf.com";
	private int phone_number = 415770;
	private int daily_limit=0;

	
	public void Account() {
		
		System.out.println("Here is the account summary");
		System.out.println("Account No: " + account_number);
		System.out.println("Current Balance: "+ balance);
		System.out.println("Account Holder: "+ customer_name);
		System.out.println("Email: "+ email);
		System.out.println("Phone Number: "+ phone_number);
		
	}
	
	public void Account_Balance() {
		
		System.out.println("Current Balance is= $ "+ this.balance);
		
	}
	
	public void Deposit_Balance(int deposited_amount) {
		System.out.println("The requested amount to deposit is= $"+ deposited_amount);
		this.balance += deposited_amount;
		System.out.println("The new balance is= $"+ this.balance );
		
	}
	
	public void Withdraw_Money(int withdrawn_amount) {
		
		System.out.println("The requested amount to withdrawn is= $"+ withdrawn_amount);
		
		if ((this.daily_limit <= 100) && (withdrawn_amount <= this.balance)) {
			this.daily_limit += withdrawn_amount;
			this.balance -= withdrawn_amount;
			System.out.println("Remaining balance in your account is= $"+this.balance);
		}
		else {
			System.out.println("Sorry you have exceeded the daily withdraw limit!");
		}
		
		
	}

}
