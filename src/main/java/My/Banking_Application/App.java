package My.Banking_Application;

import java.util.Scanner;

public class App 
{
	public static void main(String[] args) {
		
		Boolean program = true;
		
		String s;
		
		Scanner scan1 =  new Scanner(System.in); // for options
		Scanner scan2 = new Scanner(System.in); // for other inputs
		Scanner scan3 = new Scanner(System.in);
		Scanner scan4 = new Scanner(System.in);
		Scanner scan5 = new Scanner(System.in);
		
		Account objectAccount = new Account();
		
		while (program) {
			
			System.out.println("Here are the options");
			System.out.println(" O -> Open a new Account \n A -> Account Balance \n D -> Deposit Money");
			System.out.println(" W -> Withdraw Money \n E -> Exit ");
			
			s = scan1.nextLine();
			
			switch (s) {
			case "O": //Open New Account
				
				System.out.println("Please enter the first name: ");
				String fname = scan2.nextLine();
				System.out.println("Please enter the last name: ");
				String lname = scan3.nextLine();
				
				/*
				
				if (objectAccount.AccCheck(fname, lname)) {		// if AccCheck has status, then will have True return
										// means we will confirm the customer exist with same fname and lname
					
					//System.out.println("Sorry there is a customer under this name.\n Please try with different name! ");
					
				} else {
				
					System.out.println("there is no customer with this fname and lname please enter more info:");
					
					*/
				System.out.println("Please enter the phone number in xxxxxxxxxxx format");
				String phone_no = scan5.nextLine();
					
				Account.OpenAccount(fname, lname, phone_no);
				break;
				
			case "A": //Account Balance
				System.out.println("Please enter the Account_NO you wish to get the balance out: ");
				Integer acc_no = scan2.nextInt();
				Account.GetAccountBalance(acc_no);
				break;
				
			case "D": //Deposit Balance
				System.out.println("deposit balance");
				Integer amount_entered2 = null;
				Integer acc_no2 = null;
				System.out.println("Please enter the account no you wish to deposit:");
				acc_no2 = scan2.nextInt();
				System.out.println("Please enter the amount you wish to deposit into = ");
				amount_entered2 = scan3.nextInt();
				MoneyTransactions.DepositMoney(amount_entered2, acc_no2);
				break;
				
			case "W": //Withdraw Money
				System.out.println("withdraw");
				Integer amount_entered3 = null;
				Integer acc_no3 = null;
				System.out.println("Please enter the account no you wish to withdraw money:");
				acc_no3 = scan2.nextInt();
				System.out.println("Please enter the amount you wish to withdraw from account = ");
				amount_entered3 = scan3.nextInt();
				MoneyTransactions.WithdrawMoney(amount_entered3, acc_no3);
				break;
				
			case "E": //Exit
				System.out.println("exit --- BYE ---");
				program = false;
				break;

			default:
				System.out.println("Please enter a proper input O,A,D,W or E");
				break;
			}
			
		}
		
	}
}