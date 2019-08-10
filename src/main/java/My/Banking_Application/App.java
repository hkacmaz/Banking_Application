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
			System.out.println(" O -> Open a new Account \n A -> Account Balance \n D -> Deposit Balance");
			System.out.println(" W -> Withdraw Money \n S -> Account Summary \n E -> Exit ");
			
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
				System.out.println("Please enter the phone number in xxxxxx format");
				String phone_no = scan5.nextLine();
					
				objectAccount.OpenAccount(fname, lname, phone_no);

				
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