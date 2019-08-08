package My.Banking_Application;

import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Boolean program = true;
		
		String s;
		
		Scanner scan1 =  new Scanner(System.in); // for options
		Scanner scan2 = new Scanner(System.in); // for other inputs
		
		Account account_object = new Account();
		
		while (program) {
			
			System.out.println("Here are the options");
			System.out.println(" A -> Account Balance \n D -> Deposit Balance \n W -> Withdraw Money \n S -> Account Summary \n E -> Exit ");
			
			s = scan1.nextLine();
			
			switch (s) {
			case "A": //Account Balance
				account_object.Account_Balance();
				break;
				
			case "D": //Deposit Balance
				System.out.println("deposit balance");
				int amount_entered = 0;
				System.out.println("Please enter the amount you wish to deposit into = ");
				amount_entered = scan2.nextInt();
				account_object.Deposit_Balance(amount_entered);
				break;
				
			case "W": //Withdraw Money
				System.out.println("withdraw");
				int amount_to_withdraw=0;
				System.out.println("Please enter the amount you wish to withdraw= ");
				amount_to_withdraw = scan2.nextInt();
				account_object.Withdraw_Money(amount_to_withdraw);
				break;
				
			case "S": //Account Summary
				System.out.println("summary");
				account_object.Account();
				break;
				
			case "E": //Exit
				System.out.println("exit --- BYE ---");
				program = false;
				break;

			default:
				System.out.println("Please enter a proper input A,D,W or E");
				break;
			}
			
		}
		
	}
}