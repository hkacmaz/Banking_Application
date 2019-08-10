package My.Banking_Application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Account {
	
/*	public static boolean AccCheck(String f_name,String l_name) 

	{
		
		{		
			final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	        final String DB_URL = "jdbc:mysql://localhost:3307/bank_db";
	        final String USER = "root";
	        final String PASS = "mypassword";

	        Connection connection = null;
	        PreparedStatement pstmt = null;

	        String query = "SELECT fname,lname FROM client WHERE fname='halillll' AND lname='kacmaz';";
	        
	       
	        try {
	           Class.forName("com.mysql.cj.jdbc.Driver");
	           System.out.println("Connecting to database to check existing customer OR not ...");
	         
	                 connection = DriverManager.getConnection(DB_URL,USER,PASS);
	                 
	                 System.out.println("Connection is successfull!!!");
	                 
	                 System.out.println("Checking the fname and lname ...");
	                 
	                 pstmt = connection.prepareStatement(query);
	                 //pstmt.setString(1, f_name);
	                 //pstmt.setString(2, l_name);
	                 
	                 boolean status = pstmt.execute(query);
	                 
	                 System.out.println(status);

	                 return status;
	                 
	                
	           } catch (SQLException | ClassNotFoundException e) {
	                 // TODO Auto-generated catch block
	                 e.printStackTrace();
	           }
		}
		return false;
		
	}
*/

	public static void OpenAccount(String f_name, String l_name, String phone_no) {
		
		{
			final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	        final String DB_URL = "jdbc:mysql://localhost:3307/bank_db";
	        final String USER = "root";
	        final String PASS = "mypassword";
	        
	        Connection connection2 = null;
	        PreparedStatement pstmt2 = null;

	        String query2 = "INSERT INTO clients(fname, lname, phone)" + "VALUES (?, ?, ?)";
	        
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	System.out.println("Connectin to database to open an account...");

		        connection2 = DriverManager.getConnection(DB_URL,USER,PASS);
		        
		        System.out.println("Connection is succesfull!!!");
	        	
	        	pstmt2 = connection2.prepareStatement(query2);
	            pstmt2.setString(1, f_name);
	            pstmt2.setString(2, l_name);
	            pstmt2.setString(3, phone_no);
	            
	            int status = pstmt2.executeUpdate();
	            if(status > 0) {
	               System.out.println("Record is inserted successfully !!!");
	            }
				
			} catch (SQLException | ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
          }
			
		}
		
	}
	
	public static void GetAccountBalance(Integer account_no) {
		
		final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
        final String DB_URL = "jdbc:mysql://localhost:3307/bank_db";
        final String USER = "root";
        final String PASS = "mypassword";
        
        Connection connection3 = null;
        PreparedStatement pstmt3 = null;
        ResultSet rs = null;

        String query3 = "SELECT balance FROM balances WHERE account_ID=?";
        
        try {
        	Class.forName(JDBC_DRIVER);
        	
        	System.out.println("Connecting to database ...");
        	
        	connection3 = DriverManager.getConnection(DB_URL,USER,PASS);
        	
        	System.out.println("Connection successfull!!!");
        	
        	pstmt3 = connection3.prepareStatement(query3);
        	pstmt3.setInt(1, account_no);
        	
        	rs = pstmt3.executeQuery();
        	
        	System.out.println("querying ...");
        	
        	ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
        	int columnsNumber = rsmd.getColumnCount();
        	
        	while (rs.next()) {
        		System.out.println(rs.getFetchSize());
        	       for (int i = 1; i <= columnsNumber; i++) {
        	           if (i > 1) System.out.print(",  ");
        	           String columnValue = rs.getString(i);
        	           System.out.print(columnValue + " $");
        	       }
        	       System.out.println("");
        	   }
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        
		
	}
	
	

}
