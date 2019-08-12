package My.Banking_Application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MoneyTransactions {
	/*
	 * Deposit Money
	 * Withdraw Money
	 */
	
	final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    final static String DB_URL = "jdbc:mysql://localhost:3307/bank_db";
    final static String USER = "root";
    final static String PASS = "mypassword";
	
	public static void DepositMoney(Integer amount_entered, Integer account_no) {
		
        Connection connection = null;
        PreparedStatement pstmt = null;


        String query = "UPDATE balances SET balance=balance+? WHERE account_ID=?";
        
        try {
        	Class.forName(JDBC_DRIVER);
        	
        	System.out.println("Connecting to database ...");
        	
        	connection = DriverManager.getConnection(DB_URL,USER,PASS);
        	
        	System.out.println("Connection successfull!!!");
        	
        	pstmt = connection.prepareStatement(query);
        	pstmt.setInt(1, amount_entered);
        	pstmt.setInt(2, account_no);
        	
        	pstmt.executeUpdate();
        	
        	System.out.println("Successfully deposited.");
        	
        	Account.GetAccountBalance(account_no);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
public static void WithdrawMoney(Integer amount_entered2, Integer account_no2) {
		
        Connection connection2 = null;
        PreparedStatement pstmt2 = null;


        String query2 = "UPDATE balances SET balance=CAST(balance AS SIGNED)-CAST(? AS SIGNED) WHERE account_ID=?";
        
        try {
        	Class.forName(JDBC_DRIVER);
        	
        	System.out.println("Connecting to database ...");
        	
        	connection2 = DriverManager.getConnection(DB_URL,USER,PASS);
        	
        	System.out.println("Connection successfull!!!");
        	
        	pstmt2 = connection2.prepareStatement(query2);
        	pstmt2.setInt(1, amount_entered2);
        	pstmt2.setInt(2, account_no2);
        	
        	pstmt2.executeUpdate();
        	
        	System.out.println("Successfully withdrawn.");
        	
        	Account.GetAccountBalance(account_no2);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
